import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		/*ApplicationContext ctx = 
		         new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		   
		      HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		      helloWorld.setMessage("Hello World!");
		      helloWorld.getMessage();
		      helloWorld.spellCheck();*/
		ApplicationContext ctx = new AnnotationConfigApplicationContext(B.class);
		A d = ctx.getBean(A.class);
		B c = ctx.getBean(B.class);
	}

}
