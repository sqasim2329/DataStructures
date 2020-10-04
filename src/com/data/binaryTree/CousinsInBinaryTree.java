package com.data.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
	
	 public boolean isCousins(TreeNode root, int x, int y) {
	        
	        boolean isX = false;
	        boolean isY = false;
	        
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int i=0;i<size;i++){
	            TreeNode curr = q.poll();
	            if(curr.val == x) isX = true;
	            if(curr.val == y) isY = true;
	            if(curr.left!=null && curr.right!=null){
	                if(curr.left.val==x && curr.right.val == y)
	                    return false;
	                else if(curr.left.val==y && curr.right.val == x)
	                    return false;
	                
	            }
	                if(curr.left!=null)q.add(curr.left);
	                if(curr.right!=null)q.add(curr.right);   
	            }
	            
	            if(isX && isY)
	            return true;
	            if(isX || isY)
	            return false;
	        }
	        return false;
	    }

}
