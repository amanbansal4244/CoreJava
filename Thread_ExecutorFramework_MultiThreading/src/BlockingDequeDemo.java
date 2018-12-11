import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
public class BlockingDequeDemo {
	static BlockingDeque<String> bd=new LinkedBlockingDeque<String>(1);
	public static void main(String[] args) {
		ExecutorService exService = Executors.newFixedThreadPool(2);
		BlockingDequeDemo bdeque = new BlockingDequeDemo();
		ElementAdd elementAdd = bdeque.new ElementAdd();
		ElementGet elementGet = bdeque.new ElementGet();
		exService.execute(elementAdd);
		exService.execute(elementGet);
		exService.shutdown();
	}
	class ElementAdd implements Runnable{
		@Override
		public void run() {
			for(;;){
				try {
					String s= bd.take();
					System.out.println("Element received is: "+s);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	class ElementGet implements Runnable{
		@Override
		public void run() {
			for(int i=0;i < 5;i++){
				try {
					bd.put("A"+i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
} 