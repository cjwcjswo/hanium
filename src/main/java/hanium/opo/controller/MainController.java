package hanium.opo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hanium.opo.dto.UserDTO;
import hanium.opo.service.UserService;

@Controller
public class MainController {
	@Autowired
	UserService userService;
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	@RequestMapping("/main")
	public String main(){
		return "main/main";
	}
	@RequestMapping("/signUp")
	public String signUp(){
		return "user/signup";
	}
	@RequestMapping("/juso")
	public String juso(){
		return "jusoPopup";
	}
	@RequestMapping("/join")
	public ModelAndView join(UserDTO dto){
		ModelAndView mv = new ModelAndView();
		if(dto.getUserId() == null || dto.getUserName() == null
				|| dto.getPhone() == null || dto.getEmail() == null
				|| dto.getUserPw() == null || dto.getAddr() == null){
			System.out.println(dto);
			mv.addObject("message", "������ ���� �����Դϴ�.");
			mv.setViewName("success/success");
			return mv;
		}
		dto.setAuth(1);
		userService.userInsert(dto);
		mv.addObject("message", "������ �����մϴ�!");
		mv.setViewName("success/success");
		return mv;
	}
	@RequestMapping(value="/checkId", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String checkId(UserDTO userDTO){
		return userService.checkId(userDTO);
	}
	@RequestMapping(value="/login", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String login(HttpSession session, UserDTO userDTO){
		UserDTO result = userService.login(userDTO);
		if(result == null){
			return "ȸ�������� ��ġ���� �ʽ��ϴ�.";
		}else{
			session.setAttribute("user", result);
			return "OK";
		}
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/main";
	}
	@RequestMapping("/{url}")
	public void turn(){
	}
}
