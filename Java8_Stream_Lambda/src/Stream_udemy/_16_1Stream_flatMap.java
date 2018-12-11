package Stream_udemy;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap; import java.util.List; import java.util.Map; import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream; 
/****
 * In Java 8, Stream can hold different data types, for examples:

Stream<String[]>	
Stream<Set<String>>	
Stream<List<String>>	
Stream<List<Object>>

But, the Stream operations (filter, sum, distinct…) and collectors does not support it, so, we need flatMap() to do the following conversion :

Stream<String[]>		-> flatMap ->	Stream<String>
Stream<Set<String>>	-> flatMap ->	Stream<String>
Stream<List<String>>	-> flatMap ->	Stream<String>
Stream<List<Object>>	-> flatMap ->	Stream<Object>

How flatMap() works :
{ {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}

{ {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
 */
public class _16_1Stream_flatMap {
	//In below example, we should use flatMap() to convert Stream<String[]> to Stream<String>.
	public static void main(String args[]) throws IOException { 
		 String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

	        //Stream<String[]>
	        Stream<String[]> temp = Arrays.stream(data);

	        //Stream<String>, GOOD!
	        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));

	        Stream<String> stream = stringStream.filter(x -> "a".equals(x.toString()));

	        stream.forEach(System.out::println);

			/*Stream<String> stream = Arrays.stream(data)
	                .flatMap(x -> Arrays.stream(x))
	                .filter(x -> "a".equals(x.toString()));*/

	    }
}
