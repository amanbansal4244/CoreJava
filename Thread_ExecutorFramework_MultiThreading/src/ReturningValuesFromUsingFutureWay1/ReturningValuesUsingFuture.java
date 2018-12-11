package ReturningValuesFromUsingFutureWay1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturningValuesUsingFuture {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("[" + currentThreadName + "] Main thead starts here.....");
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		Future<Integer> result1 = executorService.submit(new CalculationTaskA(2,3, 2000));
		Future<Integer> result2 = executorService.submit(new CalculationTaskA(4,5, 1000));
		Future<Integer> result3 = executorService.submit(new CalculationTaskA(7,6, 100));
		
		
		executorService.shutdown();
		try {
			System.out.println("result-1:"+ result1.get());
			System.out.println("result-2:"+ result2.get());
			System.out.println("result-3:"+ result3.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("[" + currentThreadName + "] Main thead ends here.....");
		
	}
}
