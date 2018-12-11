package _2CreatingThreads_ImplementingRunnable;

public class SecondWay {

	public static void main(String[] args) {
		System.out.println("Main thread starts here");
		 new Thread(new SecondTask()).start();
		
		 Thread t = new Thread(new SecondTask()); // creating Thread in main , not in constructor of class
		 										// by doing this , we are capturing the Thread reference and 
		 										//enabling the manipulate the behavior of the Thread class in future
		 t.start();
	
		System.out.println("Main thread ends here");
	}
}

 class SecondTask  implements Runnable{
	
	public SecondTask(){
		//new Thread(this).start(); // here we are using overloaded constructor of thread class which takes class object as an argument.
								 // note : in this approach , we need to create Thread class object
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
