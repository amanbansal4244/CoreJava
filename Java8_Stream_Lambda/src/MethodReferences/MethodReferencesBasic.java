package MethodReferences;

public class MethodReferencesBasic {

	public static void printMessage(){
		System.out.println("Helloooooo!!!!");
	}
	
	
	public void doProcess(){
		System.out.println("value of i :");
	}
	
	public static void main(String[] args) {
		
		MethodReferencesBasic methodReferencesBasic = new MethodReferencesBasic(); 
		
		/*Approach 1 : Using lambda expression 
		Note :Used lambda expression instead of 'Runnable' interface like below
		
		*Thread myThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("In myThread");
			}
		});
		
		Remember, below code works because Runnable has a single method. If it had more than one method,
		 		  you could not have written a lambda function of that type.
		*/
		Thread t = new Thread( () -> printMessage());
		t.start(); // o/p : Helloooooo!!!!
		
		
		/*Approach 2 : Using lambda expression Method Reference, and 
		 * 			   alternative of lambda which takes no argument , () -> printMessage()
			Note :We use below signature to write method reference 
			  	  Signature - 'Class name :: method Name'
			      above signature represents that use that class name and method name which you want to invoke
			      and this works because 'printMessage' is static method and to call static method we just need class name
		*/
		Thread t1 = new Thread(MethodReferencesBasic :: printMessage);
		t1.start(); // o/p : Helloooooo!!!!
		
		
		/*Approach 3 : Using lambda expression Method Reference, and 
		 * 			   alternative of lambda which takes no argument , () -> doProcess()
			Note :We use below signature to write method reference 
			  	  Signature - 'Class object :: method Name'
			      above signature represents that use that class object and method name which you want to invoke
		*/
		Thread t2 = new Thread(new MethodReferencesBasic() :: doProcess);
		t2.start();
	}
}
