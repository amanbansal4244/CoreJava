package BinaryTree;
/*
Given a Binary Tree, find sum of all left leaves in it. For example, sum of all left leaves in below Binary Tree is 5+23+50 = 78.

     			  20
               /    	  \
	     9     		   		49
	     				/	\
        /  \        23		52
	 5     12				/
	     	\				50
	     	15
*/// Passing sum as accumulator and implementing pass by reference of sum variable 
class Sum 
{
    int sum = 0;
}
  
class SumOfAllLeftLeavesInAGivenBinaryTree 
{
    Node root;
  
    /* Pass in a sum variable as an accumulator */
    void leftLeavesSumRec(Node node, boolean isleft, Sum summ) 
    {
        if (node == null)
            return;
  
        // Check whether this node is a leaf node and is left.
        if (node.left == null && node.right == null && isleft){
        	System.out.println("leaf node :"+ node.data);
            summ.sum = summ.sum + node.data;
        }
  
        // Pass true for left and false for right
        leftLeavesSumRec(node.left, true, summ);
        leftLeavesSumRec(node.right, false, summ);// we are traversing right node to get left node of right 
        										// and we are passing 'false' that means we are not adding right node value to sum.
    }
  
    // A wrapper over above recursive function
    int leftLeavesSum(Node node) 
    {
        Sum suum = new Sum();
         
        // use the above recursive function to evaluate sum
        leftLeavesSumRec(node, false, suum);
  
        return suum.sum;
    }
  
    // Driver program
    public static void main(String args[]) 
    {
        SumOfAllLeftLeavesInAGivenBinaryTree tree = new SumOfAllLeftLeavesInAGivenBinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(9);
        tree.root.right = new Node(49);
        tree.root.left.right = new Node(12);
        tree.root.left.left = new Node(5);
        tree.root.right.left = new Node(23);
        tree.root.right.right = new Node(52);
        tree.root.left.right.right = new Node(12);
        tree.root.right.right.left = new Node(50);
  
        System.out.println("The sum of leaves is " + 
                                    tree.leftLeavesSum(tree.root));
    }
}