import org.springframework.context.annotation.*;

@Configuration
public class HelloWorldConfig {
	 @Bean 
	   public HelloWorld helloWorld(){
		 
	      return new HelloWorld(spellChecker());
	   }
	 @Bean
	 	public SpellChecker spellChecker() {
	 		return new SpellChecker();
	 	}
}
