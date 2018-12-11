package ProducerConsumerProblemConcept;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Producer p = new Producer();
		Consumer c = new Consumer(p);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		
		t2.start();
		Thread.sleep(1000);
		t1.start();
	}
}
