package com.data.binaryTree;
//O(log(N))* O(log(N))since we are recalculating height and worst case is O(logn)
public class CountCompleteTreeNodes {
	
	public int countNodes(TreeNode root) {

	    int leftDepth = leftDepth(root);
		int rightDepth = rightDepth(root);

		if (leftDepth == rightDepth)
			return (1 << leftDepth) - 1;
		else
			return 1+countNodes(root.left) + countNodes(root.right);

	}

	private int rightDepth(TreeNode root) {
		// TODO Auto-generated method stub
		int dep = 0;
		while (root != null) {
			root = root.right;
			dep++;
		}
		return dep;
	}

	private int leftDepth(TreeNode root) {
		// TODO Auto-generated method stub
		int dep = 0;
		while (root != null) {
			root = root.left;
			dep++;
		}
		return dep;
	}
	
	
	public int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null)
            return (1 << height) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
