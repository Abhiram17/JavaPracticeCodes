import java.util.Scanner;

public class ExceptionFinally {
	public static void main(String[] args) {
		System.out.println("entering main");
		
		Demo1 d = new Demo1();
		try {
			d.func();
		}
		catch(Exception e){
			System.out.println("invalid Input");
			//System.out.println(printStackTrace());
		}
		System.out.println("exiting main normally");
		
	}
}
	class Demo1 {
		
		
		void func(){
			try {
			int a,b;
			Scanner s = new Scanner(System.in);
			System.out.println("enter value for a");
			a=s.nextInt();
			System.out.println("enter value for b");
			b=s.nextInt();
			s.close();
			//System.exit(0);

			int c=a/b;
			 System.out.println(c);
			 
			}
			catch(ArithmeticException f)
			{
				System.out.println("input leads to 0");
				throw f;
			}
			finally {
				System.out.println("Closing func");
			}
		}
}
