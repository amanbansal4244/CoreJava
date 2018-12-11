package BlockingQueueConcept_OneProducerMultipleConsumer;

import java.util.*;
import java.util.concurrent.*;
 
/**
 * Producer using BlockingQueue example.
 */
class Producer implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;
    private int threadNo;

    public Producer(BlockingQueue<Integer> sharedQueue,int threadNo) {
        this.threadNo = threadNo;
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=1; i<= 5; i++){
            try {
                int number = i+(10*threadNo);
                System.out.println("Produced:" + number + ":by thread:"+ threadNo);
                sharedQueue.put(number);
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }

}