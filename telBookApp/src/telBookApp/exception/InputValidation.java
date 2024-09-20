package telBookApp.exception;

import java.util.regex.Pattern;

public class InputValidation {
	// 이름 확인 - 한글만
	public void nameCheck(String name) throws MyException {

		boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
		if(! check) { // 한글이 아니라면
			throw new MyException("* 이름은 한글로 입력해 주세요");
		}

	}
	// 전화번호 양식 일치 확인
	public void phoneCheck(String phone) throws MyException {
		
		boolean check = Pattern.matches("^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$", phone);
		if(! check) {
			throw new MyException("* 전화번호를 다시 입력해주세요 [@@@-@@@@-@@@@]");
		}
	}
	// 나이가 0세 ~ 120세 사이인지 확인
	public void ageCheck(int age) throws MyException {
		if(age <= 0 || age > 120) {
			throw new MyException("* 나이는 0세 이상 120세 이하로 입력해주세요");
		}
	}

}
