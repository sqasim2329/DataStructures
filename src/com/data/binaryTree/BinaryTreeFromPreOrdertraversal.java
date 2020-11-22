package com.data.binaryTree;

public class BinaryTreeFromPreOrdertraversal {

	class Index {
		int indx;
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		Index indx = new Index();
		return dfs(preorder, indx, Integer.MAX_VALUE);
	}

	private TreeNode dfs(int[] preorder, Index indx, int limit) {
		if (indx.indx == preorder.length || preorder[indx.indx] > limit) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[indx.indx++]);
		root.left = dfs(preorder, indx, root.val);
		root.right = dfs(preorder, indx, limit);
		return root;
	}
}


