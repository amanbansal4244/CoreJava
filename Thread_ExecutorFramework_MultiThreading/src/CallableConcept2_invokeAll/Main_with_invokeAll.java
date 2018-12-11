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

public class Main_with_invokeAll {

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

		List<Callable<Employee>> list = new ArrayList<Callable<Employee>>();

		/****
		 * Here, we are submitting 5 tasks to service , since no of threads are 5 in
		 * thread pool. All these 5 tasks would run concurrently. and storing each and
		 * every thread result back to list of type 'Callable<Employee>', once thread
		 * execution is completed.
		 */
		list.add(new TaskAsCallable(1001));
		list.add(new TaskAsCallable(1002));
		list.add(new TaskAsCallable(1003));
		list.add(new TaskAsCallable(1004));
		list.add(new TaskAsCallable(1005));

		/****
		 * Now we have to wait till the time all above submitting 5 tasks gets completed
		 * using 'invokeAll' method. invokeAll : returns a list of futures holding their
		 * status and results after all tasks finish or the timeout expires. The
		 * invokeAll() method invokes all of the Callable objects you pass to it in the
		 * collection passed as parameter. The invokeAll() returns a list of Future
		 * objects via which you can obtain the results of the executions of each
		 * Callable. Keep in mind that a task might finish due to an exception, so it
		 * may not have "succeeded". There is no way on a Future to tell the difference.
		 */
		List<Future<Employee>> tasks = null;
		try {
			tasks = executorService.invokeAll(list);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(tasks.size() + " " + "Responses recieved. \n");

		for (Future<Employee> task : tasks) {
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
