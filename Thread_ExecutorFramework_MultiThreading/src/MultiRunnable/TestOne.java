package MultiRunnable;

public class TestOne implements Runnable {

	@Override
	public void run() {
		System.out.println("Executing Task One and Thread Name:" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}

}
