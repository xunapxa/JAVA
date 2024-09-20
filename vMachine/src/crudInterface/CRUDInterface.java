package crudInterface;

import java.util.List;

import entity.Product;
import entity.User;

public interface CRUDInterface {

	// 회원 추가
	int insertUser(User user);
	// 회원 수정
	int updateUser(User user);
	// 회원 삭제
	int deleteUser(Long u_num);
	// 회원 전체 출력
	List<User> userAll();
	// 회원 상세보기
	User findUserId(Long u_num);
	
	// id 일치 확인
	String findID(String u_id);
	// pw 일치 확인
	int findPW(String u_pw);
	
	// 제품 추가
	int insertPro(Product product);
	// 제품 수정
	int updatePro(Product product);
	// 제품 삭제
	int deletePro(Long p_num);
	// 제품 전체 출력
	List<Product> productAll();

	
	// 회원별 판매현황 출력
	List<User> userSelAll();

	// 제품별 판매현황 출력
	List<Product> proSelAll();
}
