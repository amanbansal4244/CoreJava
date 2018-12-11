package QuestionOnMultithreading;

import java.util.concurrent.CyclicBarrier;
/****
 *  *  Note: Using this technique: o/p is no so correct. Refer this code just to understand more concept of cyclic barrier.
 *  
 * Question -  There are three threads,t1, t2 and t3, each of these thread have an array of size three. thread t1 has array {1,4,7},
 *  thread t2 has array {2,5,8}, thread t3 has array {3,6,9}.
 *  
 *  How to design the thread execution so that the output of execution will be 1,2,3,4,5,6,7,8,9 
 *  
 * @author bansal
 *
 */
public class _5MainRunnableJoin {

	public static void main(String[] args) {
 
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
 
            @Override
            public void run() {
                System.out.println("DONE");
 
            }
 
        });
 
        _5MyRunnableJoin myRunnableJoin1 = new _5MyRunnableJoin(cb);
 
        _5MyRunnableJoin myRunnableJoin2 = new _5MyRunnableJoin(cb);
 
        _5MyRunnableJoin myRunnableJoin3 = new _5MyRunnableJoin(cb);
 
        int a[] = { 1, 4, 7 };
        int b[] = { 2, 5, 8 };
 
        int c[] = { 3, 6, 9 };
 
        myRunnableJoin1.setCount(a);
 
        myRunnableJoin2.setCount(b);
 
        myRunnableJoin3.setCount(c);
 
        Thread t1 = new Thread(myRunnableJoin1, "Thread1");
 
        Thread t2 = new Thread(myRunnableJoin2, "Thread2");
 
        Thread t3 = new Thread(myRunnableJoin3, "Thread3");
 
         
 
        // T1 --> T2 --> T3 --> Main Thread
 
        try {
            t1.start();
             
            t2.start();
             
            t3.start();
             
        } catch (Exception e) {
             
            e.printStackTrace();
        }
 
         
 
    }
 
}