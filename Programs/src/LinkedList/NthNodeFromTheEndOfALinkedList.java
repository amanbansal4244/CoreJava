package LinkedList;
/*
(Use two pointers) 
Maintain two pointers – reference pointer and main pointer. Initialize both reference and main pointers to head. 4
First move reference pointer to n nodes from head. Now move both pointers one by one until reference pointer reaches end. 
Now main pointer will point to nth node from the end. Return main pointer.

Time Complexity: O(n) where n is the length of linked list.
 */public class NthNodeFromTheEndOfALinkedList {

	 Node head; // head of the list

	 /* Function to get the nth node from the last of a linked list */
	 void printNthFromLast(int n)
	 {
		 int len = 0;
		 Node temp = head;

		 // 1) count the number of nodes in Linked List
		 while (temp != null)
		 {
			 temp = temp.next;
			 len++;
		 }

		 // check if value of n is not more than length of the linked list
		 if (len < n){
			 System.out.println("Linked list length is smaller than required no.");
			 return;
		 }
		 temp = head;

		 // 2) get the (n-len+1)th node from the beginning
		 for (int i = 1; i < len-n+1; i++){
			 temp = temp.next;
		 }

		 System.out.println(temp.data);
	 }

	 /* Inserts a new Node at front of the list. */
	 public void push(int new_data)
	 {
		 /* 1 & 2: Allocate the Node & Put in the data*/
		 Node new_node = new Node(new_data);

		 /* 3. Make next of new Node as head */
		 new_node.next = head;

		 /* 4. Move the head to point to new Node */
		 head = new_node;
	 }

	 /*Drier program to test above methods */
	 public static void main(String [] args)
	 {
		 NthNodeFromTheEndOfALinkedList llist = new NthNodeFromTheEndOfALinkedList();
		 llist.push(20);
		 llist.push(4);
		 llist.push(15);
		 llist.push(35);
		 llist.push(25);
		 llist.push(135);
		 llist.push(325);

		 llist.printNthFromLast(5); // Linked list will be like : 325 > 135 > 25 > 35 > 15 > 4 > 20
	 }
}
