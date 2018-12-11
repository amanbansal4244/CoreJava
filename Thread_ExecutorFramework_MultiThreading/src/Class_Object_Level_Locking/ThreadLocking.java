package Class_Object_Level_Locking;

public class ThreadLocking implements Runnable{

	@Override
	public void run() {
		method1();
		method2();
		
	}
	public synchronized void method1(){
		for(int i=0; i<=2 ;i++)
		System.out.println( "Thread Name : "+ Thread.currentThread().getName() +" "+ "In Method1");
	}
	
	public synchronized void method2(){
		for(int i=0; i<=2 ;i++)
		System.out.println("Thread Name : "+ Thread.currentThread().getName() + " " +"In Method2");
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadLocking obj1 = new ThreadLocking();
		ThreadLocking obj2 = new ThreadLocking();
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
