package forEachIterationUsingLamda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import LambdaBasicExcercisePackage.Person;

public class forEachIterationUsingLamdaExpression {

	public static void main(String[] args) {
		List<Integer> people = Arrays.asList(1,2,3,4,5,6);
		List<Integer> values = Arrays.asList(12,22,33,44,55,66);
		
		
		
		/*Internal Iteration : Approach 1
		 * 
		 *  Here we are not creating lambda expression , We know that forEach method takes arguments as Consumer functional Interface and 
		 *  Consumer functional interface takes one argument which is generic type and also consumer interface has one abstract method  which also takes 
		 *  one generic type argument which returns nothing.
		 *  So we create an anonymous class to define an consumer interface and implemented abstract method and print.
		 *  
		*/
		System.out.println("\n using lambda expression forEach Stream API with defined anonymous class ");
		Consumer<Integer> cObj = new Consumer<Integer>() {

			@Override
			public void accept(Integer i) {
				System.out.println(i);	
			}
		};
		
		/*Here , we just passed the object of Consumer class , it will go to accept method of 
		 * Consumer interface and print all the values.
		*/
		values.forEach(cObj);
		
		/*Internal Iteration : Approach 2
		 * 
		 * below forEach method came in java 8 and it takes one argument which is 'Consumer' thats is 
		 * instance of 'Consumer' and 'Consumer' is a functional interface that comes out of box in java 8. So we can use lambda expression here
		 * Lambda expression : p -> System.out.println(p) and this is consumer 
		 * and this method needs an object which is going to be consumed.
		*/
		System.out.println("\n using lambda expression forEach Stream API");
		Consumer<Integer> c = (Integer m) -> System.out.println(m);
		people.forEach(c);
		
		
		
		/*Internal Iteration : Approach 3
		 * 
		 * Since we know consumer type is integer form below "Consumer<Integer> c1" so why
		 * we need to mention 'integer' in (Integer m) -> System.out.println(m) ..
		 * We can remove integer and u know when you have only one argument we can remove brackets also. 
		*/
		System.out.println("\n Approach 3 using lambda expression  forEach Stream API");
		Consumer<Integer> c1 =  n-> System.out.println(n);
		people.forEach(c1);
		
		
		/*Internal Iteration : Approach 4
		 * 
		 * Since we are using an object of consumer C1 in approach 3, so we can remove the declaration part of consumer and 
		 * directly put the "z-> System.out.println(z)" in forEach() method for more short cut.
		*/
		System.out.println("\n Approach 4 using lambda expression  forEach Stream API");
		people.forEach(z-> System.out.println(z));
		
		/*Internal Iteration : Approach 5
		 * 
		 * using method reference 
		 * this makes very easy for processor to run in multiple thread
		*/
		System.out.println("\n using method reference for each loop");
		people.forEach(System.out :: println);
	}
}
