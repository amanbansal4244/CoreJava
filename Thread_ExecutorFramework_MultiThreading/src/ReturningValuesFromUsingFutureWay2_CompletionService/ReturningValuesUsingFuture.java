package ReturningValuesFromUsingFutureWay2_CompletionService;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/****
 * In this project, we will see how to returns the value using Executor Framework.
 * We will specifically focus on, how to process the task result in the order in which tasks completes
 * rather than the sequence in which task are submitted or the sequence in which we retrieve the results.
 * @author bansal
 *
 */
public class ReturningValuesUsingFuture {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("[" + currentThreadName + "] Main thead starts here.....");

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		CompletionService<TaskResult<String, Integer>> tasks = new ExecutorCompletionService<TaskResult<String, Integer>>(executorService);

		tasks.submit(new CalculationTaskA(2, 3, 50));
		tasks.submit(new CalculationTaskA(4, 5, 1000));
		tasks.submit(new CalculationTaskA(7, 6, 100));

		executorService.shutdown();

		for(int i=0; i< 3; i++) {
			try {
				/****
				 * take() : Retrieves and removes the Future representing the next completed task, waiting if none are yet present.
				 * means blocked until the task is completed.
				 */
				System.out.println(tasks.take().get());
			}catch(InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		System.out.println("[" + currentThreadName + "] Main thead ends here.....");

	}
}
