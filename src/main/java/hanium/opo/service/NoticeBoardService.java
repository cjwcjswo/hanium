package hanium.opo.service;

import java.util.List;

import hanium.opo.dto.BoardDTO;

public interface NoticeBoardService {

	List<BoardDTO> selectAll(int page);

	BoardDTO select(int boardNum, boolean state) throws Exception;

	int insert(BoardDTO dto) throws Exception;

	int delete(int boardNum) throws Exception;

	int update(BoardDTO dto) throws Exception;

	int countReply(int boardNum);
	
	int count();
}
