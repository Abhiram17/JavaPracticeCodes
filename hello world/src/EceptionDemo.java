import java.util.*;

public class EceptionDemo {
	public static void main(String[] args) {
		System.out.println("entering main");
		int a,b,c;
		Scanner s = new Scanner(System.in);
		System.out.println("enter value for a");
		a=s.nextInt();
		System.out.println("enter value for b");
		b=s.nextInt();
		
		try {
			c=a/b;
			System.out.println(c);
		}
		catch(Exception e){
			System.out.println("invalid Input");
		}
		System.out.println("exiting main normally");
		s.close();
	}

}
