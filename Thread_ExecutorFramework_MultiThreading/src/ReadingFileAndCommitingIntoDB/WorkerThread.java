package ReadingFileAndCommitingIntoDB;

import java.util.ArrayList;

public class WorkerThread implements Runnable{
	
	private String[] command;
	
	public WorkerThread(String[ ] s) {
		this.command = s;
	}

	@Override
	public void run() {
		Record r = new Record(command[0], command[1], command[2]);
		try{
			DBConnection.saveInfoInDB(r);
		}catch(Exception e) {
			System.out.println("Exception occurred . In run method.......");
			e.printStackTrace();
		}
	}
	
	
}
