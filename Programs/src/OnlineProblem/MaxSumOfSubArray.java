package OnlineProblem;

//Problem-> https://www.hackerrank.com/challenges/java-1d-array-easy

import java.util.Arrays;

import java.util.*;



	
	class MaxSumOfSubArray 
	{
		public static void subarray(int [] arr){
		int position=0;
		int length=0;
		int count=0;
		int countNegativeSubarray=0;
		ArrayList al = new ArrayList();
		int sum=0;
		while(position < arr.length){
			while(length< arr.length){
				al.add(arr[length]);
				for(int i=0; i< al.size();i++){
					sum = sum + (Integer) al.get(i);
				}
				if(sum < 0){
					countNegativeSubarray++;
				}
				sum=0;
				length++;
			}
			al.removeAll(al);
			count++;
			position++;
			length=count;
		}
		
		System.out.println(countNegativeSubarray);
		}

		
		public static void main(String[] args) {
		
			int arr[] = {1,-2,4,-5,1};
			subarray(arr);
		}
	}