package hanium.opo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hanium.opo.dao.NoticeBoardDAO;
import hanium.opo.dto.BoardDTO;
@Service
@Transactional
public class NoticeBoardServiceImpl implements NoticeBoardService {
	@Autowired
	NoticeBoardDAO noticeBoardDAO;
	@Override
	public List<BoardDTO> selectAll(int page) {
		return noticeBoardDAO.selectAll(page);
	}

	@Override
	public BoardDTO select(int boardNum, boolean state) throws Exception{
		if(state){
			int result = noticeBoardDAO.readUp(boardNum);
			if(result < 1) throw new Exception("접근 오류!");
		}
		return noticeBoardDAO.select(boardNum);
	}

	@Override
	public int insert(BoardDTO dto) throws Exception{
		int result = noticeBoardDAO.insert(dto);
		if(result < 1) throw new Exception("글쓰기 실패!");
		return result;
	}

	@Override
	public int delete(int boardNum) throws Exception{
		int result = noticeBoardDAO.delete(boardNum);
		if(result < 1) throw new Exception("삭제 실패!");
		return result;
	}

	@Override
	public int update(BoardDTO dto) throws Exception{
		int result = noticeBoardDAO.update(dto);
		if(result < 1) throw new Exception("수정 실패!");
		return result;
	}

	@Override
	public int countReply(int boardNum) {
		return noticeBoardDAO.countReply(boardNum);
	}
	
	@Override
	public int count(){
		return noticeBoardDAO.count();
	}
}
