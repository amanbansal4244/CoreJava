package ForkJoinConcept;

import java.util.concurrent.ForkJoinPool;

public class _1App {

	public static void main(String[] args) {
		
		/****Creating the 'ForkJoinPool' which is equal to the number of processors in CPU.
		 * Basically, 'ForkJoinPool' is going to contain as many threads as the number of available processor in CPU 
		 * Because we don't want to create more threads than the number of available processor because then it is 
		 * not going to be parallel means it is going to be multi-threaded execution but not parallel.  */
		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		
		/*Assigning the work as 400. */
		_1SimpleRecursiveAction simpleRecursiveAction = new _1SimpleRecursiveAction(400);
		/*'invoke()' is going to execute the given task + returns its result upon completion. */
		forkJoinPool.invoke(simpleRecursiveAction);
		
		
	}
}
