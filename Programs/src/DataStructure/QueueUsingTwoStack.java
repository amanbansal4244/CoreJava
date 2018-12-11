package DataStructure;

import java.util.*;
import java.util.Stack;

public class QueueUsingTwoStack {

	Stack<Integer> oldFirstStack ;
	Stack<Integer> newSecondStack ;
	private int topElement;
	private int size;
	
	public QueueUsingTwoStack(){
		oldFirstStack = new Stack<Integer>();
		newSecondStack = new Stack<Integer>();
		topElement=-1;
		size=-1;
	}
	
	public boolean Enqueue(int element){
		boolean ret = true;
		try
		{ 
			oldFirstStack.push(new Integer(element));
		}
		catch (Exception e) {
			ret = false;
			System.out.println("error occoured");
		}
		
		return ret;
	}
	
	public int Dequeue(){
		topElement=-1;
		if(newSecondStack.empty()){
				while(!oldFirstStack.empty()){
					topElement=oldFirstStack.peek();// return the top element without removing top element value
					newSecondStack.push(topElement);
					oldFirstStack.pop();
				}
		}
		
		if(!newSecondStack.empty()){
			Integer i = newSecondStack.peek();
			topElement= i.intValue();
			newSecondStack.pop();
			
		}
		
		return topElement;
		
	}
	
	public boolean IsEmpty(){
		if(newSecondStack.empty() && oldFirstStack.empty()){
			return true;
		}
		else
			return false;
	}
	
	public int GetSize(){
		size = newSecondStack.size()+oldFirstStack.size();
		return size;
	}

	public static void main(String[] args) {
		
		QueueUsingTwoStack q  = new QueueUsingTwoStack();
		
		System.out.println("Queue is empty"+ q.IsEmpty());
		
		for(int i = 0; i< 6; i++){
			q.Enqueue(i*10);
			System.out.println("Enqueued "+" " + i*10+" " + "into the Stack");
		}
		
		int Size = q.GetSize();
		for(int i = 0; i< Size; i++){
			System.out.println("Dequeued "+" " + q.Dequeue()+" " + "into the queue");
		}
		
	}
}
