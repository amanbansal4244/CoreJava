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
Auxiliary Space : O(n1 + n2) because taking extra space.
The idea is to use Merge function of Merge sort.

Algorithm:
	Create an array arr3[] of size n1 + n2.
	Simultaneously traverse arr1[] and arr2[].
	Pick smaller of current elements in arr1[] and arr2[], copy this smaller element to next position in arr3[] and move ahead in arr3[] and the array whose element is picked.
	If there are are remaining elements in arr1[] or arr2[], copy them also in arr3[].
*/
 
class MergeTwoSortedArrays_UsingExtraSpace
{
    public static void mergeArrays(int[] arr1, int[] arr2, int n1,
                                int n2, int[] arr3)
    {
        int i = 0, j = 0, k = 0;
     
        // Traverse both array
        while (i<n1 && j <n2)
        {
            // Check if current element of first array is smaller than current element of second array. 
        	//If yes, store first array element and increment first array index. Otherwise do same with second array
            if (arr1[i] < arr2[j]){
                arr3[k] = arr1[i];
                i++;
                k++;
            }
            else{
                arr3[k] = arr2[j];
                j++;
                k++;
                
            }
        }
     
        // Store remaining elements of first array
        while (i < n1){
            arr3[k] = arr1[i];
            i++;
            k++;
        }
        // Store remaining elements of second array
        while (j < n2){
            arr3[k] = arr2[j];
            j++;
            k++;
        }
    }
     
    public static void main (String[] args) 
    {
        int[] arr1 = {1, 3, 5, 7};
        int n1 = arr1.length;
     
        int[] arr2 = {2, 4, 6, 8};
        int n2 = arr2.length;
     
        /****In merge sort, we have to create a temporary array: size is equal to the size of input.
         * thats why merge sort has O(N) memory complexity.*/
        int[] arr3 = new int[n1+n2]; // creating extra space
        
        mergeArrays(arr1, arr2, n1, n2, arr3);
     
        System.out.println("Array after merging");
        for (int i=0; i < n1+n2; i++)
            System.out.print(arr3[i] + " ");
    }
}