

public class ExceptionThrownDemo {
	public static void main(String[] args) {
		System.out.println("entering main");
		
		DemoE d = new DemoE();
		try {


			d.func();
		}
		catch(Exception e){
			System.out.println("invalid Input");
		}
		System.out.println("exiting main normally");
		
	}
}
	class DemoE {
		int a=0,b=0,c;
		
		void func(){
			int c=a/b;
			 System.out.println(c);
		}
	}

