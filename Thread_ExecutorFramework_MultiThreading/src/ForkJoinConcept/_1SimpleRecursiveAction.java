package ForkJoinConcept;

import java.util.concurrent.RecursiveAction;

/****Class has to extends RecursiveAction or RecursiveTask<T> in order to use Fork-join framework. 
 * In this case, we used RecursiveAction since we don't want to return any value.
 * and we have to override the 'compute' method of RecursiveAction.
 */
public class _1SimpleRecursiveAction extends RecursiveAction {

	private int simulatedWork;
	
	public _1SimpleRecursiveAction(int simulatedWork) {
		this.simulatedWork = simulatedWork;
	}
	
	/****
	 * This does not return anything.
	 */
	@Override
	protected void compute() {
		
		/*Checking whether we need to split the tasks or not for parallel execution. */
		if( simulatedWork > 100 ) {
			
			System.out.println("Parallel execution and split the tasks..." + simulatedWork);
			
			/****Creating the instance of 'SimpleRecursiveAction' and it is the task because 'SimpleRecursiveAction' extending the RecursiveAction
			 * Dividing the tasks in two parts, means half of the work of 'simulatedWork' will be done by instance 
			 * 'simpleRecursiveAction1' and other half will be done by 'simpleRecursiveAction2'
			 * 
			 *  The _1SimpleRecursiveAction example also breaks the work down into subtasks, 
			 *  and schedules these subtasks for execution using their fork() method.
			 *  */
			_1SimpleRecursiveAction simpleRecursiveAction1 = new _1SimpleRecursiveAction(simulatedWork/2);
			//Another task.
			_1SimpleRecursiveAction simpleRecursiveAction2 = new _1SimpleRecursiveAction(simulatedWork/2);
			 
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
			
		} else {
			/*Checking whether we need to split the tasks or not for parallel execution. Here, we need sequential execution only. */
			System.out.println("No need for parallel execution, sequential is OK for this task..." + simulatedWork);
		}
	}
}
