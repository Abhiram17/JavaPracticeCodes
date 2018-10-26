import java.util.Scanner;

class CheckJB {
	void checkFor(int a,int b) { 
		try {
		if(a>b) {
			System.out.println("we cool...");
		}
		else {
			throw new AlessThanBException();
		}
		}
		catch(AlessThanBException er) {
			System.out.println("error : a<b");
		}
		catch(Exception e) {
			System.out.println("strange error");
		}
	}
}
public class ExceptionInMethod {
	public static void main(String[] args) {
		int a, b;
		
		System.out.println("enter value of a");
		Scanner s = new Scanner(System.in);
		a=s.nextInt();
		System.out.println("enter value of b");
		b=s.nextInt();
		CheckJB ab = new CheckJB();
		
		ab.checkFor(a, b);
		}
}
