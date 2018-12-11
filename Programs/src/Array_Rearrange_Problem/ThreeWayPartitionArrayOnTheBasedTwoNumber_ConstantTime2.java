package Array_Rearrange_Problem;

import DataStructure.QuickSort_SinglePivot;

public class ThreeWayPartitionArrayOnTheBasedTwoNumber_ConstantTime2 {
	// Linear-time partition routine to arrange an array into three partition i.e. no<23, no=23 , n0>23
	// It similar to three-way Partitioning for Dutch national flag problem
	public static void threeWayPartition(int arr[], int end,int pivot1, int pivot2)
	{
		int start = 0, mid = 0;
		if(end <= 1 ){
			return;
		}
		while (mid <= end)
		{
			if (arr[mid] < pivot1)			// current element is <23
			{
				swap(arr,start,mid);
				start++;
				mid++;
			}
			
			else if (arr[mid] > pivot2)	// current element is >23
			{
				swap(arr,mid,end);
				end--;
			}
			else{
				mid++;
			}
		}
		System.out.println("aman");
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
		//int [] arr= {3,4,35,36,23,44,67,78};
		int []arr = {12, 33, 45,6, 7,23, 22, 15, 44, 9,35, 8, 90,3, 100, 55, 4}; // Separating array by given no(pivot) = 23;
		int n = arr.length;
		int pivot1 = 23;
		int pivot2 = 90;
		threeWayPartition(arr, n - 1, pivot1, pivot2);

		for (int i = 0 ; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
