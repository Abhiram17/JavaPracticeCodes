import java.util.*;

public class LandM {
	public static void main(String[] args) {
		Map<String,StudentInfo> m = new HashMap<String,StudentInfo>();
		List<String> l = new ArrayList<String>();
		l.add("Abhi");
		l.add("Sam");
		l.add("John");
		l.add("Carra");
		for(int i=0;i<l.size();i++) 
		{
			StudentInfo s = new StudentInfo();
			m.put(l.get(i), s);
			s.setName(l.get(i));
			s.setI(i);
		}
		
		System.out.println(m.get("Carra").getI());
	}
}
