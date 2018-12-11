package HandlingUncaughtException_UncaughtExceptionHandler;

import java.lang.Thread.UncaughtExceptionHandler;

public class CustomThreadExceptionHandler implements UncaughtExceptionHandler{

	private String handleId;
	
	public CustomThreadExceptionHandler(String handleId) {
		this.handleId = handleId;
	}
	
	//Default constructor if we don't want to provide any id.
	public CustomThreadExceptionHandler() {

	}
	
	/****
	 * To know the which thread got failed due to which exception.
	 */
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// do something here - log to the file and upload to server/close resources/delete files...
		//or we simply can restart the worker thread to ensure the processing still occurs.
		System.out.println(this + " caught exception in thread- \"" +
							t.getName() + "\" => "+ e);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "@" + this.hashCode() + 
				(handleId == null || "".equals(handleId) ? "" :  "(\"" + handleId + "\")" );
	}
	
}
