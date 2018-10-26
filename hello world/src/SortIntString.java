import java.util.*;
public class SortIntString {
	public static void main(String[] args) {
		List<Integer> numb = new ArrayList<>() ;
		List<String> name = new ArrayList<>();
		//int n = 0;
		//int a = 0;
		System.out.println("Enter Input..");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String[] str1 = str.split(" ");
			for(int i=0;i<str1.length;i++) {
				try{
				    numb = Integer.parseInt(str1);
				}catch (NumberFormatException ex) {
				    //handle exception here
				}
			}
			System.out.println("Numbers:");
			for(Integer i :numb  ) {
				System.out.println(Integer.parseUnsignedInt(i)+",");
			}
			System.out.println("Name");
			for(String t :name) {
				System.out.println(t+",");
			}
	}
	}
}
