package ReverseStringArrayElementsUsingExecutorInterface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		String str[] = {"aman", "kumar", "bansal"};
		int strLength = str.length;
		
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); 
		
		for(int i=0; i< strLength; i++) {
			Runnable runnable = new Worker(str[i]);
			executorService.execute(runnable);
			Thread.sleep(5);
		}
	}
}
