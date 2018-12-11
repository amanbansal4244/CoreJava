package snippet;
public class ArrayStackImpl <T> implements StackIntf <T>
{
    private T stack[];
    private int top;
    private final static int DEFAULT_SIZE = 10;
    public ArrayStackImpl ()
    {
        this(DEFAULT_SIZE);
    }
    public ArrayStackImpl (int size)
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