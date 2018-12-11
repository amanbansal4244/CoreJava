/*Problem:
 * Count all distinct pairs with difference equal to k
	Given an integer array and a positive integer k, count all distinct pairs with difference equal to k.
	
	Examples:
	
	Input: arr[] = {1, 5, 3, 4, 2}, k = 3
	Output: 2
	There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2} 
	
	Input: arr[] = {8, 12, 16, 4, 0, 20}, k = 4
	Output: 5
	There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8}, 
	{8, 12}, {12, 16} and {16, 20} 
	
Algorithm:
	Sort the array arr
	Take two pointers, iand j, both pointing to 1st element
	Take the difference arr[j] � arr[i]
	If value difference is K, increment count and move both pointers to next element
	if value difference > k, move l to next element
	if value difference < k, move r to next element
	return count

Time Complexity: O(nlogn)

*/package PairBasedProblem_InArray;
import java.util.Arrays;
/*
Find out the pairs which difference is given number?
*/class PairDifference
{
	static int findPair(int a[],int kDiff)
	{
		int count = 0;
		Arrays.sort(a);  // Sort array elements The sorting algorithm is a Dual-Pivot Quicksort
		      			//This algorithm offers O(n log(n)) performance. 
		int i = 0; // considered i as first pointer
		int j = 0;// considered j as second pointer
		while(j < a.length)
		{
			if(a[j] - a[i] == kDiff)
			{
				count++;
				i++;
				j++;
			}
			else if(a[j] - a[i] > kDiff) // no need to move first pointer i.e 'i' until and unless difference of two element is greater than kDiff.
				i++;
			else 
				j++;
		}   

		return count;
	}

	public static void main (String[] args)
	{
		int arr[] = {8, 12, 16, 4, 0, 20};  
		int kDiff = 4;
		int res =findPair(arr,kDiff); // pair would be {8,12}, {12,16}, {4,0},{16,20},{8,4} with difference 4
		System.out.println("No of pair of the given difference is : "+ res);
	}
}