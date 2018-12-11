package ArrayBased;
/****
 * Given an infinite stream of integers, find the k’th largest element at any point of time.

Here we have a stream instead of whole array and we are allowed to store only k elements.

A Simple Solution is to keep an array of size k. The idea is to keep the array sorted so that the k’th largest element 
can be found in O(1) time (we just need to return first element of array if array is sorted in increasing order)

Question: How to process a new element of stream?
Answer: For every new element in stream, check if the new element is smaller than current k’th largest element. 
		If yes, then ignore it. If no, then remove the smallest element from array and insert new element in sorted order.

 		Time complexity of processing a new element is O(k).
 */
public class FindOneLargestElementInAStream {

	
	public static void main(String[] args) {
		//Suppose stream is keep coming, right now i am taking fixed no of array.
		int arr[] = {-3, -1, 0,1, 60, -10, 70, -80, 85,33};
		
		int[] resultArray = new int[1];
		boolean flag= true;
		for(int i =0; i< arr.length;i++){
			if(flag){
				resultArray[0] = arr[i];
				flag = false;
			}
			if(arr[i] > resultArray[0]){
				resultArray[0] = arr[i];
			}
		}
		
		System.out.println("k’th largest element at any point of time:" + resultArray[0]);
		
	}
}
