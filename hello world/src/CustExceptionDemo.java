import java.util.Scanner;
class AlessThanBException extends Exception{
	public String getMessage() {
		return "Error:a is less than b";
	}
}
public class CustExceptionDemo {
	public static void main(String[] args) {
		int a, b;
		try {
		System.out.println("enter value of a");
		Scanner s = new Scanner(System.in);
		a=s.nextInt();
		System.out.println("enter value of b");
		b=s.nextInt();
		
			if(a>b) {
				System.out.println("we cool...");
			}
			else {
				throw new AlessThanBException();
			}
		}
		catch(AlessThanBException AB) {
			System.out.println(AB.getMessage());
		}
		catch(Exception e) {
			System.out.println("input error");
		}
		
	}
}
