package hanium.opo.dao;

import java.util.List;

import hanium.opo.dto.BoardDTO;

public interface NoticeBoardDAO {
	List<BoardDTO> selectAll(int page);
	BoardDTO select(int boardNum);
	int insert(BoardDTO dto);
	int delete(int boardNum);
	int update(BoardDTO dto);
	int readUp(int boardNum);
	int countReply(int boardNum);
	int count();
}
