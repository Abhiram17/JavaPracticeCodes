
public class Person 
{ 
	private String name;
	private int age;
	private float height;
	public void setData(String name, int age, float height) {
		this.name=name;
		this.age=age;
		this.height=height;
	}
	public void display() {
		System.out.println("name:"+name);
		System.out.println("Age:"+age);
		System.out.println("height:"+height);
	}
}