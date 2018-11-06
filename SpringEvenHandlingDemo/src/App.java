import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		context.start();
		HelloWorld hh = (HelloWorld) context.getBean("helloWorld");
		hh.getMessage();
		context.stop();
	}

}
