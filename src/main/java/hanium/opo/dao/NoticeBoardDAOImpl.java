package hanium.opo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hanium.opo.dto.BoardDTO;
@Repository
public class NoticeBoardDAOImpl implements NoticeBoardDAO {
	@Autowired
	SqlSession session;
	@Override
	public List<BoardDTO> selectAll(int page) {
		return session.selectList("mapper.noticeBoardMapper.select", 0, new RowBounds((page-1)*10, 10)); 
	}

	@Override
	public BoardDTO select(int boardNum) {
		return session.selectOne("mapper.noticeBoardMapper.select", boardNum);
	}

	@Override
	public int insert(BoardDTO dto) {
		return session.insert("mapper.noticeBoardMapper.insert", dto);
	}

	@Override
	public int delete(int boardNum) {
		return session.delete("mapper.noticeBoardMapper.delete", boardNum);
	}

	@Override
	public int update(BoardDTO dto) {
		return session.update("mapper.noticeBoardMapper.update", dto);
	}

	@Override
	public int readUp(int boardNum) {
		return session.update("mapper.noticeBoardMapper.readUp", boardNum);
	}

	@Override
	public int countReply(int boardNum) {
		return session.selectOne("mapper.noticeBoardMapper.countReply", boardNum);
	}
	
	@Override
	public int count(){
		return session.selectOne("mapper.noticeBoardMapper.count");
	}
}
