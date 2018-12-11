package RunnablePackage;

public class RunnableExample {

	public static void main(String[] args) {
		//1st Approach : Here we are creating a thread object and passing 'Runnable' as a type 
		//Note : Runnable is interface which has only one method 'run' which needs to be override, So we did here.
		//And this is also best example of anonymous inner class
		Thread myThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("In myThread");
			}
		});
		
		myThread.run();
		
		//2nd Approach :We can used lambda expression which has the same pattern because 'Thread()' class does not, its just accept interface type
		//Here we used 'lambda expression ' instead of 'runnable' interface like we used in 1st approach
		//Benefit of using 'lambda expression' here -> it shows the back ward compatibility
		//Remember, this works because Runnable has a single method. If it had more than one method, you could not have written a lambda function of that type. 
		Thread myLambdaThread = new Thread( () -> System.out.println("In myLambdaThread ") );
		myLambdaThread.run();
		
	}
}
