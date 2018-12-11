package CallableConcept4_ParallelProcessing;
/*
Problem : Suppose the problem is to find a sum of all numbers from 1 to 100.
Way1 : We can do it by looping 1 to 100 sequentially and adding them.
Way2 : We can do it by divide and conquer rule. Group the numbers in a way so each group has exactly two elements.
       Then assign that group to a pool of threads. So each thread returns a partial sum in parallel, then 
       collect those partial sums and add them to get the whole sum.
*/
public class Main {
	public static void main(String[] args) {                       
		ParallelAdder parallelAdder = new ParallelAdder();
		SequentialAdder sequentialAdder = new SequentialAdder();
		int pSum= parallelAdder.parallelSum(100);
		int sSum= sequentialAdder.sequentialSum(100);                       
		System.out.println("parallel Sum equals to Sequential Sum ? " );
		System.out.println("Answer is :: " + (pSum==sSum));                                                                                          
	}
}
