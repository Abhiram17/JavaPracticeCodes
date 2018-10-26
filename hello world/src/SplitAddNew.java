import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitAddNew {
	public static void main(String[] args) {
		List<Integer> numb = new ArrayList<>() ;
		List<String> name = new ArrayList<>();
		//int n = 0;
		//int a = 0;
		System.out.println("Enter Input..");
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		String[] str1 = str.split(" ");
			for(String str2 : str1) {
				try{
				    numb.add(Integer.parseInt(str2));
				}catch (NumberFormatException ex) {
				    name.add(str2);
				}
			}
			System.out.println("Numbers:");
			for(Integer i :numb  ) {
				System.out.print(i+",");
			}
			System.out.println(" ");
			System.out.println("Name");
			for(String t :name) {
				System.out.print(t+" ");
			}
	}
	
}
