package Array_Rearrange_Problem;
/*Segregate Even and Odd numbers
Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers first, 
and then odd numbers.
Example
Input = {12, 34, 45, 9, 8, 90, 3}
Output = {12, 34, 8, 90, 45, 9, 3}
In the output, order of numbers can be changed, i.e., in the above example 34 can come before 12 and 3 can come before 9.

Note: we should not use extra space (means can't take another array) and sort elements.

Algorithm: segregateEvenOdd()
1) Initialize two index variables left and right:  
            left = 0,  right = size -1 
2) Keep incrementing left index until we see an odd number.
3) Keep decrementing right index until we see an even number.
4) If left < right then swap arr[left] and arr[right]

Time Complexity: O(n)

*/

class SegregateEvenAndOddNumbers_withConstantSpace{
  
    static void segregateEvenOdd(int []a){
        if(a == null || a.length == 0)
            return;
        
        int left = 0, right = a.length - 1;
        while(left < right){
            while(a[left]%2 == 0)
                left++;
            
            while(a[right]%2 != 0)
                right--;
            
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
        int []a = {12, 33, 45, 9, 8, 90,44, 3};
        segregateEvenOdd(a);
        System.out.println("\nafter the shuffling :" + java.util.Arrays.toString(a));
    }
}