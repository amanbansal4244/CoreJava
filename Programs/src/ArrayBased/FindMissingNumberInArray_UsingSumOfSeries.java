package ArrayBased;
/*Find the Missing Number
You are given a list of n-1 integers and these integers are in the range of 1 to n. 
There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.

*METHOD 1(Use sum formula)
Algorithm:

1. Get the sum of numbers:
       total = (n+1)*(n+2)/2
2  Subtract all the numbers from sum one by one and you will get the missing number.
   
Time Complexity: O(n)
*/
public class FindMissingNumberInArray_UsingSumOfSeries {

	// Function to find missing number
    static int getMissingNo (int a[], int n)
    {
    	int i, total;
    	total  = (n+1)*(n+2)/2;   
    	for ( i = 0; i< n; i++){
    		total = total- a[i];
    	}
    	return total;
    }
      
    /* program to test above function */
    public static void main(String args[])
    {
        int a[] = {1,2,4,5,6};
        int miss = getMissingNo(a,5);
        System.out.println(miss);   
    }
}
