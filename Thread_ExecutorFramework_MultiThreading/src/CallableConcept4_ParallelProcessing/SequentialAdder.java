package CallableConcept4_ParallelProcessing;

public class SequentialAdder {
	
	public int sequentialSum(int n)
	{                      
		//long t1 = System.currentTimeMillis();
		Integer totsum=0;                        
		for(int i=0;i<n;i++)
		{
			totsum=totsum+i;                                               
		}                       
		//long t2 = System.currentTimeMillis();                       
		System.out.println("sequentialSum Total Sum is " + totsum);
		//System.out.println("Time taken by sequentialSum " + (t2-t1));
		return totsum;
	}   
}
