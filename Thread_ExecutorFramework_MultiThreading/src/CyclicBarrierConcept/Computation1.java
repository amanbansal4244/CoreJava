package CyclicBarrierConcept;
import java.util.concurrent.BrokenBarrierException;
 
class Computation1 implements Runnable
{
    public static int product = 0;
    public void run()
    {
        product = 2 * 3;
        try
        {
            _3Tester.newBarrier.await();
        } 
        catch (InterruptedException | BrokenBarrierException e) 
        {
            e.printStackTrace();
        }
    }
}

