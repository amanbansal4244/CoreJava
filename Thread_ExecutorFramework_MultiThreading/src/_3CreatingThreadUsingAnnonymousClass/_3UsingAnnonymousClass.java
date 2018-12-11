package _3CreatingThreadUsingAnnonymousClass;

public class _3UsingAnnonymousClass {

	public static void main(String[] args) {
		System.out.println("Main thread starts here");
		/*
		We thread can not be re used. So we use this technique when we want to use thread only one time.
		Because we have provided inline task( task means -> business logic in run method) within thread and started with in thread itself only.
		
		This technique mostly handled UI event in application that have a user interface. To handle UI events , you do not 
		multiple instances of task at a one time, Instead whenever an event occurs task object is generated from inline 
		definition and used there and then to handle the events.
		*/
		new  Thread(new Runnable() { 
			
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
		}).start();
		
		System.out.println("Main thread ends here");
	}
}
