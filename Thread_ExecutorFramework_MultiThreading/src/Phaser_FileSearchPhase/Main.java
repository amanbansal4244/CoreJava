package Phaser_FileSearchPhase;

import java.util.concurrent.Phaser;

public class Main {
	
	
	public static void main(String[] args) {
		
		/*Create a Phaser object with three participants */
		Phaser phaser = new Phaser(3);

		/****
		 * Create three FileSearch objects with a different initial folder for each one.
		 * Look for the files with the '.log' extension.
		 */
		FileSearchAlgo system = new FileSearchAlgo("/Users/bansal/Desktop/Study Material/Workspace/TestFilesFolder/system", "log", phaser);
		FileSearchAlgo apps = new FileSearchAlgo("/Users/bansal/Desktop/Study Material/Workspace/TestFilesFolder/apps", "log", phaser);
		FileSearchAlgo document = new FileSearchAlgo("/Users/bansal/Desktop/Study Material/Workspace/TestFilesFolder/document", "log", phaser);

		/*Create and start a thread to execute the first FileSearch object.*/
		Thread systemThread = new Thread(system,"SystemThread");
		systemThread.start();

		/*Create and start a thread to execute the second FileSearch object.*/
		Thread appsThread = new Thread(apps,"AppsThread");
		appsThread.start();

		/*Create and start a thread to execute the third FileSearch object.*/
		Thread documentThread = new Thread(document,"DocumentsThread");
		documentThread.start();

		/*Wait for the initialization of the three threads */
		try {
			systemThread.join();
			appsThread.join();
			documentThread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
