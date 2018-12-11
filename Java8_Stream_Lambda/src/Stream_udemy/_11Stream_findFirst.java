package Stream_udemy;

import java.util.Arrays;

/****
 * The findFirst() method finds the first element in a Stream. Obviously,
 *  this method is used when you specifically want the first element from a sequence.
 *  When there is no encounter order it returns any element from the Stream. The java.util.streams package documentation says:
 *  			Streams may or may not have a defined encounter order. It depends on the source and the intermediate operations.
 *  
 *  The findAny() method returns any element from a Stream while the findFirst() method returns the first element in a
 *  Stream when we run same piece of code when multiple times or by multiple threads.
 */

public class _11Stream_findFirst {
	public static void main(String[] args) {
		    Integer[] numbers = {1,3,4,6,8, 9, 12, 23, 15};
		 
		    //we can't use numbers.stream() because numbers is an array, not a collection.
		    /*int num = numbers.stream()
		    .filter(n -> n<6)
		    .findFirst()
		    .get();*/
		    
		    
		    int num = Arrays.stream(numbers)
				    .filter(n -> n > 6 && n<20)
				    .findFirst() // it will find very first number from the result given by filter
				    .get();
		    
		    System.out.println(num);
		 
	}
}
