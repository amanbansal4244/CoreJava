package StackRelatedProblem;
import java.util.Stack;


public class ReverseStackUsingRecursion {
	 public static void reverse(Stack<String> stack){
	        String element = stack.pop();
	        if(stack.size() != 1) { //iterate till we get 2nd last element. i.e 'B' in this case
	            reverse(stack);
	        }
	        pushToBottomOfStack(element,stack); // recursion always apna return address peeche chod jata h  and jab recursion vala
	        									// method apna kam pura kr leta h to vapis rest lines excecute krta h one by one .
	        									// In recursion , stack always maintain all values(parameters) of function automatically. 
	    }
	 
	 
	    private static void pushToBottomOfStack(String element, Stack<String> stack){
	        String data = stack.pop();
	        if(stack.size() != 0){ //iterate till we get last element.
	            pushToBottomOfStack(element, stack);
	        }
	        else {
	            stack.push(element);
	        }
	        stack.push(data);
	    }
	 
	    public static void main(String args[]) {
	        Stack<String> myStack = new Stack<String>();
	        myStack.push("A");
	        myStack.push("B");
	        myStack.push("C");
	        myStack.push("D");
	        System.out.println("Original Stack : " + myStack);
	        ReverseStackUsingRecursion.reverse(myStack);
	        System.out.println("Revered Stack : " + myStack);
	 
	    }

}
