package CallableConcept4_ParallelProcessing;

/****
 * Example: Suppose the problem is to find a sum of all numbers from 1 to 100. We can do it by looping 1 to 100 sequentially and adding them.
 * Another way we can do it by the divide and Conquer rule.  Group the numbers in a way so each group has exactly two elements. 
 * Then Assign that group to a pool of threads.
 * So each thread returns a partial sum in parallel. Then collect those partial sums and add them to get the whole sum.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelAdder {
	public Integer parallelSum(int n) {
		// long t1 = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		int count = 1;
		int prev = 0;
		for (int i = 0; i < n; i++) {
			if (count % 2 == 0)// grouping
			{
				System.out.println("Prev :" + prev + " current: " + i);
				Future<Integer> future = executor.submit(new CallableAdder(prev, i));
				list.add(future);
				count = 1;
				continue;
			}
			prev = i;
			count++;
		}
		int totsum = 0;
		for (Future<Integer> fut : list) {
			try {
				totsum = totsum + fut.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Total Sum is " + totsum);
		// long t2 = System.currentTimeMillis();
		// System.out.println("Time taken by parallelSum " + (t2-t1));
		return totsum;
	}

}