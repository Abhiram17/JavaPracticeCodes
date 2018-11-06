
public class HelloWorld {
	private String message;
	SpellChecker spellChecker;
	public HelloWorld(SpellChecker spellChecker) {
		System.out.println("Inside TextEditor constructor." );
		this.spellChecker=spellChecker;
	}
	public void spellCheck() {
		spellChecker.checkSpelling();
	}

	   public void setMessage(String message){
	      this.message  = message;
	   }
	   public void getMessage(){
	      System.out.println("Your Message : " + message);
	   }
}
