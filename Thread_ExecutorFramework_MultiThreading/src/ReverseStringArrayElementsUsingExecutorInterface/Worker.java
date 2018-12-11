package ReverseStringArrayElementsUsingExecutorInterface;

public class Worker implements Runnable{

	String str;

	public Worker(String str) {
		this.str = str;
	}
	
	@Override
	public void run() {
		try{
			ReverseUtility.reverseString(str);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
