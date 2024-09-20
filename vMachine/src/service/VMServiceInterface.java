package service;

import java.util.List;

import dto.UserDTO;
import entity.User;

public interface VMServiceInterface {
	// 회원정보 추가
	int newUser(UserDTO user);
	// 회원정보 수정
	// 회원정보 삭제
	// 회원정보 조회
	List<User> userAll();
	
	// id 일치 확인
	String findID(String u_id);
	// pw 일치 확인
	int findPW(String u_pw);
	
	// 제품정보 추가
	// 제품정보 수정
	// 제품정보 삭제
	// 제품정보 조회
}
