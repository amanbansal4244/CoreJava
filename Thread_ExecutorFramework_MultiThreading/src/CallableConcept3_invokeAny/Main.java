package CallableConcept3_invokeAny;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		List<Callable<Employee>> list = new ArrayList<Callable<Employee>>();
		
		/****
		 * Here, we are submitting 5 tasks to service , since no of threads are 5 in thread pool. All these 5 tasks would run concurrently.
		 * and storing each and every thread result back to list of type 'Callable<Employee>', once thread execution is completed.
		*/
		list.add(new TaskAsCallable(1001));
		list.add(new TaskAsCallable(1002));
		list.add(new TaskAsCallable(1003));
		list.add(new TaskAsCallable(1004));
		list.add(new TaskAsCallable(1005));
		
		/****
		 * Now we have to wait till the time all above submitting 5 tasks gets completed using 'invokeAny' method.
		 * The invokeAny() method takes a collection of Callable objects, or subinterfaces of Callable. 
		 * Invoking this method does not return a Future, but returns the result of one of the Callable objects.
		 *  You have no guarantee about which of the Callable's results you get. Just one of the ones that finish.
		 *  If one of the tasks complete (or throws an exception), the rest of the Callable's are cancelled.
		 *  
		 *  If we run this program multiple times, then we would get different output.
		 */
		Employee tasks = executorService.invokeAny(list);
		System.out.println("Employee Details: " +tasks.getId()+ " "+ tasks.getName() + " "+ tasks.getLocation());
		
		// shutdown your thread pool, else your application will keep runninng.
		executorService.shutdown();
	}
	
	
}
