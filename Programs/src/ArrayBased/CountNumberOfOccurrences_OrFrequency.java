package ArrayBased;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
/*
	We need to find out the no of occurrences of a in a unsorted array without using collection.
	We have to use simple algorithm.
	
Approach :
	1. We should sort using  Arrays.sort() -> Complexity would be O(n log(n))
	2. We will iterate array once and count the occurrences of number 
	3. We need to store into one data structure as key as number , value as total no of occurrences into one pair
	4. To store pair, we will create one generic class<K,V> which will take key, value.
 */public class CountNumberOfOccurrences_OrFrequency {

	 static void method(int [] arr){
		 Pair<Integer, Integer> pair = null; //Pair is user defined custom class to store key-value as a pair.
		 
		 Arrays.sort(arr); /*The sorting algorithm is a Dual-Pivot Quicksort
							  *This algorithm offers O(n log(n)) performance on many data sets that cause other
							  * quicksorts to degrade to quadratic performance, and is typically
							  * faster than traditional (one-pivot) Quicksort implementations*/
		 
		 int count =1;
		 for(int i=0; i<arr.length-1; i++){
			 if(arr[i] == arr[i+1]){
				 count++;
			 }else{
				 pair = new Pair<Integer, Integer>(arr[i], count); //Pair is user defined custom class to store key-value as a pair.
				 System.out.println("Key As No:"+ pair.getKey() + " and "+ "Value As Occurences:"+ pair.getValue());
				 count =1;
			 }
		 }
	 }

	 public static void main(String[] args) {
		 int [] arr ={1,2,3,1,1,3,3,5,5,2,6,7,8,4,5,3,6,8,9,7,9,4,3,5,6,7};
		 method(arr);
	 }
}
