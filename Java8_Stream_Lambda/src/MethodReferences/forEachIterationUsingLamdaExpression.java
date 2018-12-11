package MethodReferences;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class forEachIterationUsingLamdaExpression {
	
	public static void doubleValue(int i){
		System.out.println(i*2);
	}

	public  void tripleValue(int i){
		System.out.println(i*3);
	}
	
	public static void main(String[] args) {
		forEachIterationUsingLamdaExpression obj = new forEachIterationUsingLamdaExpression();
		List<Integer> people = Arrays.asList(1,2,3,4,5,6);
		
		
		/*Internal Iteration : Approach 5
		 * Instead of taking the value using lambda expression  "people.forEach(z-> System.out.println(z));"
		 * 
		 * I will say : you take the value 
		 *forEach() will say .. Ok I will take the value , tell me what to do
		 *I will say : for every value of list , you have to call method 'println'
		 *ForEach() says : I will call 'println' method and pass every value of list to 'println' but forEach() will says , hold on what is 'println' I don’t know
		 *I will say : It’s a method  which belongs object 'out' and it’s a reference 
		 *ForEach() says : what is 'out' object
		 *I will say : 'out' object is static object of 'System' class
		 *So we need to write like : System.out :: println  -> here we are not passing any argument to 'println' method but passing a method('println') as a parameter -> java 8 supports  "call by method" concept

		 * Like we have earlier concepts : "call by value" and "call by reference"

		 * using method reference 
		 * this makes very easy for processor to run in multiple thread
		 */

		System.out.println("\n using println method reference for each loop");
		people.forEach(System.out :: println);
		
		/*I don't want to use 'println' method to print , i want to mine method which will double the value.
		
		*/
		System.out.println("\nusing self defined static method method reference for each loop ");
		people.forEach(forEachIterationUsingLamdaExpression :: doubleValue);

		System.out.println("\nusing self defined non static method method reference for each loop ");
		people.forEach(obj :: tripleValue);

	}}
