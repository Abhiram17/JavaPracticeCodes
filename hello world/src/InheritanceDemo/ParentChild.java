package InheritanceDemo;
class Parent
{
	void disp() {
		System.out.println("Inside parents method");
	}
}
class Child1 extends Parent
{
	void disp() {
		System.out.println("Inside chiold1's method");
	}
}
class Child2 extends Parent
{
	void disp()
	{
		System.out.println("Inside cjild2's method");
	}
}
class Printer
{
	void AllowClassToPrint(Parent ref)
	{
		ref.disp();
	}
}
public class ParentChild {
	public static void main(String[] args) {
		Parent p = new Parent();
		Child1 c1 = new Child1();
		Child2 c2 = new Child2();
		Printer pr = new Printer();
		//p.disp();
		//Parent ref;
		//ref = c1;
		//ref.disp();
		pr.AllowClassToPrint(c1);
		pr.AllowClassToPrint(c2);
	}

}
