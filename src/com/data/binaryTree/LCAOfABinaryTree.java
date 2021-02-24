package com.data.binaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LCAOfABinaryTree {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stk = new Stack<>();
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        stk.push(root);
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode current = stk.pop();
            if(current.left != null){
                parent.put(current.left,current);
                stk.push(current.left);
            }
            
            if(current.right != null){
                parent.put(current.right,current);
                stk.push(current.right);
            }
        }
        
        Set<TreeNode> ancestors = new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p = parent.get(p);
        }
        
        while(!ancestors.contains(q))
            q = parent.get(q);
        
        return q;
    }
	     
	
	public TreeNode lowestCommonAncestorRecur(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q)
			return root;
		
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		
		if(left!=null && right != null)
			return root;
		else if(left!=null)
			return left;
		else 
			return right;
    }

}
