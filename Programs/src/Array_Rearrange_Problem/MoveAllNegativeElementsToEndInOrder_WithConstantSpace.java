package Array_Rearrange_Problem;
/*An array contains both positive and negative numbers in random order. Rearrange the array elements so that positive 
 * and negative numbers are placed alternatively. Number of positive and negative numbers need not be equal.
 * If there are more positive numbers they appear at the start of the array.
 * If there are more negative numbers, they too appear in the end of the array.

For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]

Note: we should not extra space (means can't take another array) and sort elements 

Algorithm: segregatPostiveNegative()
1) Initialize two index variables left and right:  
            left = 0,  right = size -1 
2) Keep incrementing left index until we see an negative number.
3) Keep decrementing right index until we see an postive number.
4) If lef < right then swap arr[left] and arr[right]

Time Complexity: O(n)
*/
public class MoveAllNegativeElementsToEndInOrder_WithConstantSpace {
	  
    static void segregatPostiveNegative(int []a){
        if(a == null || a.length == 0)
            return;
        
        int left = 0, right = a.length - 1;
        while(left < right){
            while(a[left] > 0){
                left++;
            }
            
            while(a[right] < 0){
                right--;
            }
            
            if(left < right){
                swap(a, left, right);
                left++;
                right--;
            }
        }
    }
   
     //Utility function to swap array elements
    static void swap(int []a, int i, int j){ 
        int t = a[i];
        a[i] = a[j]; 
        a[j] = t; 
    }
  
    public static void main(String []ar){
        int []a = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        segregatPostiveNegative(a);
        System.out.println("\nafter the shuffling :" + java.util.Arrays.toString(a));
    }

}
