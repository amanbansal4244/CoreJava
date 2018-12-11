package StackRelatedProblem;
/* Write a production ready code to implement Stack using Array which can hold any data type.
 * The Stack will perform the following operations:
 * 	push -> to insert elements in stack.
 *  pop -> to delete elements from stack.
 *  peek -> to fetch last inserted value.
 *  
 *  Note : Insertion, Deletion operation should be in minimum time complexity.
 *  		   There should not to be any memory leakage in the code.
 * 
 * */
 
public class StackOperationsUsingGeneric <T> 
{
    private T stack[];
    private int top;
    private final static int DEFAULT_SIZE = 10;
    public StackOperationsUsingGeneric ()
    {
        this(DEFAULT_SIZE);
    }
    public StackOperationsUsingGeneric (int size)
    {
    	stack = (T[]) new Object [size];
        top = -1;
    }
    public T getTop()
    {
        if (top == -1)
            return null;
        return stack[top];
    }
    public boolean isEmpty()
    {
        return (top == -1);
    }
    public T pop()
    {
        if (top == -1)
            return null;
        return stack[top--];
    }
 
    public void push(T itm)
    {
stack[++top] = itm;
    }
 
    public int size()
    {
        return (top + 1);
    }
}