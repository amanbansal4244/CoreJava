package ReverseProblem;
public class ReverseString_WithConstantSpace {
    public static void main(String...args){ 
           String originalString="abcde"; //String to be reversed
           
           System.out.println("Original String: "+originalString);
           System.out.println("Reversed String: "+reverseString(originalString));         
    }
    
    static void swap(char[] ar, int i, int j){ 
        char t = ar[i];
        ar[i] = ar[j]; 
        ar[j] =  t; 
    }
    
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
           
           return new String(ar);
    }
}