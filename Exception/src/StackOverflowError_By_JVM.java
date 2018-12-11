
public class StackOverflowError_By_JVM {

	static public void go()
	{
		go();   // O/p : Exception in thread "main" java.lang.StackOverflowError
	}
	
	public static void main(String[] args) {
	
		StackOverflowError_By_JVM.go();    
	}
	
}
