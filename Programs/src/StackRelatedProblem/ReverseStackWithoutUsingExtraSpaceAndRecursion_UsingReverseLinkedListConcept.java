package StackRelatedProblem;
// Java program to implement Stack using linked list so that reverse can be done with O(1) extra space.

/*This solution requires O(n) extra space. We can reverse a string in O(1) time 
 * if we internally represent the stack as linked list.
 *Reverse a stack would require a reversing a linked list which can be done with O(n) time and O(1) extra space.

Note that push() and pop() operations still take O(1) time.
*/
class StackNode {
    int data;
    StackNode next;
    public StackNode(int data)
    {
        this.data = data;
        this.next = null;
    }
}
 
class Stack {
    StackNode top;
 
    // Push and pop operations
    public void push(int data)
    {
        if (this.top == null) {
            top = new StackNode(data);
            return;
        }
        StackNode s = new StackNode(data);
        s.next = this.top;
        this.top = s;
    }
    public StackNode pop()
    {
        StackNode s = this.top;
        this.top = this.top.next;
        return s;
    }
 
    // prints contents of stack
    public void display()
    {
        StackNode s = this.top;
        while (s != null) {
            System.out.print(" " + s.data);
            s = s.next;
        }
        System.out.println();
    }
 
    // Reverses the stack using simple using linked list reversal logic.
    public void reverse()
    {
        StackNode next, current, prev;
        current = prev = this.top;// because in stack , we wont have last node-> next as null like linked list.
        current = current.next;
        prev.next = null;
        while (current != null) {
        	next = current.next;
        	current.next = prev;
            prev = current;
            current = next;
        }
        this.top = prev;
    }
}
 
public class ReverseStackWithoutUsingExtraSpaceAndRecursion_UsingReverseLinkedListConcept {
    public static void main(String[] args)
    {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("Original Stack");
        s.display();
 
        // reverse
        s.reverse();
 
        System.out.println("Reversed Stack");
        s.display();
    }
}
