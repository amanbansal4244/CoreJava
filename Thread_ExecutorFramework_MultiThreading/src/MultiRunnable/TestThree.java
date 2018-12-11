package MultiRunnable;

public class TestThree implements Runnable {

	@Override
	public void run() {
		System.out.println("Executing Task Three and Thread Name:" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}

}
