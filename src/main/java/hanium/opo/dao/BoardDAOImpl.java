package hanium.opo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hanium.opo.dto.BoardDTO;
@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession session;
	@Override
	public List<BoardDTO> selectAll(int page) {
		return session.selectList("mapper.boardMapper.select", 0, new RowBounds((page-1)*10, 10)); 
	}

	@Override
	public BoardDTO select(int boardNum) {
		return session.selectOne("mapper.boardMapper.select", boardNum);
	}

	@Override
	public int insert(BoardDTO dto) {
		return session.insert("mapper.boardMapper.insert", dto);
	}

	@Override
	public int delete(int boardNum) {
		return session.delete("mapper.boardMapper.delete", boardNum);
	}

	@Override
	public int update(BoardDTO dto) {
		return session.update("mapper.boardMapper.update", dto);
	}

	@Override
	public int readUp(int boardNum) {
		return session.update("mapper.boardMapper.readUp", boardNum);
	}

	@Override
	public int countReply(int boardNum) {
		return session.selectOne("mapper.boardMapper.countReply", boardNum);
	}
	
	@Override
	public int count(){
		return session.selectOne("mapper.boardMapper.count");
	}
}
