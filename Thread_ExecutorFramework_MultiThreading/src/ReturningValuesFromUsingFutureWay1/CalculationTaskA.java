package ReturningValuesFromUsingFutureWay1;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskA implements Callable<Integer> {
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
		this.taskId = "CalculationTaskA-" + instanceNumber;
		
	}
	
	@Override
	public Integer call() throws Exception{
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("#### [" + currentThreadName+ "] <" + taskId + "> STARTING #####");
		System.out.println("[" + currentThreadName+ "] <" + taskId + "> Sleeping for " + sleepTime + "millis");

		TimeUnit.MILLISECONDS.sleep(sleepTime);

		sum = a+b;

		System.out.println("***** ["+ currentThreadName + "] <" + taskId + "> DONE *****");

		return sum;
	}
	
}
