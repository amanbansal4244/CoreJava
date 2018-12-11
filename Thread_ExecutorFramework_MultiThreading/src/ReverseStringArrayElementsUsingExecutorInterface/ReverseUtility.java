package ReverseStringArrayElementsUsingExecutorInterface;

public class ReverseUtility {

	/*
     * return reversed String.
     */
    public static String reverseString(String originalString){
           char ar[]=originalString.toCharArray();
           int begin=0;
           int end=ar.length-1;
           while(begin < end){
   			swap(ar, begin, end);
   			begin++;
   			end--;
           }
           
           System.out.println("Reverse String is : " + new String(ar));
           return new String(ar);
    }
    
    static void swap(char[] ar, int i, int j){ 
        char t = ar[i];
        ar[i] = ar[j]; 
        ar[j] =  t; 
    }
}
