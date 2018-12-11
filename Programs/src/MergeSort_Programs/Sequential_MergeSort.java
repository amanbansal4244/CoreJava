package MergeSort_Programs;

/* Java program for Merge Sort 
 * In merge sort, we have to create a temporary array: size is equal to the size of input.
 * thats why merge sort has O(N) memory complexity.
 * */
class Sequential_MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
                k++;
            }
            else
            {
                arr[k] = R[j];
                j++;
                k++;
            }
            
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    /****Main function that sorts arr[l..r] using merge()
     * Base case for recursive method calls , in the situation the sort is over. 
     * @param arr
     * @param left
     * @param right
     */
    void mergeSort(int arr[], int left, int right)
    {
        if (left < right)
        {
            // Find the middle point
            int middle = (left+right)/2;
 
            // Sort first and second halves
            mergeSort(arr, left, middle); // call the mergesort method recursively on the left sub-array.
            mergeSort(arr , middle+1, right); // call the mergesort method recursively on the right sub-array.
 
            // Merge the sorted halves : The conquer part of the algorithm, we keep merging the sub-arrays together.
            merge(arr, left, middle, right);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
 
        System.out.println("Given Array");
        printArray(arr);
 
        Sequential_MergeSort ob = new Sequential_MergeSort();
        ob.mergeSort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);
    }
}