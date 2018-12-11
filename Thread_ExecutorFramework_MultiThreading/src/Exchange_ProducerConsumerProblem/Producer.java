 package Exchange_ProducerConsumerProblem;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

public class Producer implements Runnable{

	ArrayList<Integer> arrayList;
	
	/*This will be the exchanger object that will be used to synchronized the producer and consumer.*/
    Exchanger<ArrayList<Integer>> exchanger;
    
	public Producer(Exchanger<ArrayList<Integer>> exchanger) {
		 this.exchanger = exchanger;
		arrayList = new ArrayList<Integer>();
	}

	@Override
	public void run() {
			System.out.println("Producer is producing the items..");
				for(int i =0 ; i< 10; i++){
					arrayList.add(i);
					System.out.println("Producer is still producing the items, producded item no :"+ i);
				}
			
				try {
					System.out.println("Production is over and exchanging the items to the consumer to consume the prodcued items..");
            			/****Call the exchange() method to interchange data with the consumer.
            			 * means we are passing 'arrayList' as parameter to the consumer thread
            			 * and getting back 'arrayList' as a result from consumer thread.
            			 */
					arrayList = exchanger.exchange(arrayList);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
				
			
			
		}
}
