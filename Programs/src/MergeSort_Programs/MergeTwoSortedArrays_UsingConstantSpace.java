package MergeSort_Programs;

/*

Given two sorted arrays, the task is to merge them in a sorted manner.

Examples:

Input :  arr1[] = { 1, 3, 4, 5}  
         arr2[] = {2, 4, 6, 8}
Output : arr3[] = {1, 2, 3, 4, 5, 6, 7, 8}

Input  : arr1[] = { 5, 8, 9}  
         arr2[] = {4, 7, 8}
Output : arr3[] = {4, 5, 7, 8, 8, 9}



Time Complexity : O(n1 + n2)
Auxiliary Space : O(n1) because we are not taking extra space.
The idea is to use Merge function of Merge sort.

Algorithm:
	Initially Create an array arr1[] of size n1 + n2.
	Simultaneously traverse arr1[] and arr2[].
	we start comparing last elements from the both sorted array.
	Check if current element of first array is smaller than current element of second array. 
	If yes, store first array element and increment first array index. Otherwise do same with second array.
	Store remaining elements of first array.
	Store remaining elements of second array.
*/
class MergeTwoSortedArrays_UsingConstantSpace
{
	public static void mergeArrays(int[] arr1, int[] arr2, int n1,
			int n2, int noOfElementsInFirstArray)
	{
		int i = noOfElementsInFirstArray-1;
		int j = n2-1;
		int k = n1-1;//totalSizeOfFirstArray
		// Traverse both array
		while (i >=0 && j >=0) // we start comparing last elements from the both sorted array.
		{
			// Check if current element of first array is smaller than current element of second array. 
			//If yes, store first array element and increment first array index. Otherwise do same with second array
			if (arr1[i] < arr2[j]){
				arr1[k] = arr2[j];
				j--;
				k--;
			}
			else{
				arr1[k] = arr1[i];
				i--;
				k--;
			}
		}
		// Store remaining elements of first array.
		while (i >0){
			arr1[k] = arr1[i];
			i--;
			k--;
		}
		// Store remaining elements of second array.
		while (j >0){
			arr1[k] = arr2[j];
			j--;
			k--;
		}
	}

	public static void main (String[] args) 
	{
		int[]arr1 = new int[9];
		arr1[0]=1;
		arr1[1]=3;
		arr1[2]=5;
		arr1[3]=7;
		arr1[4]=9;

		int n1 = arr1.length;
		int noOfElementsInFirstArray=0;
		for(int i=0; i< n1; i++){
			if(arr1[i]==0){
				break;
			}
			noOfElementsInFirstArray++;
		}
		int[] arr2 = {2, 4, 6, 8};
		int n2 = arr2.length;


		mergeArrays(arr1, arr2, n1, n2,noOfElementsInFirstArray);

		System.out.println("Array after merging");
		for (int i=0; i < n1; i++)
			System.out.print(arr1[i] + " ");
	}
}