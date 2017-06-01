package hanium.opo.service;

import java.util.List;

import hanium.opo.dto.ReplyDTO;

public interface ReplyService {
	List<ReplyDTO> select(int boardNum);
	int delete(int replyNum) throws Exception;
	int insert(ReplyDTO dto) throws Exception;
}
