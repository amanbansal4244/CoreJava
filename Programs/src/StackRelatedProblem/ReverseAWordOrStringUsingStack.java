package StackRelatedProblem;
import java.util.*;
import java.util.Stack;

public class ReverseAWordOrStringUsingStack {
	
	public String rerver(String input){
		
		StringBuffer sb = new StringBuffer();
		int size= input.length();
		
		Stack s=  new Stack();
		for(int i=0;i<size;i++){
			s.push(input.charAt(i));
		
		}
		
		while(!s.empty()){
			sb.append(s.pop());
		}
		
		return sb.toString();
		
		
	}
	public static void main(String[] args) {
		
		String input ="aman";
		ReverseAWordOrStringUsingStack obj = new ReverseAWordOrStringUsingStack();
		System.out.println("Reverse Word:" +obj.rerver(input));
	}

}
