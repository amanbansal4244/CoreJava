package QuestionOnMultithreading;
/****
 * Problem:
	You are given 3 threads. You need to print sequence using these 3 threads.You need to print in natural order up to MAX.
	
	For example:
	Let’s say you have 3 threads. T1,T2 and T3.
	If MAX is 10, you need to print:
	
	T1 1
	T2 2
	T3 3
	T1 4
	T2 5
	T3 6
	T1 7
	T2 8
	T3 9
	T1 10

Solution:
	We will use concept of remainder here.
	
	If number%3==1 then T1 will print the number and increment it else will go in the wait state.
	If number%3==2 then T2 will print the number and increment it else will go in the wait state.
	If number%3==0 then T3 will print the number and increment it else will go in the wait state.
*
 */
public class _1PrintThreadsSequentiallyMain {
 
	public static void main(String[] args) {
		
		_1PrintSequenceRunnable runnable1=new _1PrintSequenceRunnable(1);
		_1PrintSequenceRunnable runnable2=new _1PrintSequenceRunnable(2);
		_1PrintSequenceRunnable runnable3=new _1PrintSequenceRunnable(0);
		
		Thread t1=new Thread(runnable1,"T1");
		Thread t2=new Thread(runnable2,"T2");
		Thread t3=new Thread(runnable3,"T3");
		
		t1.start();
		t2.start();
		t3.start();	  
	}
}