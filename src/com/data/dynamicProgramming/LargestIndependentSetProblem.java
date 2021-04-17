package com.data.dynamicProgramming;

public class LargestIndependentSetProblem {
	
	private int lis(TreeNode root) {
		Map<TreeNode, Integer> map = new HashMap<>();
		if(map.containsKey(root))return map.get(root);
		if(root == null)
			return 0;
		
		int exclude = lis(root.left)+lis(root.right);
		int include = 1;
		if(root.left!=null) {
			include+=lis(root.left.left)+lis(root.left.right);
		}
		if(root.right!=null) {
			include+=lis(root.right.left)+lis(root.right.right);
		}
		map.put(root,Math.max(exclude, include));
		return Math.max(exclude,include);
	}

}
