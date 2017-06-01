package hanium.opo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hanium.opo.dao.ReplyDAO;
import hanium.opo.dto.ReplyDTO;
@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	ReplyDAO dao;
	@Override
	public List<ReplyDTO> select(int boardNum) {
		return dao.select(boardNum);
	}

	@Override
	public int delete(int replyNum) throws Exception{
		int result = dao.delete(replyNum);
		if(result < 1) throw new Exception("작성자가 아닙니다!");
		return result;
	}
	
	@Override
	public int insert(ReplyDTO dto) throws Exception{
		int result = dao.insert(dto);
		if(result < 1) throw new Exception("댓글 달기 실패!");
		return result;
	}
}
