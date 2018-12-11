package StackRelatedProblem;
import java.util.Stack;
import java.util.Iterator;

public class ReverseStackUsingWithoutRecursion {
	
	public static void main(String[] args) {
		Stack s = new Stack();
		Stack s1 = new Stack();
		s.push(2);
		s.push(4);
		s.push(12);
		s.push(23);
		s.push(22);
		
		Iterator i = s.iterator();
		while(i.hasNext()){
			System.out.println("Before Reverse"+":"+i.next());
		}
		
		while(!s.empty()){
			s1.push(s.pop());
		}
		
		Iterator ii = s1.iterator();
		while(ii.hasNext()){
			System.out.println("After Reverse"+ ":"+ii.next());
		}
		
	}

}
