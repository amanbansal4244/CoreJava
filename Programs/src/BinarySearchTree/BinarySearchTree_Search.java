package BinarySearchTree;
// Java program to demonstrate search operation in binary search tree
class BinarySearchTree_Search {
	// Root of BST
	Node root;

	// Constructor
	BinarySearchTree_Search() { 
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

	// This method mainly calls searchInBST()
	void search(int key)  {
		Node resRoot = searchInBST(root, key);
		if(resRoot != null){
			System.out.println("Item found in BST and Value is : " + resRoot.key);
		}else{
			System.out.println("Item not found in BST");
		}
	}

	// A utility function to search a given key in BST
	public Node searchInBST(Node root, int key)
	{
		// Base Cases: root is null or key is present at root
		if (root==null || root.key==key)
			return root;

		// value is greater than root's key
		if (root.key > key){
			return searchInBST(root.left, key);
		}

		// val is less than root's key
		return searchInBST(root.right, key);
	}

	// Driver Program to test above functions
	public static void main(String[] args) {
		BinarySearchTree_Search tree = new BinarySearchTree_Search();

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

		tree.search(80);
	}
}