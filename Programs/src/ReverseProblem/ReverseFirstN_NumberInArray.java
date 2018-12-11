package ReverseProblem;
/*
For input N=4 and input array =[1,2,3,4,5,6]
reverseFunction(int [] inputArray, int N) -> O/p : [4,3,2,1,5,6]

You can see that first four numbers have been reversed.
*/
public class ReverseFirstN_NumberInArray {

	static public int[] reverseFunction(int [] inputArray, int N){
		
		int length = inputArray.length;
		if(length ==0 || N > length){ // checking corner cases
			return inputArray;
		}
		
		int left = 0;
		int right = N-1;
		while(left <= right){
			swap(inputArray, left, right);
			left++;
			right--;
		}
		return inputArray;
	}
	
	private static void swap(int[] inputArray, int left, int right) {
		int temp = inputArray[left];
		inputArray[left] = inputArray[right];
		inputArray[right] = temp;
	}

	public static void main(String[] args) {

		int inputArray[] = {1,2,3,4,5,6};
		int res[] = reverseFunction(inputArray, 4);
		for(int i=0; i< res.length;i++){
			System.out.println("Reverse Array :" + res[i]);
		}
		
	}
}
