package OnlineProblem;
import java.util.Stack;

import javax.swing.text.StyledEditorKit.BoldAction;

//Problem Statement Link -> https://www.hackerrank.com/challenges/java-stack

public class StringBalanced {
	
	public static boolean check(String str){
		char [] ch = str.toCharArray();
		Stack<Character> s = new Stack<Character>();
		
		for(Character c : ch){
			
			switch (c) {
			case '[':
			case '{':
			case '(':
				s.push(c);
				break;
				
			case ')':
				if(s.isEmpty() || s.pop() != '(')
					return false;
				break;
				
			case '}':
				if(s.isEmpty() || s.pop() != '{')
					return false;
				break;
				
			case ']':
				if(s.isEmpty() || s.pop() != '[')
					return false;
				break;
			default:
				break;
			}
		}
		return s.isEmpty();
	}
	public static void main(String[] args) {
		
		String str="[{()}]";
		
	boolean res=	check(str);
		System.out.println(res);
		
	}

}
