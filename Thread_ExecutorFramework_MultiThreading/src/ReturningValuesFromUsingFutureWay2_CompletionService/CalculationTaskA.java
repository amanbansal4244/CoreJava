package ReturningValuesFromUsingFutureWay2_CompletionService;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/****
 * In this project, we will see how to returns the value using Executor Framework.
 * We will specifically focus on, how to process the task result in the order in which tasks completes
 * rather than the sequence in which task are submitted or the sequence in which we retrieve the results.
 * @author bansal
 *
 */
public class CalculationTaskA implements Callable<TaskResult<String, Integer>> {
	private int a;
	private int b;
	private long sleepTime;
	private int sum;
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	
	public CalculationTaskA(int a, int b, long sleepTime) {
		this.a =a;
		this.b=b;
		this.sleepTime=sleepTime;
		
		this.instanceNumber = ++count;
		this.taskId = "CalculationTaskB-" + instanceNumber;
		
	}
	
	@Override
	public TaskResult<String, Integer> call() throws Exception{
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("#### [" + currentThreadName+ "] <" + taskId + "> STARTING #####");
		System.out.println("[" + currentThreadName+ "] <" + taskId + "> Sleeping for " + sleepTime + "millis");

		TimeUnit.MILLISECONDS.sleep(sleepTime);

		sum = a+b;

		System.out.println("***** ["+ currentThreadName + "] <" + taskId + "> DONE *****");

		return new TaskResult<String, Integer>(taskId, sum);
	}
	
}
