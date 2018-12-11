package MergeSort_Programs;

import java.util.Random;
/****
 * In this program, we are checking when we should use parallel or sequential algorithm to sort array using merge sort.
 * @author bansal
 *
 */
public class App {

	public static Random random = new Random();

	public static void main(String[] args) throws Throwable {

		//We are calculating the numbers of threads based on numbers of processor or core in a system so that application runs fine.
		int numOfThreads  = Runtime.getRuntime().availableProcessors();

		System.out.println("Number of threads/cores: " + numOfThreads);
		System.out.println("");


		int[] numbers = createRandomArray();
		Parallel_Sequential_MergeSort mergeSort = new Parallel_Sequential_MergeSort(numbers);
		
		// run the algorithm and time how long it takes
		long startTime1 = System.currentTimeMillis();
		/****
		 * Parallel Algorithm : We can sort with the multiple processor or multicore processor
		 * 					    We can assign a task to every processor to parallel computing.
		 * 						using this , we can assign left side of array to one processor(one thread) to sort
		 * 						and right side of array to other processor(other thread) to sort.	
		 */
		mergeSort.parallelMergeSort(0, numbers.length-1, numOfThreads);

		//mergeSort.showResult();
		long endTime1 = System.currentTimeMillis();

		System.out.printf("Time taken in parallel merge sort =>  %6d ms \n", endTime1 - startTime1);
		System.out.println("");

		startTime1 = System.currentTimeMillis();
		mergeSort.sequentialMergeSort(0,numbers.length-1);
		endTime1 = System.currentTimeMillis();

		System.out.printf("Time taken for in sequential merge sort  =>  %6d ms \n", endTime1 - startTime1);
		System.out.println("");

	}

	/****
	 * In sequential algorithm, threads don't need to communicate to each other and communication with 
	 * each others is quite expensive. So conclusion, we should use parallel algorithm whenever we have millions or billions of data.
	 * @return
	 */
	public static int[] createRandomArray() {
		int[] a = new int[100];
		for (int i = 0; i < 100; i++) {
			a[i] = random.nextInt(1000000);			
		}
		return a;
	}
}
