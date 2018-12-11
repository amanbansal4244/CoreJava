package ForkJoinConcept;

import java.util.concurrent.RecursiveTask;
/****Class has to extends RecursiveAction or RecursiveTask<T> in order to use Fork-join framework. 
 * In this case, we used RecursiveTask<Integer> since we do want to return Integer as value.
 * and we have to override the 'compute' method of RecursiveTask<Integer>
 */
public class _2SimpleRecursiveAction extends RecursiveTask<Integer> {

	private int simulatedWork;
	
	public _2SimpleRecursiveAction(int simulatedWork) {
		this.simulatedWork = simulatedWork;
	}
	
	/****
	 * This does return value.
	 */
	@Override
	protected Integer compute() {
		/*Checking whether we need to split the tasks or not for parallel execution. */
		if( simulatedWork > 100 ) {
			
			System.out.println("Parallel execution and split the tasks..." + simulatedWork);
			
			/****Creating the instance of 'SimpleRecursiveAction' and it is the task because 'SimpleRecursiveAction' extending the RecursiveAction
			 * Dividing the tasks in two parts, means half of the work of 'simulatedWork' will be done by instance 
			 * 'simpleRecursiveAction1' and other half will be done by 'simpleRecursiveAction2'
			 * 
			 *  The _2SimpleRecursiveAction example also breaks the work down into subtasks, 
			 *  and schedules these subtasks for execution using their fork() method.
			 *  */
			_2SimpleRecursiveAction simpleRecursiveAction1 = new _2SimpleRecursiveAction(simulatedWork/2);
			_2SimpleRecursiveAction simpleRecursiveAction2 = new _2SimpleRecursiveAction(simulatedWork/2);
			
			/****
			 * Basically, we are going to create 'Fork-Join' pool and when we call 'fork' method then these recursive actions 
			 * 'simpleRecursiveAction1' and 'simpleRecursiveAction2', is going to be inserted into the given pool.So basically,
			 * threads in the given pool are able to execute these tasks.
			 * This 'fork()' is going to make sure that task are going to be executed asynchronously. 
			 * 
			 *  Basically, 'fork()' split the given task into smaller subtasks that can be executed in a parallel manner.
			 */
			simpleRecursiveAction1.fork();
			simpleRecursiveAction2.fork();

			int solution = 0;
			/****This 'join()' is going to wait for return value by simpleRecursiveAction1 
			 * The splitted tasks are being executed and after all of them are finished, they are merged into one result
			 * 
			 *   Additionally, this example then receives the result returned by each subtask by calling the join() method of each subtask. 
			 *   The subtask results are merged into a bigger result which is then returned. 
			 *   This kind of joining/merging of subtask results may occur recursively for several levels of recursion.*/
			solution = solution + simpleRecursiveAction1.join();
			/*This 'join()' is going to wait for return value by simpleRecursiveAction2  */
			solution = solution + simpleRecursiveAction2.join();
			
			return solution;
			
		} else {
			/*Checking whether we need to split the tasks or not for parallel execution. Here, we need sequential execution only. */
			System.out.println("No need for parallel execution, sequential is OK for this task..." );
			return 2 * simulatedWork;
		}
	}
}
