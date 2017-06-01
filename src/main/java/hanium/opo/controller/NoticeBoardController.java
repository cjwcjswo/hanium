package hanium.opo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hanium.opo.dto.BoardDTO;
import hanium.opo.dto.ReplyDTO;
import hanium.opo.dto.UserDTO;
import hanium.opo.page.PageMaker;
import hanium.opo.service.NoticeBoardService;
import hanium.opo.service.NoticeReplyService;

@Controller
@RequestMapping("/notice")
public class NoticeBoardController {
	@Autowired
	NoticeBoardService service;
	@Autowired
	NoticeReplyService replyService;
	
	@RequestMapping("/list")
	public ModelAndView board(HttpServletRequest request, Integer page){
		if(page == null) page = new Integer(1);
		ModelAndView mv = new ModelAndView();
		PageMaker pm = new PageMaker(page, service.count() / 10 + 1);
		pm.start();
		System.out.println("pmL: " + pm.getLastPage());
		mv.addObject("list", service.selectAll(page));
		mv.addObject("pm", pm);
		mv.setViewName("notice/list");
		return mv;
	}
	@RequestMapping("/read/{boardNum}")
	public ModelAndView read(HttpServletRequest request,
			@PathVariable int boardNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", service.select(boardNum, true));
		mv.addObject("replyList", replyService.select(boardNum));
		mv.setViewName("notice/detail");
		return mv;
	}

	@RequestMapping("/write")
	public ModelAndView write(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		UserDTO dbUser = (UserDTO)session.getAttribute("user");
		if(dbUser == null){
			throw new Exception("로그인하세요!");
		}
		if(dbUser.getAuth() != 0){
			throw new Exception("관리자만 작성 할 수 있습니다!");
		}
		mv.setViewName("notice/write");
		
		return mv;
	}
	
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request, BoardDTO dto) throws Exception{
		HttpSession session = request.getSession();
		UserDTO dbUser = (UserDTO)session.getAttribute("user");
		if(dbUser == null){
			return "success/success";
		}
		dto.setPassword(dbUser.getUserPw());
		dto.setUserId(dbUser.getUserId());
		dto.setUserName(dbUser.getUserName());
		System.out.println(dto);
		service.insert(dto);
		return "redirect:/notice/list";
	}
	@RequestMapping("/delete/{userId}/{boardNum}")
	public String delete(HttpServletRequest request,
			@PathVariable String userId,
			@PathVariable int boardNum) throws Exception{
		HttpSession session = request.getSession();
		UserDTO dbUser = (UserDTO)session.getAttribute("user");;
		if(!dbUser.getUserId().equals(userId)){
			throw new Exception("작성자가 아닙니다");
		}
		service.delete(boardNum);
		return "redirect:/notice/list";
	}
	
	@RequestMapping("/update/{userId}/{boardNum}")
	public String update(HttpServletRequest request,
			@PathVariable String userId,
			@PathVariable int boardNum,
			BoardDTO boardDTO) throws Exception{
		HttpSession session = request.getSession();
		UserDTO dbUser = (UserDTO)session.getAttribute("user");;
		if(!dbUser.getUserId().equals(userId)){
			throw new Exception("작성자가 아닙니다");
		}
		boardDTO.setBoardNum(boardNum);
		service.update(boardDTO);
		return "redirect:/notice/list";
	}
	@RequestMapping("/reply/delete/{userId}/{boardNum}/{replyNum}")
	public String deleteReply(HttpServletRequest request,
			@PathVariable int replyNum,
			@PathVariable int boardNum,
			@PathVariable String userId) throws Exception{
		HttpSession session = request.getSession();
		UserDTO dbUser = (UserDTO)session.getAttribute("user");
		if(!dbUser.getUserId().equals(userId)){
			throw new Exception("작성자가 아닙니다");
		}
		replyService.delete(replyNum);
		return "redirect:/notice/read/"+boardNum;
	}
	@RequestMapping("/insertReply")
	public String insertReply(HttpServletRequest request, ReplyDTO dto) throws Exception{
		HttpSession session = request.getSession();
		UserDTO dbUser = (UserDTO)session.getAttribute("user");
		if(!dbUser.getUserId().equals(dto.getUserId())){
			throw new Exception("접근 오류!");
		}
		dto.setUserName(dbUser.getUserName());
		replyService.insert(dto);
		return "redirect:/notice/read/"+dto.getBoardNum();
	}
}
