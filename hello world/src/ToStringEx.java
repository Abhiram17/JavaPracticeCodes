
public class ToStringEx {
	public static void main(String[] args) {
		int i = 40;
		String s = new Integer(i).toString();
		System.out.println(s+" is of class: "+s.getClass());
		String j = "20";
		int a = Integer.parseInt(j);
		System.out.println(a);
	}

}
