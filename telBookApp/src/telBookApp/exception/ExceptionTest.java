package telBookApp.exception;

public class ExceptionTest {
	public static void devide(int a, int b) throws ArithmeticException{
		if(b==0) throw new ArithmeticException("0으로 나눌 수 없당");
		int c = a / b;
		System.out.println(c);
	}
	public static void main(String[] args) {
		int a = 10;
		int b = 1;
		try {
		devide(a, b);
//		} catch (ArithmeticException e) {
//			System.out.println(e.getMessage());
		} catch (Exception e) { // Exception은 최상위라서 마지막으로 실행 되어야 함
			System.out.println(e.getMessage());
		}
	}
}
