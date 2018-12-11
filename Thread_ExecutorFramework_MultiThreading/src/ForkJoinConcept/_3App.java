package ForkJoinConcept;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
/****
 * Finding the maximum element from given array with in one range using
 * sequential and parallel execution.
 * @author bansal
 *
 */
public class _3App {

	public static int THREASHOLD = 0;
	
	public static void main(String[] args) {
		
		long[] nums = initializeNums();
		THREASHOLD =  nums.length / Runtime.getRuntime().availableProcessors();
		
		_3SequentialMaxFind normalMaxFind = new _3SequentialMaxFind();
		
		long start = System.currentTimeMillis();
		System.out.println("Max using sequential approach: " + normalMaxFind.sequentialMaxFinding(nums, nums.length));
		System.out.println("Time taken using sequential approach: " + (System.currentTimeMillis() - start) + "ms");

		System.out.println();
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		_3MaximumFindTask findTask = new _3MaximumFindTask(nums, 0, nums.length);
		
		start = System.currentTimeMillis();
		
		System.out.println("Max using fork-join pool - parallel approach: " + forkJoinPool.invoke(findTask));
		System.out.println("Time taken using fork-join pool - parallel approach: " + (System.currentTimeMillis() - start) + "ms");
	}

	private static long[] initializeNums() {
		
		Random random = new Random();
		
		long[] nums = new long[300000000];
		
		for(int i=0;i<300000000;++i)
			nums[i] = random.nextInt(100);
		
		return nums;
	}
}
