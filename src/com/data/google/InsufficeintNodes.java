package com.data.google;

public class InsufficeintNodes {
	
	public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null)
            return root;
       
       if(root.left == null && root.right == null){//if leaf
           return root.val < limit?null:root;
       }else{//if not leaf
           root.left = sufficientSubset(root.left,limit-root.val);
           root.right = sufficientSubset(root.right,limit-root.val);
           if(root.left == null && root.right == null)
               return null;
           else
               return root;
       }
       
       
   }

}
