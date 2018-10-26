package InheritanceDemo;

class A
{
	int i=10;
}
class B extends A
{
	int t = 20;
}
class C extends B
{
	int j = super.i;
	int i = 30;
}
public class InheritanceDemo 
{
	public static void main(String[] args) {
		C c = new C();
		System.err.println(c.j);
		
	}

}
