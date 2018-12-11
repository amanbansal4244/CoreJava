package CallableConcept2_invokeAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

public class Main_without_invokeAll {

	/****
	 * Exception thrown when a blocking operation times out.
	 * 
	 * In above example, some tasks are taking more time (due to 4 seconds sleep)
	 * and blocking operation of get() on Future
	 * 
	 * Either increase the time-out or optimize Runnable task.
	 */
	public static void main(String[] args) throws TimeoutException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		List<Future<Employee>> resultList = new ArrayList<Future<Employee>>();

		for(int i=1001; i<= 1005; i++) {
			TaskAsCallable taskAsCallableObj = new TaskAsCallable(i);
			Future<Employee> result = executorService.submit(taskAsCallableObj);
			resultList.add(result);
		}


		for (Future<Employee> task : resultList) {
			try {
				System.out.println(task.get().toString());
			}
			/****
			 * ExecutionException: Exception thrown when attempting to retrieve the result
			 * of a task that aborted by throwing an exception => The computation threw an
			 * exception
			 * 
			 * In above example, this Exception is simulated through ArithmeticException: /
			 * by zero
			 * 
			 * Generally, you should catch it fix the root cause if it is trivial as quoted
			 * in the example.
			 * 
			 * InterruptedException: Thrown when a thread is waiting, sleeping, or otherwise
			 * occupied, and the thread is interrupted, either before or during the
			 * activity.
			 */
			catch (InterruptedException ierr) {
				System.out.println("Interrupted exception:");
				ierr.printStackTrace();
				 Thread.currentThread().interrupt();
			} catch (ExecutionException err) {
				// Extract the actual exception from its wrapper
	            Throwable t = err.getCause();
	            System.err.println("Uncaught exception is detected! " + t
	                    + " st: " + Arrays.toString(t.getStackTrace()));
	            
	            // ... Handle the exception
	            
			}
		}

		// shutdown your thread pool, else your application will keep runninng.
		executorService.shutdown();
	}
}
