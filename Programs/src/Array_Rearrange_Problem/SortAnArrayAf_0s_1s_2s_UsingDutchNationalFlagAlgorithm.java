package Array_Rearrange_Problem;
/*
Algorithm based on 'Dutch national flag sorting problem'
 
The solution to this algorithm will require 3 pointers to iterate throughout the array, 
swapping the necessary elements.

(1) Create a low pointer at the beginning of the array and a high pointer at the end of the array.
(2) Create a mid pointer that starts at the beginning of the array and iterates through each element.
(3) If the element at arr[mid] is a 2, then swap arr[mid] and arr[high] and decrease the high pointer by 1.
(4) If the element at arr[mid] is a 0, then swap arr[mid] and arr[low] and increase the low and mid pointers by 1.
(5) If the element at arr[mid] is a 1, don't swap anything and just increase the mid pointer by 1.

This algorithm stops once the mid pointer passes the high pointer.

*/class SortAnArrayAf_0s_1s_2s_UsingDutchNationalFlagAlgorithm
{
	// Linear-time partition routine to sort an array containing 0, 1 and 2
	// It similar to three-way Partitioning for Dutch national flag problem
	public static void threeWayPartition(int arr[], int end)
	{
		int start = 0, mid = 0;
		if(end <= 1 ){
			return;
		}
		while (mid <= end)
		{
			if (arr[mid] ==0)      // current element is 0
			{
				swap(arr,start, mid);
				start++;
				mid++;
			}
			else if (arr[mid] ==2)	// current element is 2
			{
				swap(arr,mid,end);
				end--;
			}
			else if(arr[mid] == 1)	// current element is 1
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
		int A[] = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 }; //pivot =1
		//int A[] ={4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4}; //pivot = 4
		int n = A.length;
		int pivot = 1;
		threeWayPartition(A, n - 1);

		for (int i = 0 ; i < n; i++)
			System.out.print(A[i] + " ");
	}
}