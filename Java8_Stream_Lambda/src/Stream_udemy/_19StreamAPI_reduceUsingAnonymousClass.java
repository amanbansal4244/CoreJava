package Stream_udemy;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class _19StreamAPI_reduceUsingAnonymousClass {


	public static void main(String[] args) {
		List<Integer> people = Arrays.asList(1,2,3,4,5);
		
		Stream<Integer> s = people.stream();
		
		/*Function<Integer , Integer> f = new Function<Integer , Integer>()
		{
			@Override
			public Integer apply(Integer i) {
				return i*2;
			}
		};
		
		*Since we are using 'Function' object once in code "Stream s1 = s.map(f);"
		*So that we can directly use implementation as Anonymous class as below
		*
		*/
		
		Stream<Integer> s1 = s.map(new Function<Integer , Integer>()
		{
			public Integer apply(Integer i) {
				return i*2;
			}
		});
		
		
		/*BinaryOperator<Integer> b = new BinaryOperator<Integer>(){
			@Override
			public Integer apply(Integer i, Integer j) {
				return i+j;
			}	
		};
		*Since we are using 'Function' object once in code "Integer s2 = (Integer) s1.reduce(0,b);"
		*So that we can directly use implementation as Anonymous class as below
		*	
		*/
	
		Integer s2 = (Integer) s1.reduce(0,new BinaryOperator<Integer>(){
			public Integer apply(Integer i, Integer j) {
				return i+j;
			}	
		});
		
		System.out.println("after adding doubled values");
		System.out.println("Result:" + s2);
	}

}
