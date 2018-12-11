package MaxAndMinElement_BasedProblem_InArray;
/* Problem :
 * Maximum difference between two elements such that larger element appears after the smaller number
Given an array arr[] of integers, find out the difference between any two elements such that larger element appears
 after the smaller number in arr[].

Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Difference between 10 and 2). 
If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Difference between 7 and 9)


Algorithm:
	In this method, instead of taking difference of the picked element with every other element,
    we take the difference with the minimum element found so far. So we need to keep track of 2 things:
	1) Maximum difference found so far (max_diff).
	2) Minimum number visited so far (min_element).
	
Time Complexity: O(n)
Auxiliary Space: O(1)

*/
public class MaximumDifferenceWay2_n_Complexity {
	int maxDiff(int arr[], int n)
	{
	    int maxDiff = -1; // Initialize Result
	 
	    int maxRight = arr[n-1]; // Initialize max element from right side
	 
	    for (int i = n-1; i >= 0; i--)
	    {
	        if (arr[i] > maxRight)
	            maxRight = arr[i];
	        else
	        {
	            int diff = maxRight - arr[i];
	            if (diff > maxDiff)
	            {
	                maxDiff = diff;
	            }
	        }
	    }
	    return maxDiff;
	}
	/* Driver program to test above functions */
	 public static void main(String[] args) 
	 {
		 MaximumDifferenceWay2_n_Complexity maxdif = new MaximumDifferenceWay2_n_Complexity();
	     int arr[] = {1,490, 2, 90,223, 120, 110};
	     System.out.println("Maximum differnce is " + 
	                             maxdif.maxDiff(arr, arr.length));
	 }}
