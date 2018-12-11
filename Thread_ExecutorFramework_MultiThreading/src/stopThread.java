import java.io.IOException;


public class stopThread extends Thread {
	boolean stop=false;
	public void run()
	{
		for(int i=0;i<=40;i++){
			System.out.println(i);
			if(stop)
				return;
		}
	}
}

class aa1{
	public static void main(String[] args) throws IOException {
		stopThread obj = new stopThread();
		Thread t = new Thread(obj);
		t.start();
		System.in.read();
	//	obj.stop=true;
	}
}

