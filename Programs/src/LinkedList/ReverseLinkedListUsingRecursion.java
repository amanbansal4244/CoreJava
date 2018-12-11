package LinkedList;

public class ReverseLinkedListUsingRecursion{  
	  
	 private Node head;  
	  
	 private static class Node {  
		  private int value;  
		  private Node next;  
		  
		  Node(int value) {  
		   this.value = value;  
		  
	  }  
	 }  
	  
	 public void addToTheLast(Node node) {  
	  
		  if (head == null) {  
		   head = node;  
		  } else {  
		   Node temp = head;  
		   while (temp.next != null)  
		    temp = temp.next;  
		    temp.next = node;  
		  }  
	 }  
	  
	  
	 public void printList(Node head) {  
	  Node temp = head;  
	  while (temp != null) {  
	   System.out.format("%d ", temp.value);  
	   temp = temp.next;  
	  }  
	  System.out.println();  
	 }  
	  
	 // Reverse linkedlist using this function as Recursion.  
	 
	/* Below function will terminate when last node(2)‘s next will be null.
	 * so while returning when you reach at node with value 1,
	 * If you closely observe node.next.next=node is actually setting 2->1(i.e. reversing the link between node with value 1 and 2) 
	 * and node.next=null is removing link 1->2. So in each iteration, you are reversing link between two nodes.
.*/
	 
	public static Node reverseLinkedList(Node node)  
	 {
		if(node == null || node.next == null){
			return node;
		}
		
		Node remaining = reverseLinkedList(node.next);
		node.next.next = node;
		node.next = null;
		return remaining;
	 }  
	
	 /* Function to print reverse of linked list */
    static void printReverse(Node head)
    {
        if (head == null) return;
 
        // print list of head node
        printReverse(head.next);
 
        // After everything else is printed
        System.out.print(head.value+" ");
    }
	  
	 public static void main(String[] args) {  
		 ReverseLinkedListUsingRecursion list = new ReverseLinkedListUsingRecursion();  
	  // Creating a linked list  
	  Node head=new Node(5);  
	  list.addToTheLast(head);  
	  list.addToTheLast(new Node(6));  
	  list.addToTheLast(new Node(7));  
	  list.addToTheLast(new Node(1));  
	  list.addToTheLast(new Node(2));  
	   
	  list.printList(head);  
	  //Reversing LinkedList  
	  Node reverseHead=reverseLinkedList(head);  
	  System.out.println("After reversing");  
	  list.printList(reverseHead);  
	  
	  
	  System.out.println("2nd trick:");
	  printReverse(head);
	   
	 }  
	  
	}  
