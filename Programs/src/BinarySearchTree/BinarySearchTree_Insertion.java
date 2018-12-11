package BinarySearchTree;
// Java program to demonstrate insert operation in binary search tree
class BinarySearchTree_Insertion {
	// Root of BST
	Node root; // Reference of Node class

	// Constructor
	BinarySearchTree_Insertion() { 
		root = null; 
	}

	// This method mainly calls insertRec()
	void insert(int key) {
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) {
		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	// This method mainly calls InorderRec()
	void inorder()  {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left); // once we reach last node while traversing left (i.e. 20), next iteration after visited 20, root.left would be null.
			// so if condition would get failed and comes out from if condition but cursor would come to print line , immediately exit from loop 
			// because recursion peeche apna address chod aa jata h.
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}

	// Driver Program to test above functions
	public static void main(String[] args) {
		BinarySearchTree_Insertion tree = new BinarySearchTree_Insertion();

		/* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// print inorder traversal of the BST
		tree.inorder();
	}
}