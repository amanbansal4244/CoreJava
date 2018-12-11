package JoinConcept;

public class ThreadJoinEx2 {
 
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable1(), "t1");
        Thread t2 = new Thread(new MyRunnable1(), "t2");
        Thread t3 = new Thread(new MyRunnable1(), "t3");
         
        t1.start();
        t2.start();
        t3.start();
         
        //start second thread after waiting for 2 seconds or if it's dead
        /*try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
         
       
         
        //start third thread only when first thread is dead
        /*try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        t3.start();*/
         
        //let all threads finish execution before finishing main thread
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        System.out.println("All threads are dead, exiting main thread");
    }
 
}
 
class MyRunnable1 implements Runnable{
 
    @Override
    public void run() {
        System.out.println("Thread started:::"+Thread.currentThread().getName());
        
        for(int i = 1; i< 5 ; i++)
        {
        	System.out.println(i);
        }
        /*try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }
     
}
