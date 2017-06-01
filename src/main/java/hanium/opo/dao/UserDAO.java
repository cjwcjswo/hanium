package hanium.opo.dao;

import java.util.List;

import hanium.opo.dto.UserDTO;

public interface UserDAO {
	int userInsert(UserDTO userDTO);
	int userDelete(String userId);
	List<UserDTO> userSelectAll();
	UserDTO selectUser(UserDTO userDTO);
}
