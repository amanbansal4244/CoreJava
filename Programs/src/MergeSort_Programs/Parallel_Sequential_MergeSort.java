package MergeSort_Programs;

public class Parallel_Sequential_MergeSort {

	private int[] nums;
	private int[] tempArray;

	public Parallel_Sequential_MergeSort(int[] nums) {
		this.nums = nums;
		tempArray = new int[nums.length];
	}
	//We are assigning the threads based on numbers of processor or core in a system.
	public void parallelMergeSort(int low, int high, int numOfThreads) {

		/*If the no of threads is less than 1, then we should use sequentialMergeSort only. */
		if (numOfThreads <= 1) {
			sequentialMergeSort(low, high);
			return;
		}

		int middleIndex = (low + high) / 2;

		//Creating the thread to sort left sub array.
		Thread leftSorter = mergeSortThread(low, middleIndex, numOfThreads);
		//Creating the thread to sort right sub array.
		Thread rightSorter = mergeSortThread(middleIndex+1, high, numOfThreads);

		//Starting the thread
		leftSorter.start();
		//Starting the thread
		rightSorter.start();

		try {
			/*We need to make sure that each thread going to wait of each other before to merger them together. */
			leftSorter.join();
			rightSorter.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Merging results of both threads.
		merge(low, middleIndex, high);
	}

	private Thread mergeSortThread(int low, int high, int numOfThreads) {

		return new Thread() {
			@Override
			public void run() {
				parallelMergeSort(low, high, numOfThreads / 2);
			}
		};
	}

	public void sequentialMergeSort(int low, int high) {

		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;

		sequentialMergeSort(low, middle);
		sequentialMergeSort(middle + 1, high);
		merge(low, middle, high);
	}

	public void showResult() {
		for (int i = 0; i < nums.length; ++i) {
			System.out.print(nums[i] + " ");
		}
	}

	private void merge(int low, int middle, int high) {

		// Copy nums[i] -> temp[i]
		for (int i = low; i <= high; i++) {
			tempArray[i] = nums[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		// Copy the smallest values from either the left or the right side back
		// to the original array
		while ((i <= middle) && (j <= high)) {
			if (tempArray[i] <= tempArray[j]) {
				nums[k] = tempArray[i];
				i++;
			} else {
				nums[k] = tempArray[j];
				j++;
			}

			k++;
		}

		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			nums[k] = tempArray[i];
			k++;
			i++;
		}
	}
}
