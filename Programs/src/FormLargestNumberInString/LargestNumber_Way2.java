package FormLargestNumberInString;
/*
 * Given a list of non negative integers, arrange them such that they form the largest number.
For example:
Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
		We should not use String array to copy array list element and proceed further.
 */
import java.util.*;
public class LargestNumber_Way2 {
    
    public String largestNumber(final List<Integer> A) {
      
    	// We are taking own class object array instead of taking string type array
        SortingLogic num[] = new SortingLogic[A.size()]; 
        int i =0;
        
        for(int n : A) {
            num[i] = new SortingLogic(n);
            i++;
        }
        
        Arrays.sort(num); // We can't use Collections.sort(<T> object) because its takes collection's object but Arrays.sort takes class object.
        StringBuffer result = new StringBuffer();
        
        for(SortingLogic n : num) {
            if(n.number == 0 && result.length() != 0)
                continue;
            result.append(n.number);
        }
        return result.toString();
    }
    public static void main(String[] args) {
    	List<Integer> A = Arrays.asList(3,30,34,5,9);
        LargestNumber_Way2 l = new LargestNumber_Way2();
        String result = l.largestNumber(A);
        int flag = 0;
        for(int i = 0; i < result.length(); i++){
            if(result.charAt(i) != '0')
                flag = 1;
        }
        if(flag == 1){
            System.out.println(l.largestNumber(A));
        }
        else {
            System.out.println("0");
        }
    }
}