package QuestionOnMultithreading;

import java.util.concurrent.CyclicBarrier;

public class _5MyRunnableJoin implements Runnable {
 
    CyclicBarrier cb;
 
    public _5MyRunnableJoin(CyclicBarrier cb) {
        this.cb = cb;
    }
 
    public CyclicBarrier getCb() {
        return cb;
    }
 
    public void setCb(CyclicBarrier cb) {
        this.cb = cb;
    }
 
    private int count[];
 
    public int[] getCount() {
        return count;
    }
 
    public void setCount(int[] count) {
        this.count = count;
    }
 
    @Override
    public void run() {
 
        System.out.println(count[0]); // first all three thread will print the 1st element of each array.
        try {
            cb.await(); // wait will all pending threads to reach at this point.
        } catch (Exception e) {
 
            e.printStackTrace();
        }
 
        System.out.println(count[1]); // first all three thread will print the 2nd element of each array.
        try {
            cb.await(); // wait will all pending threads to reach at this point.
        } catch (Exception e) {
 
            e.printStackTrace();
        }
 
        System.out.println(count[2]); // first all three thread will print the 3rd element of each array.
        try {
            cb.await(); // wait will all pending threads to reach at this point.
        } catch (Exception e) {
 
            e.printStackTrace();
        }
 
        // System.out.println("Runnable:" + Thread.currentThread().getName());
 
    }
 
}