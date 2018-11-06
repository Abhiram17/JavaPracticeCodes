import org.aspectj.lang.annotation.*;

@Aspect
public class Logging {
	@Pointcut("execution(* *.*(..))")
	public void selectAll() {
		
	}
	@Before("selectAll()")
	public void before() {
		System.out.println("Student profile initializing...");
	}
	@After("selectAll()")
	public void after() {
		System.out.println("Student profile initialized");
	}
	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void throwing(IllegalArgumentException ex){
		System.out.println("There has been an exception"+ ex.toString());
	}
	@AfterReturning(pointcut ="selectAll()", returning = "retVal")
	public void returning(Object retVal){
		System.out.println("The returned value is:"+retVal.toString());
	}
	
}
