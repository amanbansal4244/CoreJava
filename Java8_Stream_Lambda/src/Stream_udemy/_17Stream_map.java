package Stream_udemy;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class _17Stream_map {

	public static void main(String[] args) {
		List<Integer> people = Arrays.asList(1,2,3,4,5);
		
		//System.out.println(people.stream().map(i -> i*2).reduce(0,(c,e) ->c+e));
		
		//First step: convert collection into stream
		Stream s = people.stream();
		
		/*second step: To multiple each of stream by 2 : use 'Map' which returns : it takes the value and return the value what you need.
		 * As per java doc : "Returns a stream consisting of the results of applying the given function to the elements of this stream."
		 * 
		 * 'map' takes function as an argument. so we need to create a function.
		 * 
		 * Function : 
		 * 
		 * Type Parameters:
			T - the type of the input to the function
			R - the type of the result of the function

		 * @FunctionalInterface
			public interface Function<T,R>
			Represents a function that accepts one argument and produces a result.
			This is a functional interface whose functional method is apply(Object).
					
		*/
		
		Function<Integer , Integer> f = new Function<Integer , Integer>()
		{
			@Override
			public Integer apply(Integer i) {
				return i*2;
			}
		};
		
		//This s1 will have all the values which is multiply by 2 
		Stream s1 = s.map(f);  // Because map returns Stream object
							// map will take each values and returns all value one by one to stream after multiply by 2.
		
		System.out.println("after doubled values");
		s1.forEach(System.out :: println);
		
		/*reduce : 'reduce' takes two value . One is initially value i.e. 0 and another is object of 'BinaryOperator'
		 * 'BinaryOperator' is 'functional interface' which has all defined method but 'BinaryOperator' extends the 'BiFunction'
		 * and 'BiFunction' interface has apply method which we need to implement.
		
		*/
		/*
		BinaryOperator<Integer> b = new BinaryOperator<Integer>(){
			@Override
			public Integer apply(Integer i, Integer j) {
				return i+j;
			}	
		};
				
		Integer s2 = (Integer) s1.reduce(0,b);
		System.out.println("after adding doubled values");
		s1.forEach(System.out :: println);*/
	}
}
