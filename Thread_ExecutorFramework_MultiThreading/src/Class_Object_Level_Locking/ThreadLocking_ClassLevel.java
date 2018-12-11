package Class_Object_Level_Locking;

public class ThreadLocking_ClassLevel implements Runnable{

	@Override
	public void run() {
		method1();
		//method2();
		
	}
	public static synchronized void method1(){
		for(int i=0; i<=2 ;i++)
		System.out.println( "Thread Name : "+ Thread.currentThread().getName() +" "+ "In Method1");
	}
	
	/*public synchronized void method2(){
		for(int i=0; i<=2 ;i++)
		System.out.println("Thread Name : "+ Thread.currentThread().getName() + " " +"In Method2");
	}*/
	
	public static void main(String[] args) throws InterruptedException {
		ThreadLocking_ClassLevel obj1 = new ThreadLocking_ClassLevel();
		ThreadLocking_ClassLevel obj2 = new ThreadLocking_ClassLevel();
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		t1.start();
		//t1.sleep(5000);
		t2.start();
		//t2.sleep(5000);
	}

}
