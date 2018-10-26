
class LaunchDog {
String name;
String color;
int age;

void setData() {
	name="ramu";
	age=20;
	color="brown";
}
public String toString() {
	return "ramu \n 20 \n brown";
}

}
 
class Dog
{
	public static void main(String[] args) {
		LaunchDog d1 = new LaunchDog();
		System.out.println(d1);
				
	}
}