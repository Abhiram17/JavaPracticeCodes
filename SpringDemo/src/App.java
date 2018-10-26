import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		      ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		      obj.getMessage1();
		      obj.getMessage2();
		      HelloIndia obj1 = (HelloIndia) context.getBean("helloIndia");
		      obj1.getMessage1();
		      obj1.getMessage2();
		      obj1.getMessage3();
		      ((AbstractApplicationContext) context).registerShutdownHook();
		   }
	

}
