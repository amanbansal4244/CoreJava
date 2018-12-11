/*Given a sorted array, the task is to remove the duplicate elements from the sorted array.
Examples:
Input  : arr[] = {2, 2, 2, 2, 2}
Output : arr[] = {2}
         new size = 1

Input  : arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5}
Output : arr[] = {1, 2, 3, 4, 5}
         new size = 5
         
Method 2: (Constant extra space)
Just maintain a separate index for same array as maintained for different array in Method 1.

Time Complexity : O(n)
Auxiliary Space : O(1)

*/package ArrayBased;
// simple java program to remove
// duplicates
 
class RemoveDuplicateFromSortedArray_usingConstantSpace
{
    // Function to remove duplicate elements
    // This function returns new size of modified array.
    static int removeDuplicates(int arr[], int n)
    {
        if (n==0 || n==1)
            return n;
      
        // To store index of next unique element
        int j = 0;
      
        // Doing same as done in Class 'RemoveDuplicateFromSortedArray_usingExtraSpace.java'
        // Just maintaining another updated index i.e. j
        //By doing this, duplicate elements will move to end and unique elements will come starting of an array.
        for (int i=0; i < n-1; i++){
        	if (arr[i] != arr[i+1]){
        		arr[j] = arr[i];
        		j++;
        	}
        }
       //Store the last element as whether it is unique or repeated, it hasn't processed/stored previously.
        arr[j++] = arr[n-1];
      
        return j;
    }
     
    public static void main (String[] args) 
    {
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = arr.length;
         
        n = removeDuplicates(arr, n);
  
        // Print updated array
        for (int i=0; i<n; i++)
           System.out.print(arr[i]+" ");
    }
}