package com.data.binaryTree;
//O(n) time O(1) space

//O(n) O(n) use a single queue each time determine the size while (size > 0) keep on assignig values
public class PopulatingNextPointersInEachNode {
	
	class Solution {
	    public TreeNode connect(TreeNode root) {
	        
	        return dfs(root,null);
	        
	    }
	    
	    private TreeNode dfs(TreeNode root,TreeNode next){
	        if(root == null)
	            return null;
	        root.next = next;
	        
	        dfs(root.left,root.right);
	        dfs(root.right,root.next == null?null:root.next.left);
	        return root;
	    }
	}

}
