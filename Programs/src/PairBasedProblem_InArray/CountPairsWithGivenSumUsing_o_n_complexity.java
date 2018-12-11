package PairBasedProblem_InArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
count the first pair or count the total no pairs when sum of two no is 8 in array:

Approach :
	1. If array is not sorted then we will do using merge sort .. complexity would be  O(nlogn)
	2. We would take two pointer , one at starting index and one from end index
	3. Compare the i and j element, if not equals decrease the j pointer till sum is not less than required no
	4. If sum is less than required sum then just increase the i pointer only
	5. By doing this approach, complexity to get no is : O(N)
	6. Total complexity would be : O(nlogn) + O(N)
	
	If we had sorted array than complexity would have been O(N) only.
	
 */public class CountPairsWithGivenSumUsing_o_n_complexity {
	 static int getPairsCount(int[] arr, int sum)
	 {
		 int noOfPairs = 0;
		 int length = arr.length;
		 int j= length-1; // pointer at end 
		 int i =0; // pointer at starting
		 
		 Arrays.sort(arr); // O(nlogn) complexity.
		 
		 while(i < j){
			 int tempSum = arr[i] + arr[j];
			 if(tempSum >= sum){
				 if(tempSum != sum){
					 j--;
				 }else{
					 noOfPairs++;
					 j--;
				 }
			 }
			 else if(tempSum < sum){
				 i++; // we just need to increase the i pointer and don't need to put j pointer back to last because 
				 	// its impossible to get required sum beyond of current j location since this is sorted array. 
				    //because if add i and beyond no of current j index, will always have larger no than required sum no.
			 }
		 }
		 return noOfPairs;
	 }
	 public static void main(String[] args) {

		 int arr[] = {1,2,3,4,6,5,3,8,9,7,5};
		 int sum = 8;
		 System.out.println("No of pair of sum 8 is :" +getPairsCount(arr,sum));

	 }
}
