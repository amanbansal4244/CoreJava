package ProducerConsumerProblem_UsingReentrantLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private List<Integer> arrayList = new ArrayList<>();

	public void produce() throws InterruptedException {

		lock.lock();

		System.out.println("Producer is producing the items..");
		try{
			for(int i =0 ; i< 10; i++){
				arrayList.add(i);
				System.out.println("Producer is still producing the items, producded item no :"+ i);
				Thread.sleep(1000);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("Production is over and notfying the consumer to consume the prodcued items..");

		condition.signal(); // same as notify() method and signal() will notify the that thread that called the await().


		lock.unlock();

	}

	public void consume() throws InterruptedException {
		lock.lock();

		Thread.sleep(2000);
		System.out.println("Waiting for producer to produced the items and notify me..");
		try{
			condition.await();  //await is going to hand-over the lock to other threads, waiting on the same lock.
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("Producer has produced all the items and ready to consumed");

		int productSize = arrayList.size();
		for(int i = 0 ; i <productSize; i++){
			System.out.println("Consumed Item :" + arrayList.remove(0));

		}

		lock.unlock();
	}

}

public class _3ProducerConsumerProblemUsingReentrant {

	public static void main(String[] args) {
		
		final Worker worker = new Worker();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					worker.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					worker.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t2.start();
		t1.start();
		
		
	}
}