package StreamsJava8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamsFilterInDetails {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3,50,40,35,67,90);
		
		/*filter method of stream takes 'Predicate' as an argument.
		 * Predicate -> is an functional interface which was introduced in java 8
		 * Predicate has only one method 'test' which returns boolean value
		 * if it returns false that mean filter removes the value from the stream and 
		 * if it returns true, filter keeps the value in stream.
		*/
		
		Predicate<Integer> p = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer j) {
				
				return j%5 == 0;
			}
		};
		
		Integer s = list.stream().
								filter(p). 
								reduce(0,(c,e) -> c+e);
		System.out.println("Number divided by 5 only using stream filter in details:" + s);
	}
}
