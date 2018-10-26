import java.util.*;

class Beer{
	double price = 6.5;
	String name = "Corona";
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	
}
class Whiskey{
	double price;
	String name;
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	
}
public class VendingM {
	
	
	public static void main(String[] args) {
		
		Beer B = new Beer();
		Whiskey W = new Whiskey();
		Map<Integer, Object> map = new LinkedHashMap<Integer,Object>();
		map.put(1, B);
		map.put(2, W);
		
		//code cycle
		printChoice(map);
	}

	public static void printChoice(Map map) {
		System.out.println("Todays menu...");
		for(int i = 0;i<map.size();i++)
		{
			Object m = (Object) map.get(i);
			System.out.println(((Beer) m).getName());
		}
	}

}
