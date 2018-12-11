package ProducerConsumerProblemConcept;

import java.util.ArrayList;

import javax.swing.plaf.SliderUI;

public class Producer implements Runnable{

	ArrayList<Integer> arrayList;
	
	public Producer() {
		arrayList = new ArrayList<Integer>();
	}

	@Override
	public void run() {
		synchronized(this){
			System.out.println("Producer is producing the items..");
			try{
				for(int i =0 ; i< 10; i++){
					arrayList.add(i);
					System.out.println("Producer is still producing the items, producded item no :"+ i);
					Thread.sleep(1000);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println("Production is over and notfying the consumer to consume the prodcued items..");
			this.notify();
		}
	}
}
