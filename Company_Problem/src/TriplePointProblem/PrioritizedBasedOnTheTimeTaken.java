package TriplePointProblem;

import java.util.Comparator;

class PrioritizedBasedOnTheTimeTaken implements Comparator<Task>
{      
	public int compare(Task o1,Task o2)
	{  	
		return o2.timeTaken() - o1.timeTaken();
	}  
}  
