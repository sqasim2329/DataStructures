package com.data.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SpiralLevelOrderTraversal {
	
	public static void main(String args[]) {
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(7); 
        root.left.right = new Node(6); 
        root.right.left = new Node(5); 
        root.right.right = new Node(4); 
        System.out.println("Spiral Order traversal of Binary Tree is "); 
        printSpiral(root); 
	}
	
	
	
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<>();
	        dfs(res,root,0);
	        return res;
	    }
	    
	    private void dfs(List<List<Integer>> res,TreeNode root, int level){
	        if(root == null)
	            return;
	        
	        if(res.size()<=level){
	            List<Integer> ls = new LinkedList<>();
	            res.add(ls);
	        }
	        
	        List<Integer> coll = res.get(level);
	        if(level%2==0)
	            coll.add(root.val);
	        else
	            coll.add(0,root.val);
	        
	        dfs(res,root.left,level+1);
	        dfs(res,root.right,level+1);
	        
	    }
	


}
