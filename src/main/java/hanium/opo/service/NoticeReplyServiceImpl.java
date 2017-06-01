package hanium.opo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hanium.opo.dao.NoticeReplyDAO;
import hanium.opo.dto.ReplyDTO;
@Service
@Transactional
public class NoticeReplyServiceImpl implements NoticeReplyService {
	@Autowired
	NoticeReplyDAO noticeReplyDao;
	@Override
	public List<ReplyDTO> select(int boardNum) {
		return noticeReplyDao.select(boardNum);
	}

	@Override
	public int delete(int replyNum) throws Exception{
		int result = noticeReplyDao.delete(replyNum);
		if(result < 1) throw new Exception("�ۼ��ڰ� �ƴմϴ�!");
		return result;
	}
	
	@Override
	public int insert(ReplyDTO dto) throws Exception{
		int result = noticeReplyDao.insert(dto);
		if(result < 1) throw new Exception("��� �ޱ� ����!");
		return result;
	}
}
