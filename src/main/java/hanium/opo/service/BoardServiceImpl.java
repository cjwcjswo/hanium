package hanium.opo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hanium.opo.dao.BoardDAO;
import hanium.opo.dto.BoardDTO;
@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;
	@Override
	public List<BoardDTO> selectAll(int page) {
		return boardDAO.selectAll(page);
	}

	@Override
	public BoardDTO select(int boardNum, boolean state) throws Exception{
		if(state){
			int result = boardDAO.readUp(boardNum);
			if(result < 1) throw new Exception("접근 오류!");
		}
		return boardDAO.select(boardNum);
	}

	@Override
	public int insert(BoardDTO dto) throws Exception{
		int result = boardDAO.insert(dto);
		if(result < 1) throw new Exception("글쓰기 실패!");
		return result;
	}

	@Override
	public int delete(int boardNum) throws Exception{
		int result = boardDAO.delete(boardNum);
		if(result < 1) throw new Exception("삭제 실패!");
		return result;
	}

	@Override
	public int update(BoardDTO dto) throws Exception{
		int result = boardDAO.update(dto);
		if(result < 1) throw new Exception("수정 실패!");
		return result;
	}

	@Override
	public int countReply(int boardNum) {
		return boardDAO.countReply(boardNum);
	}
	
	@Override
	public int count(){
		return boardDAO.count();
	}
}
