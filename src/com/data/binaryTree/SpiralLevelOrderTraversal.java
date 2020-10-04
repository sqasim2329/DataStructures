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

	private static void printSpiral(Node root) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.add(root);
		while(!s1.isEmpty() || !s2.isEmpty()) {
		while(!s1.isEmpty()) {
			Node temp =  s1.pop();
			System.out.println(temp.data);
			if(temp.right!=null) {
				s2.push(temp.right);
			}
			if(temp.left!=null) {
				s2.push(temp.left);
			}
		}
		
		while(!s2.isEmpty()) {
			Node temp = s2.pop();
			System.out.println(temp.data);
			if(temp.left!=null) {
				s1.push(temp.left);
			}
			
			if(temp.right!=null) {
				s1.push(temp.right);
			}
		}
	}
		
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
	
	//check-leaves-level

}
