package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.UserDTO;
import entity.User;
import service.VMachineService;

public class VMachineView implements VMViewInterface {
	// 회원정보 자동생성 아이디 역할
	public static Long u_num = 1L;
	// 회원정보 저장소(테이블 역할)
	private List<User> Users = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static VMachineService VMService = new VMachineService();
	
	@Override
	public void signUP() {
		System.out.println("😀 회원가입 화면입니다 😀");
		System.out.println("사용할 아이디: ");
		String u_id = sc.next();
		System.out.println("사용할 패스워드: ");
		String u_pw = sc.next();
		System.out.println("이름: ");
		String u_name = sc.next();
		System.out.println("전화번호: ");
		String u_tel = sc.next();
		
		// 입력 받은 자료를 dto로 생성
		UserDTO dto = UserDTO.makeUserDto(u_num, u_id, u_pw, u_name, u_tel, 0, 0);
		u_num++;
		int result = VMService.newUser(dto);
		if (result > 0) {
			System.out.println("회원 등록 성공");
		} else {
			System.out.println("회원 등록 실패");
		}
		return;
	}

	@Override
	public void logIN() {
		System.out.println("😻 로그인 화면입니다 😻");
		System.out.println("아이디를 입력하세요: ");
		String u_id = sc.next();
		String resultID = VMService.findID(u_id);
		
		if(resultID == null) {
			System.out.println("일치하는 아이디가 없습니다 다시 입력하세요");
			return;
		}
		
		System.out.println("비밀번호를 입력하세요: ");	
		String u_pw = sc.next();
		int resultPW = VMService.findPW(u_pw);
		
		List<User> user = VMService.userAll();
		for(User list : user) {
			System.out.println(list.getU_name());
		}
		
		
	}

	@Override
	public void managerFage() {
		System.out.println("👀 관리자 페이지입니다 👀");
		
	}

}
