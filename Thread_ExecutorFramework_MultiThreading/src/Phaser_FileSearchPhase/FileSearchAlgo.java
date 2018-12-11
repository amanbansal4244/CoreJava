package Phaser_FileSearchPhase;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/****
 * This class implements the operation of searching for files with a determined extension modified in the last 
 * 24 hours in a folder and its sub-folders.
 * @author bansal
 *
 */
public class FileSearchAlgo implements Runnable{

	/*This attribute to store the folder in which the search operation will begin */
	private final String initPath;
	/*This attribute to store the extension of the files we are going to look for */
	private final String fileExtension;
	/*This attribute to store the full path of the files we will find with the desired characteristics */
	private List<String> resultsList;
	/*This attribute to control the synchronization of the different phases of the task */
	private Phaser phaser;
	
	
	public FileSearchAlgo(String initPath, String fileExtension, Phaser phaser) {
		super();
		this.initPath = initPath;
		this.fileExtension = fileExtension;
		this.phaser = phaser;
		resultsList = new ArrayList<>();
	}

	/****
	 * It's time to implement the run() method that executes the operation using the auxiliary methods that described below.
	 * We will also implement the Phaser object to control the change between phases. 
	 * First, call arriveAndAwaitAdvance method of Phaser object but the search won't begin until all the threads have been created.
	 */
	@Override
	public void run() {
		// Using await and advance so that all thread wait here.
		phaser.arriveAndAwaitAdvance();
		
		/*Then, write a message to the console indicating the start of the search task. */
		System.out.println("Starting Thread Name:"+
				Thread.currentThread().getName());
		
		/****
		 * Check that the 'initPath' attribute stores the name of a folder and use the 'directoryProcess()' method
		 * to find the files with the specified extension in that folder and all its sub-folders.
		 */
		File file = new File(initPath);
		if(file.isDirectory()) {
			directoryProcess(file);
		}
		
		/****
		 * Check whether there are any results using the 'checkResults()' method. If there are no results,
		 * finish the execution of the thread with the return keyword.
		 */
		if(!checkResults()) {
			return;
		}
		
		/*filter the list of results. */
		filterResults();
		
		/****
		 * Check once again, whether there are any results using the 'checkResults()' method. If there are no results,
		 * finish the execution of the thread with the return keyword.
		 */
		if(!checkResults()) {
			return;
		}
		
		/****
		 * Prints the final list of the results to the console with the 'showInfo()' method,
		 * deregister the thread, and print a message indicating the finalization of the thread. 
		 * 
		 */
		showInfo();
		phaser.arriveAndDeregister();
		
		System.out.println("Work Completed by Thread name ->"+
				Thread.currentThread().getName());
	}
	
	
	/****
	 * It receives a File object as a parameter and it process all its files and sub-folders. 
	 * For each folder, the method will make a recursive call while passing the folder as a parameter.
	 * For each file, the method will call the fileProcess() method.
	 * @param file
	 */
	private void directoryProcess(File file) {
		File list[] = file.listFiles();
		if(list != null) {
			for(int i=0; i<list.length; i++) {
				if(list[i].isDirectory()) {
					directoryProcess(list[i]);
				}else {
					fileProcess(list[i]);
				}
			}
		}
	}

	/****
	 * It receives a File object as a parameter and checks whether its extension is equal to the one
	 * we are looking for. If they are equal, this method adds the absolute path of the file to the list of the results.
	 * @param file
	 */
	private void fileProcess(File file) {
		if(file.getName().endsWith(fileExtension)) {
			resultsList.add(file.getAbsolutePath());
		}
	}
	
	/****
	 * It does not receive any parameter and filters the list obtained in the first phase;
	 * it deletes files that were modified more than 24 hours ago. First , create a empty list
	 * and get the actual date.
	 * 
	 * Then go through all the elements of the result list. For each path in the list of results,
	 * creates a File object for the file and get its last modified date.
	 * 
	 * Then compare this date with the actual date, and if the difference is less than 1 day,
	 * add the full path of the file to the new list of results.
	 * 
	 * and Finally change the old results list to the new ones
	 * @param file
	 */
	private void filterResults() {
		List<String> newResultsList = new ArrayList<>();
		long actualDate = new Date().getTime();
		
		for(int i=0; i<resultsList.size(); i++) {
			File file = new File(resultsList.get(i));
			long fileDate = file.lastModified();
			if(actualDate-fileDate < TimeUnit.MILLISECONDS.convert(1,TimeUnit.DAYS)) {
				newResultsList.add(resultsList.get(i));
			}
		}
		
		/*Finally change the old results list to the new ones */
		resultsList = newResultsList;
		
	}
	
	/****
	 * This method will be called at the end of first and second phase, and it will 
	 * check whether the results list is empty or not. This method does not have any parameters.
	 * @return
	 */
	private boolean checkResults() {
		
		/****
		 *  First, check the size of the results list. if it's 0, the object writes a message to the console indicating this.
		 * After this, it calls the arriveAndDeregister method of the Phaser object to notify that this thread has finished 
		 * the actual phase and it leaves the phased operation.
		 */
		if(resultsList.isEmpty()) {
			System.out.println("There are no file for: Thread Name-> "+
					Thread.currentThread().getName()+ " and Phaser info->" +
					phaser.getPhase());

			/*Arrives at this phaser and deregisters from it without waiting for others to arrive */
			phaser.arriveAndDeregister();
			return false;
		}
		/*****
		 * If the results list has the elements , the object writes a message to the console indicating this.
		 * Then, it calls the arriveAndAwaitAdvance method of the Phaser object to notify that this thread
		 * has finished the actual phase and it wants to be blocked until all the participant threads in the
		 * phased operation finish the actual phase means we are making current thread to wait (don't move forward) till the other
		 *  thread reach to this stage. 
		 */
		else {
			System.out.println("We got some files which is modified more than 24 hours ago and executed by : Thread Name-> "+
					Thread.currentThread().getName()+ " and Phaser info->" +
					phaser.getPhase() + " and Result List size-> " + resultsList.size());

			/*Arrives at this phaser and awaits others */
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}
	
	/****
	 * The last auxiliary method is the showInfo() method that prints the elements of the results list to the console.
	 */
	private void showInfo() {
		for(int i=0; i<resultsList.size(); i++) {
			File file = new File(resultsList.get(i));
			System.out.println("Info about file which got which is modified more than 24 hours ago and executed by : Thread Name->"+
					Thread.currentThread().getName()+ " and File Path->" +
 					file.getAbsolutePath());

			phaser.arriveAndAwaitAdvance();
		}
	}

}
