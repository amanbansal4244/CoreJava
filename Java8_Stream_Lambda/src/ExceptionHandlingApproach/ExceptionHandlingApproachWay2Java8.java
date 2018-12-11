package ExceptionHandlingApproach;

import java.util.function.BiConsumer;

public class ExceptionHandlingApproachWay2Java8 {
	public static void main(String[] args) {
		int [] somenumbers = { 1,2,3,4,5};
		int key =0;
		/*To have only one line simple lambda expression . we will use wrapper lambda expression which will wrap original lambda.
		Flow:
			1. Below line will get called where we are creating 'lambda expression' and 
			passing 'lambda expression' to 'wrapperLamdaFunction' to replace the 'lambda expression'  means
			this 'lambda expression((v,k) -> System.out.println(v/k))' is replaced by  below 'lambda expression':
			return (v,k) -> {
			try{
				biConsumer.accept(v, k);
			}catch(Exception e){
				System.out.println("Exception Occured");
			}
		};
		
		Note : we can write any other lambda expression  like below in 'wrapperLamdaFunction':
			   return (v,k) -> System.out.println(v+k);
				means this program will be doing addition (because of wrap up lambda), instead of division( from original lambda expression)
		*/
		process(somenumbers,key,wrapperLamdaFunction((v,k) -> System.out.println(v/k)));
		
	}

	// For lambda expression , We need an interface.. which method takes 2 arguments and return one object.
	//So I used 'BiConsumer' interface. BiConsumer<T,U>	-> Represents an operation that accepts two input arguments and returns no result.
	private static void process(int[] somenumbers, int key, BiConsumer<Integer, Integer> biConsumer) {
		for(int i : somenumbers){
				biConsumer.accept(i, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> wrapperLamdaFunction(BiConsumer<Integer, Integer> biConsumer){
		return (v,k) -> {
			try{
				biConsumer.accept(v, k);
			}catch(Exception e){
				System.out.println("Exception Occurred");
			}
		};
		
		//return (v,k) -> System.out.println(v+k);
	}
}
