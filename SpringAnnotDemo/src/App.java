import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		
		Student stu = (Student) ctx.getBean("student");
		stu.getAge();
		stu.getName();
		stu.printThrowException();
	}

}
