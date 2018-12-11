package Parallel_Sequential_Sum;

public class ParallelWorker extends Thread {

	private int[] nums;
	/****
	 * One thread at a one time is going to calculate sum with in some interval
	 * so 'low' index will be start of that interval array
	 * and 'high' index will be end of that interval array.
	 * and sum of interval array between 'low' and 'high' index will be stored into 'partialSum'.
	 */
	private int low;
	private int high;
	private int partialSum;

	public ParallelWorker(int[] nums, int low, int high) {
		this.nums = nums;
		this.low = low;
		this.high = Math.min(high, nums.length);
	}

	public int getPartialSum() {
		return partialSum;
	}

	@Override
	public void run() {
		
		partialSum = 0;

		for (int i = low; i < high; i++) {
			partialSum += nums[i];
		}
	}
}
