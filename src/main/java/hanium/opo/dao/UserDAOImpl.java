package hanium.opo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hanium.opo.dto.UserDTO;
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	SqlSession session;
	@Override
	public int userInsert(UserDTO userDTO) {
		return session.insert("mapper.userMapper.userInsert", userDTO);
	}

	@Override
	public int userDelete(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserDTO> userSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO selectUser(UserDTO userDTO) {
		return session.selectOne("mapper.userMapper.selectUser", userDTO);
	}

}
