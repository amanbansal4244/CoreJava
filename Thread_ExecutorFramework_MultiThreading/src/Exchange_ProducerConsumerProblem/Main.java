package Exchange_ProducerConsumerProblem;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

/**
 * With the help of Exchanger -> two threads can exchange objects.
 * 
 * exchange() -> exchanging objects is done via one of the two exchange() methods
 * 
 * For example: genetic algorithms, training neural networks.
 *
 */
public class Main {

	 public static void main(String[] args) {
 		/*Create the Exchanger object that will be used to synchronize the producer and consumer problem*/
     Exchanger<ArrayList<Integer>> exchanger = new Exchanger<>();
     
     Producer stringProducer = new Producer(exchanger);
     Consumer stringConsumer = new Consumer(exchanger);
     
     new Thread(stringProducer).start();
     new Thread(stringConsumer).start();
 }
}
