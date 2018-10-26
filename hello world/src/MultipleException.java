import java.util.Scanner;

public class MultipleException {
	public static void main(String[] args) {
		System.out.println("entering main");
		int a,b,c;
		try 
		{
			Scanner s = new Scanner(System.in);
			System.out.println("enter value for a");
			a=s.nextInt();
			System.out.println("enter value for b");
			b=s.nextInt();
			c=a/b;
			System.out.println(c);
			s.close();
		}
		catch(ArithmeticException e)
		{
			System.out.println(" Input leads to 0");
		}
		catch(Exception e)
		{
			System.out.println(" invalid input");
		}
		System.out.println("exiting main normally");
		
	}
}
