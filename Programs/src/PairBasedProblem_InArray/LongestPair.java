package PairBasedProblem_InArray;
/*
Given a list of integers, e.g.:


{ 2, 6, 7, 9, 1, 0, 1, 2, 3, 6 }
. 
Write an time efficient algorithm to find the longest subset in which the difference between the minimum and maximum numbers is 0 or 1. 
The subset can have a length of 0 and can hold any of the values in the original array (order not matters).*/

import java.util.HashMap;
import java.util.Map;


public class LongestPair {


public static void longestSubset(int[] arr) {
	Map<Integer, Integer> intCounts = new HashMap<Integer, Integer>();
	Integer[] longestPair = new Integer[] {null, null};
	Integer longestCount = 0;
	
	for (Integer i : arr) {
		intCounts.put(i, intCounts.containsKey(i) ? intCounts.get(i) + 1 : 1);
	}
	
	for (Integer i : intCounts.keySet()) {
		Integer thisCount = intCounts.get(i);
		boolean neighbourInSet = intCounts.containsKey(i - 1);
		
		if (neighbourInSet) 
			thisCount = thisCount + intCounts.get(i - 1);
		
		if (thisCount > longestCount) {
			longestCount = thisCount;
			longestPair[0] = neighbourInSet ? i - 1 : null;
			longestPair[1] = i;
		}
	}
	
	Integer[] returnArray = new Integer[longestCount];
	Integer currentReturnIndex = 0;
	
	for (Integer i : arr) {
		if (longestPair[0] == i || longestPair[1] == i) {
			returnArray[currentReturnIndex++] = i;
		}
	}
	 
	for(int m =0; m< returnArray.length;m++){
		System.out.println(returnArray[m]);
	}
	//return returnArray;
}

public static void main(String[] args) {
	int arr[]={2,6,7,9,1,0,1,2,3,6};
	longestSubset(arr);
}
}