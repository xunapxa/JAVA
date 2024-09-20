package main;

import java.sql.Connection;
import java.util.Scanner;

import db.DBConn;
import view.VMachineView;

public class vMachineMain {
	Connection conn = DBConn.getConnection(); // DB 접속 나중에 DAO에서 처리
	public static Scanner sc = new Scanner(System.in);
	public static VMachineView VMView = new VMachineView();
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("✨ 메인화면 ✨");
			System.out.println("1. 회원가입 2. 로그인 3. 관리자페이지 4. 종료");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.println("회원가입 화면으로 연결합니다 ººº \n");
				VMView.signUP();
				break;
			case 2:
				System.out.println("로그인 화면으로 연결합니다 ººº \n");
				VMView.logIN();
				break;
			case 3:
				System.out.println("관리자 페이지로 이동합니다 ººº \n");
				VMView.managerFage();
				break;
			case 4:
				System.out.println("자판기 시스템을 종료합니다");
				return;
			case 5:
				
			default:
				System.out.println("잘못된 번호선택입니다 다시 입력하세요");
			}
			
		}
	}
}
