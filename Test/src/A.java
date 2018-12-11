
public class A {

	public static void main(String[] args) {
		Thread loop = new Thread(
				new Runnable() {
					@Override
					public void run() {
						while (true) {
							if (Thread.interrupted()) {
								break;
							}
							System.out.println("aman");
							// Continue to do nothing
						}
					}
				}
				);
		loop.start();
		loop.interrupt();
	}

}
