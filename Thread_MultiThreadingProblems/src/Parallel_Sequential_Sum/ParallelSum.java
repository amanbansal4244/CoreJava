package Parallel_Sequential_Sum;

public class ParallelSum {

	private ParallelWorker[] sums;
	private int numOfThreads;
	
	public ParallelSum(int numOfThreads) {
		this.sums = new ParallelWorker[numOfThreads];
		this.numOfThreads = numOfThreads;
	}
	
	public int parallelSum(int[] nums) {
		
		//This is how we divide the no of element by numOfThreads from given array, so that every thread get same no of element to process.
		//So we are balancing the 'load balance' here.
		int size = (int) Math.ceil(nums.length * 1.0 / numOfThreads);

		for (int i = 0; i < numOfThreads; i++) {
			sums[i] = new ParallelWorker(nums, i * size, (i + 1) * size);
			sums[i].start();
		}

		try {
			for (ParallelWorker sum : sums) {
				sum.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int total = 0;

		for (ParallelWorker sum : sums) {
			total += sum.getPartialSum();
		}

		return total;
	}

}
