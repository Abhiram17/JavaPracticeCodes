import java.util.Scanner;

class CheckAB {
	void checkFor(int a,int b) throws AlessThanBException{ 
		if(a>b) {
			System.out.println("we cool...");
		}
		else {
			throw new AlessThanBException();
		}
	}
}
public class ThrowsDemo {
	public static void main(String[] args) {
		int a, b;
		try {
		System.out.println("enter value of a");
		Scanner s = new Scanner(System.in);
		a=s.nextInt();
		System.out.println("enter value of b");
		b=s.nextInt();
		CheckAB ab = new CheckAB();
		
		ab.checkFor(a, b);
		}
		catch(AlessThanBException er) {
			System.out.println("error:a is less than b");
		}
		catch(Exception e) {
			System.out.println("input error");
		}
		}
		
	}

