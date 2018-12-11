package LinkedList;
/*We know that Floyd�s Cycle detection algorithm terminates when fast and slow pointers meet at a common point.
 * Detect Algorithm:	
 * 	Efficient approach for this problem would be Floyd's cycle detection algorithm,so steps for this algorithm would be:
		Use two pointer fastPtr and slowPtr and initialize both to head of linked list
		Move fastPtr by two nodes and slowPtr by one node in each iteration.
		If fastPtr and slowPtr meet at some iteration , then there is a loop in linked list.
		If fastPtr reaches to the end of linked list without meeting slow pointer then there is no loop in linked list (i.e fastPtr->next or fastPtr->next->next become null)
 * 
 *  Remove Algorithm:
 *  We also know that this common point is one of the loop nodes (2 or 3 or 4 or 5 in the above diagram).
 *  We store the address of this in a pointer variable say ptr2. Then we start from the head of the Linked List and 
 *  check for nodes one by one if they are reachable from ptr2. When we find a node that is reachable, 
 *  we know that this node is the starting node of the loop in Linked List and we can get pointer to the previous of this node.
*/

// Java program to detect and remove loop in linked list
 
class DetectAndRemoveLoop_LinkedList {
 
    static Node head;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    // Function that detects loop in the list
    int detectAndRemoveLoop(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next; //one node in each iteration.
            fast = fast.next.next;//two node in each iteration.
 
            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }
 
    // Function to remove loop
    void removeLoop(Node loop, Node curr) {
        Node ptr1 = null, ptr2 = null;
 
        /* Set a pointer to the beginning of the Linked List and move it one by one to find the first node which is part of the Linked List */
        ptr1 = curr;
        while (1 == 1) { // running infinite loop, we have to do this to get loop.
 
            /* Now start a pointer from loop_node and check if it ever reaches ptr2 */
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
 
            /* If ptr2 reached ptr1 then there is a loop. So break the loop */
            if (ptr2.next == ptr1) {
                break;
            }
 
            /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
            ptr1 = ptr1.next;
        }
 
        /* After the end of loop ptr2 is the last node of the loop. So make next of ptr2 as NULL */
        ptr2.next = null;
    }
 
    // Function to print the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    // Driver program to test above functions
    public static void main(String[] args) {
        DetectAndRemoveLoop_LinkedList list = new DetectAndRemoveLoop_LinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);
 
        // Creating a loop for testing 
        head.next.next.next.next.next = head.next.next;
        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
}