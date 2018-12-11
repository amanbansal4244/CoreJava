package ReadingFileAndCommitingIntoDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main_Way1_UsingBufferedReader {

	private static final String records = null;
	private static String fileName = "/Users/bansal/Desktop/Study Material/Workspace/Core_Java_Eclipse_Code/ExecutorFramework_MultiThreading/TestInput.txt";
	
	Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
	    public void uncaughtException(Thread th, Throwable ex) {
	        System.out.println("Uncaught exception: " + ex);
	    }
	};
	
	private static void openFile(String fileName2) {
		
		BufferedReader reader;
		long startTime = System.nanoTime();
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line;
			ExecutorService executorService = Executors.newFixedThreadPool(20000);
			
			while((line = reader.readLine()) !=null) {
				/****  \ is consider to be escape char in java, so to get correct regex. you need to escape \ with \ and t to indicate tab.
				 * means here we are separating the line from Tab which is used in input file ****/
				Runnable worker = new WorkerThread(line.split("\t"));
				executorService.execute(worker);
			}
			//t.setUncaughtExceptionHandler(h);
			executorService.shutdown();
			reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		long endTime = System.nanoTime();
		long elapsedTimeInMillies = TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS);
		System.out.println("Total Elapsed Time :" + elapsedTimeInMillies + "ms");
		
	}
	
	public static void main(String[] args) {
		openFile(fileName);
	}
}
