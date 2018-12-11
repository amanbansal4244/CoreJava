package Semaphore_And_MutexConcept;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphores – Restrict the number of threads that can access a resource. Example, limit max 10 connections 
 * to access a file simultaneously.
 * 
   Mutex – Only one thread to access a resource at once. Example, when a client is accessing a file, 
   no one else should have access the same
    file at the same time.
 * 
 * 
 * 	- semaphore maintains a set of permits
 *	- acquire() -> if a permit is available then takes it
 *	- release() -> adds a permit
 *		
 *	Semaphore just keeps a count of the number available.
 *		new Semaphore(int permits, boolean fairnessParameter) !!!
 */

enum Downloader {
	
	INSTANCE; // Singleton Pattern using enum which is by default thread safe.
	
	/****
	 * Suppose Facebook server has one picture and 1000000 users comes at the same time to download that picture from FB server.
	 * then may be Facebook server may get down if  1000000 users comes to download at the same time
	 * So Facebook comes and say we allow only 5 users(Threads) to download at a one time and other Users(Threads) 
	 * has to wait till already running Users(threads) to finished their downloading.
	 * 
	 * We are creating Semaphore with number of permits 5 and fairness true that means 5 Threads can manipulate the Semaphore in the sense
	 * 5 Threads can download the data from web at the same time and all the other threads(Total threads/tasks 12 means other 12-5 = 7 Threads) 
	 * are going to wait for these threads to finished their task.
	 */
	private Semaphore semaphore = new Semaphore(5, true);
	
	public void downloadData() {
		
		try {
			//System.out.println("Thread acquire:" + Thread.currentThread().getName());
			semaphore.acquire(); // Acquiring the LOCK.
			download();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//System.out.println("Thread release:" + Thread.currentThread().getName());
			semaphore.release();// Releasing the LOCK.
		}
		
	}

	private void download() {
		System.out.println("Downloading data from the web...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class _1Semaphore_FacebookImageDownloder {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(7);
		
		/****here, we are submitting 12 tasks via calling 'execute' method 12 times in loop.
		 * Now, 7 Threads will be active processing tasks (since we have used Executors.newFixedThreadPool(7))
		 * but we are creating Semaphore with number of permits 5 that means 5 Threads can manipulate the Semaphore in the sense
		 * 5 Threads can download the data from web at the same time and all the other threads(Total threads/tasks 12 means other 12-5 = 7 Threads) 
		 * are going to wait for these threads to finished their task.
		 */
		for(int i=0;i<12;i++) {
			executorService.execute(new Runnable() {
				public void run() {
					Downloader.INSTANCE.downloadData();
				}
			});
		}
		
	}
}