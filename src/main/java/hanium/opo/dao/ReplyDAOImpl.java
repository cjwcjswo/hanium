package hanium.opo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hanium.opo.dto.ReplyDTO;
@Repository
public class ReplyDAOImpl implements ReplyDAO {
	@Autowired
	SqlSession session;
	@Override
	public List<ReplyDTO> select(int boardNum) {
		return session.selectList("mapper.replyMapper.select", boardNum);
	}

	@Override
	public int delete(int replyNum) {
		return session.delete("mapper.replyMapper.delete", replyNum);
	}
	
	@Override
	public int insert(ReplyDTO dto){
		return session.insert("mapper.replyMapper.insert", dto);
	}

}
