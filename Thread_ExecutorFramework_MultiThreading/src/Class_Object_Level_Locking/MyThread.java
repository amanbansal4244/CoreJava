package Class_Object_Level_Locking;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class MyThread implements Runnable {

	@Override
	public void run() {
		method1();
		method2();
	}

	private synchronized void method1() {
		for(int i=0; i<3; i++){
			System.out.println("Method1:" + Thread.currentThread().getName());
			
		}
	}

	private static synchronized void method2() {
		for(int i=0; i<3; i++){
			System.out.println("Method2:" + Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread obj1 = new MyThread();
		MyThread obj2 = new MyThread();
		Thread t1 = new Thread(obj1,"Thread 1");
		
		Thread t2 = new Thread(obj2,"Thread 2");
		t1.start();
		t2.start();
	}
}
