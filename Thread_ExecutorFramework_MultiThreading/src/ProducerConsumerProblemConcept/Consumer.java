package ProducerConsumerProblemConcept;

public class Consumer implements Runnable {

	Producer prod;
	public Consumer(Producer obj) {
		prod = obj;
	}
	
	@Override
	public void run() {
		synchronized (this.prod) {
			System.out.println("Waiting for producer to produced the items and notify me..");
			try{
				this.prod.wait();
			}catch(Exception e){
				e.printStackTrace();
			}
		} // end of synchronized block.
		
		System.out.println("Producer has produced all the items and ready to cunsumed");
		int productSize =this.prod.arrayList.size();
		for(int i = 0 ; i <productSize; i++){
			System.out.println("Consumed Item :" + this.prod.arrayList.remove(0));
		}
	}
	
	
}
