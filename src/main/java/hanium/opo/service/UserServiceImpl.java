package hanium.opo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanium.opo.dao.UserDAO;
import hanium.opo.dto.UserDTO;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;
	@Override
	public int userInsert(UserDTO userDTO) {
		return userDAO.userInsert(userDTO);
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
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public String checkId(UserDTO userDTO){
		UserDTO dto = userDAO.selectUser(userDTO);
		if(dto == null){
			return "사용 할 수 있습니다";
		}else{
			return "중복입니다";
		}
	}

	@Override
	public UserDTO login(UserDTO userDTO) {
		return userDAO.selectUser(userDTO);
		
	}

}
