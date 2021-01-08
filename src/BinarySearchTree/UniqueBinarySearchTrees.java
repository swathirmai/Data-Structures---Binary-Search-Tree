package BinarySearchTree;
import java.util.*;

public class UniqueBinarySearchTrees {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		TreeNode rootNode = createBinaryTree();
		System.out.println(numTrees(3));

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
	
	public static int numTrees(int n) {
		int[] count = new int[n + 1];
	 
		count[0] = 1;
		count[1] = 1;
	 
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				count[i] = count[i] + count[j] * count[i - j - 1];
			}
		}
	 
		return count[n];
	}
	
	public static List<TreeNode> generateTrees(int n) {
	    if(n==0){
	        return new ArrayList<TreeNode>();
	    }
	 
	    return helper(1, n);
	}
	 
	public static List<TreeNode> helper(int m, int n){
	    List<TreeNode> result = new ArrayList<TreeNode>();
	    if(m>n){
	        result.add(null);
	        return result;
	    }
	 
	    for(int i=m; i<=n; i++){
	        List<TreeNode> ls = helper(m, i-1);
	        List<TreeNode> rs = helper(i+1, n);
	        for(TreeNode l: ls){
	            for(TreeNode r: rs){
	                TreeNode curr = new TreeNode(i);
	                curr.left=l;
	                curr.right=r;
	                result.add(curr);
	            }
	        }
	    }
	 
	    return result;
	}
}
