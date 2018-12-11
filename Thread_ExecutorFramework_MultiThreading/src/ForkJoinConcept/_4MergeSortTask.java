package ForkJoinConcept;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class _4MergeSortTask extends RecursiveAction {

	private int[] nums;

	public _4MergeSortTask(int[] nums) {
		this.nums = nums;
	}

	@Override
	protected void compute() {
		if (nums.length <= 10) {
			mergeSort(nums);
			return;
		}

		int middleIndex = nums.length / 2;

		int[] leftSubarray = Arrays.copyOfRange(nums, 0, middleIndex);
		int[] rightSubarray = Arrays.copyOfRange(nums, middleIndex, nums.length);

		_4MergeSortTask leftSorter = new _4MergeSortTask(leftSubarray);
		_4MergeSortTask rightSorter = new _4MergeSortTask(rightSubarray);

		invokeAll(leftSorter, rightSorter);

		merge(leftSubarray, rightSubarray, nums);

	}

	public void mergeSort(int[] nums) {

		if (nums.length <= 1)
			return;

		int mid = nums.length / 2;

		int[] left = Arrays.copyOfRange(nums, 0, mid);
		int[] right = Arrays.copyOfRange(nums, mid, nums.length);

		mergeSort(left);
		mergeSort(right);

		merge(left, right, nums);
	}

	private void merge(int[] leftSubarray, int[] rightSubarray, int[] originalArray) {

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < leftSubarray.length && j < rightSubarray.length) {
			if (leftSubarray[i] < rightSubarray[j])
				originalArray[k++] = leftSubarray[i++];
			else
				originalArray[k++] = rightSubarray[j++];
		}

		while (i < leftSubarray.length)
			originalArray[k++] = leftSubarray[i++];

		while (j < rightSubarray.length)
			originalArray[k++] = rightSubarray[j++];
	}

}
