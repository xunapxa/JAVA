package service;

import java.util.List;

import crudInterface.CRUDInterface;
import dao.VMachineDAO;
import dto.UserDTO;
import entity.User;

public class VMachineService implements VMServiceInterface {
	CRUDInterface dao = new VMachineDAO();
	
	@Override
	public int newUser(UserDTO dto) {
		if(dto == null) {
			return -1;
		} else {
			return dao.insertUser(UserDTO.fromEntity(dto));
		}
	}

	@Override
	public String findID(String u_id) {
		return dao.findID(u_id);
	}

	@Override
	public int findPW(String u_pw) {
		return dao.findPW(u_pw);
	}

	@Override
	public List<User> userAll() {
		List<User> userList = dao.userAll();
		return userList;
	}

}
