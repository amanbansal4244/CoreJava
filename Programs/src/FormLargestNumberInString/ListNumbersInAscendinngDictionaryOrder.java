package FormLargestNumberInString;
/* A list contains numbers ranging from 0-9. Write a program to arrange the list in ascending dictionary order. 
For example:
[1,2,3,7] -> [1,7,3,2]
Explanation : [1,2,3,7] in words is [one, two, three, seven] arranging in ascending dictionary order is [one, seven, three, two ]
will return [1,7,3,2]
e.g. [1,2,3,7,3,1] -> [1,1,7,3,3,2]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ListNumbersInAscendinngDictionaryOrder {

	public String largestNumber(final List<Integer> A)
	{
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(0,"zero");
		hm.put(1,"one");
		hm.put(2,"two");
		hm.put(3,"three");
		hm.put(4,"four");
		hm.put(5,"five");
		hm.put(6,"six");
		hm.put(7,"seven");
		hm.put(8,"eight");
		hm.put(9,"nine");
		int length = A.size();
		String[] strArr =  new String[length]; 
		for(int i=0; i<length; i++){
			strArr[i]= hm.get(A.get(i));
		}
		
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2).compareTo(o1);
			}
		});
		
		StringBuilder sbObj = new StringBuilder();
		for(String str : strArr){
			sbObj.append(str);
		}
		return sbObj.toString();
		
	}
	public static void main(String[] args) {
		 
		List<Integer> list = Arrays.asList(1,2,3,7);
		
		ListNumbersInAscendinngDictionaryOrder obj = new ListNumbersInAscendinngDictionaryOrder();
		String str = obj.largestNumber(list);
		
		System.out.println("Result:" + str);
	}
}
