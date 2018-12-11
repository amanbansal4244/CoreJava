package Stream_udemy;

import java.util.Arrays;

/****
 * findAny() method allows you to find any element from a Stream. 
 * Use it when you are looking for an element without paying an attention to the encounter order:
 * 
 *  The findAny() method returns any element from a Stream while the findFirst() method returns the first element in a
 *  Stream when we run same piece of code when multiple times or by multiple threads.
 */

public class _10Stream_findAny {
	public static void main(String[] args) {
		    Integer[] numbers = {1,3,4,6,8};
		 
		    //we can't use numbers.stream() because numbers is an array, not a collection.
		    /*int num = numbers.stream()
		    .filter(n -> n<6)
		    .findAny()
		    .get();*/
		    
		    
		    int num = Arrays.stream(numbers)
				    .filter(n -> n<6)
				    .findAny() // it will find any number from the result given by filter
				    .get();
		    
		    System.out.println(num);
		 
	}
}
