package BinarySearchTree;

import BinarySearchTree.LCA.TreeNode;

public class SearchinaBinarySearchTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int d) {
			this.val = d;
		}
	}

	// Recursion
	public static TreeNode searchBST(TreeNode root, int val) {
		if (root == null || val == root.val)
			return root;

		return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
	}

	// Iteration
	public static TreeNode searchBSTIterative(TreeNode root, int val) {
		while (root != null && val != root.val)
			root = val < root.val ? root.left : root.right;
		return root;
	}
	
	public static void main(String[] args) {
		LCA bi = new LCA();
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();
		System.out.println("Lowest common ancestor for node 5 and 30 using Recursion:");
		TreeNode node5 = new TreeNode(5);
		TreeNode node30 = new TreeNode(30);
		//System.out.println(searchBST(rootNode, 5));

		System.out.println("Lowest common ancestor for node 5 and 30 using Iteration:");
		TreeNode node = searchBSTIterative(rootNode, 5);
		while(node != null) {
			System.out.println(node.left);
		}

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
		TreeNode node45 = new TreeNode(45);
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
}
