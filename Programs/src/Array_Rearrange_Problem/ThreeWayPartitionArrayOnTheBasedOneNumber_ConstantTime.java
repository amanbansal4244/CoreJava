package Array_Rearrange_Problem;

import DataStructure.QuickSort_SinglePivot;
/*
Algorithm based on 'Dutch national flag sorting problem'
 
The solution to this algorithm will require 3 pointers to iterate throughout the array, swapping the necessary elements.

(1) Create a low pointer at the beginning of the array and a high pointer at the end of the array.
(2) Create a mid pointer that starts at the beginning of the array and iterates through each element.
(3) If the element at arr[mid] > 23, then swap arr[mid] and arr[high] and decrease the high pointer by 1.
(4) If the element at arr[mid] < 23, then swap arr[mid] and arr[low] and increase the low and mid pointers by 1.
(5) If the element at arr[mid] == 23, don't swap anything and just increase the mid pointer by 1.

This algorithm stops once the mid pointer passes the high pointer.

*/
public class ThreeWayPartitionArrayOnTheBasedOneNumber_ConstantTime {
	// Linear-time partition routine to arrange an array into three partition i.e. no<23, no=23 , n0>23
	// It similar to three-way Partitioning for Dutch national flag problem
	public static void threeWayPartition(int arr[], int end,int pivot)
	{
		int start = 0, mid = 0;
		if(end <= 1 ){
			return;
		}
		while (mid <= end)
		{
			if (arr[mid] < pivot)			// current element is <23
			{
				swap(arr,start, mid);
				start++;
				mid++;
			}
			else if (arr[mid] > pivot)	// current element is >23
			{
				swap(arr,mid,end);
				end--;
			}
			else if(arr[mid] == pivot)	// current element is 23
				mid++;
		}
	}
	 //Utility function to swap array elements
    static void swap(int []a, int i, int j){ 
        int t = a[i];
        a[i] = a[j]; 
        a[j] = t; 
    }
	// main function
	public static void main (String[] args)
	{
		int []arr = {12, 33, 45,6, 7,23, 22, 15, 44, 9, 8, 90,3, 100, 55, 4}; // dividing no(pivot) = 23;
		int n = arr.length;
		int pivot = 23;
		threeWayPartition(arr, n - 1, pivot);

		for (int i = 0 ; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
