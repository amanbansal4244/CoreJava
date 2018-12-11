
package TriplePointProblem;

/**
 *
 * @author aman
 */



public class Main {
	public static void main(String[] args) {
		CommunicateClass cs=new CommunicateClass();
		
		ProblemInterface i; 
		i=new Schedule();   
		cs.call(i); 
	}}