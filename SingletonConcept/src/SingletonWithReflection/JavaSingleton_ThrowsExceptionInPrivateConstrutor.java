package SingletonWithReflection;

public class JavaSingleton_ThrowsExceptionInPrivateConstrutor {

	private volatile static JavaSingleton_ThrowsExceptionInPrivateConstrutor myObj; 
	/**
	 * Create private constructor
	 */

	private JavaSingleton_ThrowsExceptionInPrivateConstrutor(){
		if (myObj != null) {
			throw new RuntimeException("Inside JavaSingleton(): JavaSingleton " +
					"instance already created.");
		}
	}
	/**
	 * Create a static method to get instance.
	 */
	public static JavaSingleton_ThrowsExceptionInPrivateConstrutor getInstance(){
		if(myObj== null){                         // Single Checked
			synchronized (JavaSingleton_ThrowsExceptionInPrivateConstrutor.class) {
				if(myObj== null){                  // Double checked
					myObj = new JavaSingleton_ThrowsExceptionInPrivateConstrutor();
				}
			}
		}
		return myObj;
	}
	public void getSomeThing(){
		System.out.println("I am here....");
	}
}
  