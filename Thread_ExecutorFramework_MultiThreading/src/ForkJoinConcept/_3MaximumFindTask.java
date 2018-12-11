package ForkJoinConcept;

import java.util.concurrent.RecursiveTask;

public class _3MaximumFindTask extends RecursiveTask<Long> {

	private long[] nums;
	private int lowIndex;
	private int highIndex;
	
	public _3MaximumFindTask(long[] nums, int lowIndex, int highIndex) {
		this.highIndex = highIndex;
		this.lowIndex = lowIndex;
		this.nums = nums;
	}

	/****
	 * 1.	In sequential algorithm, threads do not need to communicate to each other and communication with each other's is quite expensive. 
	 * So, conclusion, we should use parallel algorithm whenever we have millions or billions of data. 
	 * If we use the parallel algorithm in smaller number of data then parallel algorithm will cost you in time and performance. 
	 * So smaller number of data, we should always use sequential algorithm.
	 * 
	 * 2. If we are using parallel algorithm, then make sure we split the work equally amongst the processor.
	 */
	@Override
	protected Long compute() {
		
		if( highIndex - lowIndex < _3App.THREASHOLD ) {
			return sequentialMaxFinding();
		} else {
			/*Splitting the array equally into two sub-array. */
			int middleIndex = (lowIndex+highIndex) / 2;
			
			_3MaximumFindTask leftSubtask = new _3MaximumFindTask(nums, lowIndex, middleIndex);
			_3MaximumFindTask rightSubtask = new _3MaximumFindTask(nums, middleIndex, highIndex);
			
			/*'invokeAll()' method means, both of the recursive task 'leftSubtask' and 'rightSubtask' is going to be
			 * executed in parallel manner , so they are inserted into the fork-join pool.
			 * */
			invokeAll(leftSubtask, rightSubtask);
			
			/*We would like to find the maximum element from one dimensional array nums[] between lowIndex and highIndex
			 * means we wait both leftSubtask and rightSubtask tasks to complete and then find the maximum from both of these tasks. */
			return Math.max(leftSubtask.join(), rightSubtask.join());
		}
	}
	
	private long sequentialMaxFinding() {
		
		long max = nums[0];
		
		for(int i=lowIndex; i<highIndex;++i)
			if( nums[i] > max)
				max = nums[i];
		
		return max;
	}
}
