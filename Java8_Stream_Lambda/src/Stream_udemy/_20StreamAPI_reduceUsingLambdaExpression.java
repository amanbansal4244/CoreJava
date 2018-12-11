package Stream_udemy;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class _20StreamAPI_reduceUsingLambdaExpression {



	public static void main(String[] args) {
		List<Integer> people = Arrays.asList(1,2,3,4,5);
		
		Stream<Integer> s = people.stream();
		
		/*
		Stream<Integer> s1 = s.map(new Function<Integer , Integer>()
		{
			public Integer apply(Integer i) {
				return i*2;
			}
		});
		
		Since we can use lambda expression instead of anonymous class like below
		Stream<Integer> s1 = s.map((i) -> 
			{
				return i*2;
			}
		);
		
		
		So in lambda expression we don't need to write 'return' keyword, after removed 'return' keyword we can remove semicolon 
		and after removed semicolon we can remove brackets itself(because we dont need brackets for one line code in lambda expression.
		So we can write below single line code.
		*/
		
		Stream<Integer> s1 = s.map( (i) -> i*2 );
		
		/*
		 * We can replace below line with line "Integer s2 = (Integer) s1.reduce(0 ,(c,e) -> c + e); "
		 * to be more logical because c means 'carry' and e means 'value'
		*/
		Integer s2 = (Integer) s1.reduce(0 ,(i,j) -> i + j); 

		System.out.println("after adding doubled values");
		System.out.println("Result:" + s2);
		
		
		System.out.println("after adding doubled values");
		System.out.println(people.stream().map(i -> i*2).reduce(0,(c,e) ->c+e));
		
		System.out.println("Integer Class method sum values");
		System.out.println(people.stream().map(i -> i*2).reduce(0,(c,e) ->Integer.sum(c,e)));

		System.out.println("Another approach Integer Class method sum values");
		System.out.println(people.stream().map(i -> i*2).reduce(0,Integer :: sum));

	}


}
