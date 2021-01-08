package BinarySearchTree;

public class DeleteNodeinaBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	/*
	 * One step right and then always left
	 */
	public static int successor(TreeNode root) {
		root = root.right;
		while (root.left != null)
			root = root.left;
		return root.val;
	}

	/*
	 * One step left and then always right
	 */
	public static int predecessor(TreeNode root) {
		root = root.left;
		while (root.right != null)
			root = root.right;
		return root.val;
	}

	public static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;

		// delete from the right subtree
		if (key > root.val)
			root.right = deleteNode(root.right, key);
		// delete from the left subtree
		else if (key < root.val)
			root.left = deleteNode(root.left, key);
		// delete the current node
		else {
			// the node is a leaf
			if (root.left == null && root.right == null)
				root = null;
			// the node is not a leaf and has a right child
			else if (root.right != null) {
				root.val = successor(root);
				root.right = deleteNode(root.right, root.val);
			}
			// the node is not a leaf, has no right child, and has a left child
			else {
				root.val = predecessor(root);
				root.left = deleteNode(root.left, root.val);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		//LCA bi = new LCA();
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();

		int key = 5;

		System.out.println(deleteNode(rootNode, key).val);

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
		//TreeNode node45 = new TreeNode(45);
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

