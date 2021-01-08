package BinarySearchTree;

public class BinarySearchTreeCheck {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	

	public static void main(String[] args) {
		// Creating a binary search tree
		TreeNode rootNode = createBinarySearchTree();

		System.out.println("-------------------------");
		System.out.println("Using inorder method");

		//TreeNode prev = new TreeNode(Integer.MIN_VALUE);
		//System.out.println(isBSTInOrder(rootNode, prev));

		System.out.println("-------------------------");
		System.out.println("Using min max method");
		System.out.println(isBST(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE));

		// Creating a binary tree which is not BST
		//TreeNode rootNodeBinaryTree = createBinaryTree();

		System.out.println("-------------------------");
		System.out.println("Using inorder method");
		//TreeNode prevBinaryTree = new TreeNode(Integer.MIN_VALUE);
		//System.out.println(isBSTInOrder(rootNodeBinaryTree, prevBinaryTree));

		System.out.println("-------------------------");
		System.out.println("Using min max method");
		//System.out.println(isBST(rootNodeBinaryTree, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println("-------------------------");
	}

	public static TreeNode createBinarySearchTree() {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		TreeNode node5 = new TreeNode(5);
		TreeNode node55 = new TreeNode(55);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		node10.left = node5;
		node50.right = node55;
		return rootNode;
	}

	public static TreeNode createBinaryTree() {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		TreeNode node5 = new TreeNode(5);
		TreeNode node55 = new TreeNode(55);

		rootNode.left = node20;
		rootNode.right = node10;

		node20.left = node60;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		node10.left = node5;
		node50.right = node55;
		return rootNode;
	}
	// Function to determine if given Binary Tree is a BST or not by keeping a
    // valid range (starting from [MIN_VALUE, MAX_VALUE]) and keep shrinking
    // it down for each node as we go down recursively
	public static boolean isBST(TreeNode root, int minKey, int maxKey) {
		// base case
		if (root == null)
			return true;
		// if node's value fall outside valid range
		if (root.data < minKey || root.data > maxKey)
			return false;
		// recursively check left and right subtrees with updated range
		return isBST(root.left, minKey, root.data) && isBST(root.right, root.data, maxKey);

	}
	
	// Function to perform inorder traversal of the given binary tree and
    // check if it is a BST or not. Here prev is previous processed node
	public static boolean isBSTInOrder(TreeNode root, TreeNode prev) {
		// base case: empty tree is a BST
		if (root == null)
			return true;

		 // check if left subtree is BST or not
        boolean left = isBSTInOrder(root.left, prev);
 
        // value of current node should be more than that of previous node
        if (root.data <= prev.data) {
            return false;
        }
 
        // update previous node data and check if right subtree is BST or not
        prev.data = root.data;
 
        return left && isBSTInOrder(root.right, prev);

	}

}
 