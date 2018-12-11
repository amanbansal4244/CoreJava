package DiningPhilosopherProblem;

public class Constants {

	/*I don't want to initialized this class, so making constructor as private. */
	private Constants(){
		
	}
	
	public static final int NUMBER_OF_PHILOSOPHERS = 5;
	public static final int NUMBER_OF_CHOPSTICKS = NUMBER_OF_PHILOSOPHERS;
	/*How many MILLISECONDS we are going to run our application. 
	 * Let's say we are going to run application for 5 seconds */
	public static final int SIMULATION_RUNNING_TIME = 5*1000;
	
}
