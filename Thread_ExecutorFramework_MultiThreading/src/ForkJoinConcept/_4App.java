package ForkJoinConcept;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
/****
 * Finding the merging the array using sequential and parallel execution.
 * @author bansal
 *
 */
public class _4App {

	public static void main(String[] args) {

		int[] nums = initializeNums();
		_4SequentialMergesort mergesort = new _4SequentialMergesort(nums);

		long start = System.currentTimeMillis();
		mergesort.mergeSort(nums);
		System.out.println("Time taken with sequential sort: " + (System.currentTimeMillis() - start) + "ms");
		
		_4MergeSortTask rootTask = new _4MergeSortTask(nums);
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		start = System.currentTimeMillis();
		pool.invoke(rootTask);
		System.out.println("Time taken with parallel sort: " + (System.currentTimeMillis() - start) + "ms");
		
		
	}

	private static int[] initializeNums() {

		Random random = new Random();

		int[] nums = new int[100000000];

		for (int i = 0; i < 100000000; ++i)
			nums[i] = random.nextInt(100);

		return nums;
	}
}
