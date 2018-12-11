package MaxAndMinElement_BasedProblem_InArray;
/*
Problem : find second largest element from array, if you don't have then simply returns -1.
You are not allowed to use any sorting functions. 
You should iterate the array only once. You are not allowed to use any kind of collections in java. 
*/
public class SecondLargestElementFromArray {

	public int secondLargest(int size, int arr[]){
		if(size ==0 || size==1){//when size of array is 1, so we don't have Second Element in Array
			return -1;
		}
		int maxOne = 0;
		int maxTwo = 0;
		for(int i : arr){
			if(i != maxOne) { // when i and maxOne are equal then we don't want to go inside.
				if(i > maxOne){
					maxTwo = maxOne;
					maxOne = i;
				}
				else{
					if(i>maxTwo){
						maxTwo = i;
					}
				}
			}
		}
		if(maxTwo == 0){ // means all elements are same in array , so we don't have Second Largest Element From Array
			maxTwo = -1;
		}
		return maxTwo;
	}
	public static void main(String[] args) {
		SecondLargestElementFromArray obj = new SecondLargestElementFromArray();
		int arr[] = {3,2,1,8,6,5};
		int res = obj.secondLargest(arr.length, arr);
		System.out.println("Second Largest Element From Array :" + res);
	}
}
