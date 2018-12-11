package Stream_udemy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/****
 * IntStream is a stream of primitive int values. It's part of the java.util.stream package.
 */
public class _5RemovingDuplicateElementsFromAList_Using_Distinct_Collector_toSet {

	

	/****
	 * Use this technique, when we need to collect the distinct result back into List only.
	 */
	public void distinct() {
		final List<Integer> numbersList = Arrays.asList(1,25,23,25, 56,11,88,1,54, 23);
		
		List<Integer> distinctNumber = numbersList.stream()
		.distinct()
		//Collectors is a final class that extends Object class. It provides reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria, etc.
		.collect(Collectors.toList()); // collecting as list  
		
		distinctNumber.forEach(p -> {
			System.out.println("Distinct no are :" + p);
		});
	}
	
	
	/****
	 * Use this technique, when we need to collect the distinct result back into Set.
	 */
	public void distinctWithSet() {
		final List<Integer> numbersList = Arrays.asList(1,25,23,25, 56,11,88,1,54, 23);
		
		Set<Integer> distinctNumber = numbersList.stream()
		//Collectors is a final class that extends Object class. It provides reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria, etc.
		.collect(Collectors.toSet()); // here we don't need .distinct() because we are converting into set and set does not allow duplicate numbers.
		
		System.out.println("distinctWithSet: " + distinctNumber);
	}
	
	public static void main(String[] args) {
		new _5RemovingDuplicateElementsFromAList_Using_Distinct_Collector_toSet().distinct();
		new _5RemovingDuplicateElementsFromAList_Using_Distinct_Collector_toSet().distinctWithSet();
	}
}
