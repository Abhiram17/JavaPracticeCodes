import java.util.*; 
class Demo {
	

	Demo(){
		
		System.out.println("1'st class");
	}
	
}
class b extends Demo{
	b(){
		System.out.println("B's constructor");
	}
	b(int x){
		System.out.println("b's parameterized const");
	}

}

class c extends b{
	c(){
		//super(2);
		System.out.println("C's construstor");
	}
}
class SetExamp
	{
	public static void main(String[] args) {
		new c();
		
	}	
        
    
	}