package DiningPhilosopherProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService = null;
		Philosopher[] philosophers = null;
		
		try{
			
			philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];
			ChopStick[] chopSticks = new ChopStick[Constants.NUMBER_OF_PHILOSOPHERS];
			
			for(int i=0;i<Constants.NUMBER_OF_CHOPSTICKS;i++){
				chopSticks[i] = new ChopStick(i);
			}
			
			/*Number of threads is going to be equal to the no of the PHILOSOPHER.*/
			executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);
			
			for(int i=0;i<Constants.NUMBER_OF_PHILOSOPHERS;i++){
				/* Here, we assign left and right chopSticks to the each philosopher*/
				philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i+1) % Constants.NUMBER_OF_PHILOSOPHERS]);
				executorService.execute(philosophers[i]);
			}
			
			Thread.sleep(Constants.SIMULATION_RUNNING_TIME); // We are to sleep as per SIMULATION_RUNNING_TIME
			
			//Then we have to stop the application once SIMULATION_RUNNING_TIME is over by setting 'setFull'
			for(Philosopher philosopher : philosophers){
				philosopher.setFull(true); // once this is set to full, then our SIMULATION will stop execution.
			}		
		}finally{
			/****
			 * shutdown() -> Initiates an orderly shutdown in which previously submitted tasks are executed,
			 *  but no new tasks will be accepted. Invocation has no additional effect if already shut down.
			 */
			executorService.shutdown();
			
			/*isTerminated() -> Returns true if all tasks have completed following shut down. 
			 * We should write this line of code to make sure that all executor task has been completed.*/
			while(!executorService.isTerminated()){
				Thread.sleep(1000);
			}
			
			/* Counting how many times a given Philosopher has eaten.*/
			for(Philosopher philosopher : philosophers ){
				System.out.println(philosopher+" has eaten #"+philosopher.getEatingCounter() + " times");
			}
			
		}
		
	}
}
