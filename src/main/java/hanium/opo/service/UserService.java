package hanium.opo.service;

import java.util.List;

import hanium.opo.dto.UserDTO;

public interface UserService {
	int userInsert(UserDTO userDTO);
	int userDelete(String userId);
	List<UserDTO> userSelectAll();
	String checkId(UserDTO userDTO);
	UserDTO login(UserDTO userDTO);
	UserDTO selectUser(UserDTO userDTO);
}
