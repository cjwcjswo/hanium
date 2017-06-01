package hanium.opo.dao;

import java.util.List;

import hanium.opo.dto.ReplyDTO;

public interface NoticeReplyDAO {
	List<ReplyDTO> select(int boardNum);
	int delete(int replyNum);
	int insert(ReplyDTO dto);
}
