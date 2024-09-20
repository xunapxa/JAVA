package telBookApp.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import telBookApp.dto.TelBookDto;
import telBookApp.exception.InputValidation;
import telBookApp.exception.MyException;
import telBookApp.service.TelbookService;

public class DisplayMenu {
	TelbookService telbookService = new TelbookService();
	InputValidation validation = new InputValidation();
	Scanner sc = new Scanner(System.in);

	public void menuInput() {


		System.out.println("데이터 입력 처리 화면");
		while (true) {
			// 정보를 입력 받음
			// 이름 validation 확인
			String name = checkName();

			int age = checkAge();


			System.out.println("주소 : ");
			String address = sc.next();

			String phone = checkPhone();


			// 입력 받은 정보를 TelBookDto에 담아서 서비스로 보냄
			telbookService.Input(TelBookDto.makeDto(name, age, address, phone));
			// -> Dto가 만들어짐
			return;
		}

	}



	private String checkPhone() {
		boolean checkPhone = true;
		String phone = "";
		do {
			try {
				System.out.println("전화번호 : ");
				phone = sc.next();
				validation.phoneCheck(phone);
				checkPhone = false;
			} catch (MyException e) {
				System.out.println(e.getMessage());
			}
		} while (checkPhone);
		return phone;
	}



	private int checkAge() {
		boolean checkAge = true;
		int age = 0;
		do {
			try {
				System.out.println("나이 : ");
				age = sc.nextInt();
				validation.ageCheck(age);
				checkAge = false;
			} catch (MyException e) {
				System.out.println(e.getMessage());
			}
		} while (checkAge);
		return age;
	}



	private String checkName() {
		boolean checkName = true;
		String name = "";
		do {
			try {
				System.out.println("이름 : ");
				name = sc.next();
				validation.nameCheck(name);
				checkName = false;
			} catch (MyException e) {
				System.out.println(e.getMessage());
			}
		} while (checkName);
		return name;
	}

	public void menuUpdate() {
		System.out.println("데이터 수정 처리 화면");
		while (true) {
			System.out.println("수정할 정보의 아이디를 입력하세요: ");
			Long upDateId = sc.nextLong();

			TelBookDto dto = telbookService.SearchId(upDateId);
			if (dto == null) {
				System.out.println("검색 실패");
				return;
			} else {
				printTitle();
				System.out.println(dto.toString());
				printLine();
			}

			System.out.println("이름 : ");
			String name = sc.next();

			System.out.println("나이 : ");
			int age = sc.nextInt();

			System.out.println("주소 : ");
			String address = sc.next();

			System.out.println("전화 : ");
			String phone = sc.next();

			telbookService.Update(TelBookDto.makeDto(upDateId, name, age, address, phone));
			return;
		}

	}

	public void menuDelete() {
		System.out.println("데이터 삭제 처리 화면");
		System.out.println("삭제할 아이디를 입력하세요 : ");
		Long deleteId = sc.nextLong();

		telbookService.Delete(deleteId);
	}

	public void menuShowAll() {
		System.out.println("전체데이터 출력 처리 화면");
		List<TelBookDto> dtos = telbookService.ShowAll();

		// 타이틀 출력하기
		printTitle();
		if (dtos.size() == 0) {
			System.out.println("자료가 없습니다");
		} else {
			for (TelBookDto dto : dtos) {
				System.out.println(dto.toString());
			}
		}
		// 줄 긋기
		printLine();
	}

	private void printLine() {
		System.out.println("============================================");
	}

	private void printTitle() {
		System.out.println("============================================");
		System.out.println("ID	 이름	 나이	 주소	 전화번호");
		System.out.println("============================================");
	}

	public void menuSearchId() {
//		System.out.println("아이디 검색 처리 화면");
		Long searchId = 0L;
		System.out.println("검색할 아이디 입력: ");
		searchId = sc.nextLong();

		TelBookDto dto = telbookService.SearchId(searchId);
		if (dto == null) {
			System.out.println("검색 실패");
		} else {
			printTitle();
			System.out.println(dto.toString());
			printLine();
		}
	}

	public List<TelBookDto> menuSearch() {
		List<TelBookDto> bookDtos = new ArrayList<TelBookDto>();
		String keyword = "";
		while (true) {
			System.out.println("검색 대상 번호를 입력하세요.");
			System.out.println("1.아이디 2.이름 3.주소 4.전화번호 5.돌아가기");
			int num = sc.nextInt();

			switch (num) {
			case 1:
				menuSearchId(); // 이미 생성한 아이디 검색 호출
				return null;

			case 2:
				System.out.println("검색할 이름의 일부 혹은 전체를 입력하세요.");
				keyword = sc.next();
				bookDtos = telbookService.searchKeyword(num, keyword);
				break;

			case 3:
				System.out.println("검색할 주소의 일부 혹은 전체를 입력하세요.");
				keyword = sc.next();
				bookDtos = telbookService.searchKeyword(num, keyword);
				break;

			case 4:
				System.out.println("검색할 전화번호의 일부 혹은 전체를 입력하세요.");
				keyword = sc.next();
				bookDtos = telbookService.searchKeyword(num, keyword);
				break;

			case 5:
				return null;

			default:
				System.out.println("잘못 입력했습니다.");
				break;
			}

			// 타이틀 출력하기
			printTitle();
			if (bookDtos.size() == 0) {
				System.out.println("자료가 없습니다");
			} else {
				for (TelBookDto dto : bookDtos) {
					System.out.println(dto.toString());
				}
			}
			// 줄 긋기
			printLine();
		}
	}
}
