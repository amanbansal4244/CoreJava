package Exchange_ProducerConsumerProblem;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {

	ArrayList<Integer> arrayList;

	/*This will be the exchanger object that will be used to synchronized the producer and consumer.*/
	Exchanger<ArrayList<Integer>> exchanger;

	public Consumer(Exchanger<ArrayList<Integer>> exchanger) {
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		System.out.println("Waiting for producer to produced the items and notify me..");


		for(int i=0;i<10;i++){
			try {
				/****
				 * In each cycle, begin with a call to the exchange() method to synchronize with the producer.
				 * The consumer needs data to consume.
				 * Call the exchange() method to interchange data with the producer.
            		 * means we are creating new 'ArrayList' in parameter and passing to the producer thread.
            		 * and getting 'arrayList' as a result from producer thread.
            		 */
				arrayList = exchanger.exchange(new ArrayList<Integer>());
				System.out.println("Producer has produced all the items and ready to consumed : " + arrayList);
				int productSize =arrayList.size();
				for(int j = 0 ; j <productSize; j++){
					System.out.println("Consumed Item :" +arrayList.remove(0));
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
