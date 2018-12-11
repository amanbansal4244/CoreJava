package Stream_udemy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _18SpreamAPI_reduceMethod {

	/*reduce : 'reduce' takes two value . One is initially value i.e. 0 and another is object of 'BinaryOperator'
	 * 'BinaryOperator' is 'functional interface' which has all defined method but 'BinaryOperator' extends the 'BiFunction'
	 * and 'BiFunction' interface has apply method which we need to implement.
	
	*/
	public static void main(String[] args) {
		List<Integer> people = Arrays.asList(1,2,3,4,5);
		Integer s1 = people.stream()
				.map(i -> i*2)
				.reduce(0,(c,e) ->c+e);// This line will sum up all values which is multiply by 2
		
		System.out.println("after doubled values");
		System.out.println(s1);
	}
}
