package TriplePointProblem;

import java.util.Comparator;

class PrioritizedBasedOnTheServiceFee implements Comparator<Task>
{  
	public int compare(Task o1,Task o2)
	{  
		return o2.serviceFee() - o1.serviceFee();
	}
} 