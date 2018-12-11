package FormLargestNumberInString;
/*
 * Given a list of non negative integers, arrange them such that they form the largest number.
For example:
Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an integer.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_Way1 {

	public String largestNumber(final List<Integer> A)
	{
		int length = A.size();
		//Converting integer list into array of string.
		String[] strArr =  new String[length]; 
		for(int i=0; i<length; i++){
			strArr[i]= String.valueOf(A.get(i)); //String.valueOf->Returns the string representation of the Object argument.
		}
		
		
		Arrays.sort(strArr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
		
		StringBuilder sbObj = new StringBuilder();
		for(String str : strArr){
			sbObj.append(str);
		}
		return sbObj.toString();
		
	}
	
	public static void main(String[] args) {
		 
		List<Integer> list = Arrays.asList(3,30,34,5,9);
		
		Main_Way1 obj = new Main_Way1();
		String str = obj.largestNumber(list);
		
		System.out.println("Result:" + str);
		
		
	}
}
