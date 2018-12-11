package QuestionOnMultithreading;
import java.util.concurrent.Semaphore;
/****
 * Question -  There are three threads,t1, t2 and t3, each of these thread have an array of size three. thread t1 has array {1,4,7},
 *  thread t2 has array {2,5,8}, thread t3 has array {3,6,9}.
 *  
 *  How to design the thread execution so that the output of execution will be 1,2,3,4,5,6,7,8,9 
 * @author bansal
 *
 */
public class _4InterThreadCommunication_Semaphore {

	static class SampleRunnable implements Runnable
	{
		final int[] arrayToPrint;
		final Semaphore acquireSemaphore;
		final Semaphore releaseSemaphore;

		public SampleRunnable(int[] arrayToPrint, Semaphore acquireSemaphore, Semaphore releaseSemaphore) {
			this.acquireSemaphore = acquireSemaphore;
			this.releaseSemaphore = releaseSemaphore;
			this.arrayToPrint = arrayToPrint;
		}

		@Override
		public  void  run()
		{
			try {
				/*All three semaphore come together at this point. */
				this.acquireSemaphore.acquire();
				System.out.println(arrayToPrint[0]);
				this.releaseSemaphore.release();
				
				this.acquireSemaphore.acquire();
				System.out.println(arrayToPrint[1]);
				this.releaseSemaphore.release();
				
				this.acquireSemaphore.acquire();
				System.out.println(arrayToPrint[2]);
				this.releaseSemaphore.release();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {

		/****
		 * A blocking semaphore is initialized to zero rather than one, working in a
		 * manner that any thread that does a P(S) operation will block until released
		 * by V(S) first. It can be used to control the order in which threads are
		 * executed when they need to be managed.
		 * 
		 * Semaphore with 0 permits means all acquire() calls will block and tryAcquire() calls will return false, until you do a release().
		 * 
		 * If the value is positive, then it represents the number of threads that can decrement without blocking. 
		 * If it is negative, then it represents the number of threads that have blocked and are waiting. 
		 * If the value is zero, it means there are no threads waiting, but if a thread tries to decrement, it will block.
		 */
		Semaphore firstSemaphore = new Semaphore(0);
		Semaphore secondSemaphore = new Semaphore(0);
		Semaphore thirdSemaphore = new Semaphore(0);
		
		/*Semaphore firstSemaphore = new Semaphore(1);
		Semaphore secondSemaphore = new Semaphore(1);
		Semaphore thirdSemaphore = new Semaphore(1);*/

		int[] a1 = new int[] {1,4,7};
		int[] a2 = new int[]{2,5,8};
		int[] a3 = new int[]{3,6,9};

		Thread t1 = new Thread(new _4InterThreadCommunication_Semaphore.SampleRunnable(a1,firstSemaphore,secondSemaphore));
		Thread t2 = new Thread(new _4InterThreadCommunication_Semaphore.SampleRunnable(a2, secondSemaphore, thirdSemaphore));
		Thread t3 = new Thread(new _4InterThreadCommunication_Semaphore.SampleRunnable(a3, thirdSemaphore, firstSemaphore));

		t1.start();
		t2.start();
		t3.start();

		firstSemaphore.release();
	}

}