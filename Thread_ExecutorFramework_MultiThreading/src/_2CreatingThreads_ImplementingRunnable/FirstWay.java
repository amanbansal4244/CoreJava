package _2CreatingThreads_ImplementingRunnable;

public class FirstWay {

	public static void main(String[] args) {
		System.out.println("Main thread starts here");
		 new FirstTask();
		 new FirstTask();
	
		System.out.println("Main thread ends here");
	}
}

 class FirstTask  implements Runnable{
	
	public FirstTask(){
		new Thread(this).start(); // here we are creating the Thread using overloaded constructor of thread class which takes class object as an argument.
								 // note : in this approach , we need to create Thread class object and we wont be able to 
								// manipulate the Thread class behavior by using this approach
	}
	
	@Override
	public void run() {
		for(int i=0 ; i< 10; i++){
			System.out.println(" Thread Name :" + Thread.currentThread().getName() + " : Tick Tick Using Runnable :" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
