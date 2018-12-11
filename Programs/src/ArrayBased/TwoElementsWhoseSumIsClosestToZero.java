/*Two elements whose sum is closest to zero.

Question: An Array of integers is given, both +ve and -ve. 
You need to find the two elements such that their sum is closest to zero.

int arr[] = {-3, -1, 0,1, 60, -10, 70, -80, 85};
For the above array, program should print -1 and 0.

Algorithm : Enter any integer number as an input which denotes the size of the array.
 After that add all the required integers in the array. Now we pick all two possible pairs and
 compare their sum with the minimum possible sum closest to zero. Since sum can be negative so we use absolute function to get only positive result.
 Hence the two integers with sum closest to zero are output.
 
 Time complexity: O(n)
*/
package ArrayBased;

import java.util.Arrays;

class TwoElementsWhoseSumIsClosestToZero
{
	static void minAbsSumPair(int arr[], int arr_size)
	{
		int min_sum, sum, min_l, min_r;
		
		/* Array should have at least two elements*/
		if(arr_size < 2)
		{
			System.out.println("Invalid Input");
			return;
		}
		
		Arrays.sort(arr); /*The sorting algorithm is a Dual-Pivot Quicksort
							  *This algorithm offers O(n log(n)) performance on many data sets that cause other
							  * quicksorts to degrade to quadratic performance, and is typically
							  * faster than traditional (one-pivot) Quicksort implementations*/
		
		/* Initialization of values */
		min_l = 0;
		min_r = 1;
		min_sum = arr[0] + arr[1];
		int j =2; //because we have already calculated first two no sum in just above line.
		for(int i = 1; i < arr_size - 1; i++)
		{
			sum = arr[i] + arr[j];
			if( Math.abs(sum) < Math.abs(min_sum))
			{
				min_sum = sum;
				min_l = i;
				min_r = j;
			}else{// We will break once sum comes greater than min_sum because it is sorted array and we will not have smaller sum after this point. 
				System.out.println("Break The Loop");
				break;
			}
			j++;
		}
		System.out.println("The two elements whose "+
				"sum is minimum are "+
				arr[min_l]+ " and "+arr[min_r]);
	}

	// main function
	public static void main (String[] args) 
	{
		int arr[] = {-3, -1, 0,1, 60, -10, 70, -80, 85};
		minAbsSumPair(arr, arr.length);
	}

}