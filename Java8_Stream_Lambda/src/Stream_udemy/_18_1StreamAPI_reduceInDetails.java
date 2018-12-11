package Stream_udemy;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class _18_1StreamAPI_reduceInDetails {


	public static void main(String[] args) {
		List<Integer> people = Arrays.asList(1,2,3,4,5);
		
		Stream s = people.stream();
		
		Function<Integer , Integer> f = new Function<Integer , Integer>()
		{
			@Override
			public Integer apply(Integer i) {
				return i*2;
			}
		};
		
		Stream s1 = s.map(f);
		
		/*reduce : 'reduce' takes two value . One is initially value i.e. 0 and another is object of 'BinaryOperator'
		 * 'BinaryOperator' is 'functional interface' which has all defined method but 'BinaryOperator' extends the 'BiFunction'
		 * and 'BiFunction' interface has apply method which we need to implement.
		
		*/
		
		BinaryOperator<Integer> b = new BinaryOperator<Integer>(){
			@Override
			public Integer apply(Integer i, Integer j) {
				return i+j;
			}	
		};
		
		/*now 'reduce' method initially add 0+2 = 2 then 2+4=6 then 6+6=12 then 12+8=20 then 20+10 =30
		*/
		Integer s2 = (Integer) s1.reduce(0,b);
		System.out.println("after adding doubled values");
		System.out.println("Result:" + s2);
	}

}
