package com.data.binaryTree;

public class MaxPathOftree {
	
	public static void main(String args[]) {
		Node root = new Node(10); 
	    root.left = new Node(2); 
	    root.right = new Node(10); 
	    root.left.left = new Node(20); 
	    root.left.right = new Node(1); 
	    root.right.right = new Node(-25);
	    root.right.right.left = new Node(3);
	    root.right.right.right = new Node(4);
	    
	    System.out.println(findMaxSum(root));
	}
	
	static class Res{
		int val;
	}

	private static int findMaxSum(Node root) {
		Res res = new Res();// primitive variables dont store the result when they are back from findMaxUtil hence we use 
		res.val 	= Integer.MIN_VALUE;
		findMaxUtil(root,res);
		return res.val;
		
	}

	private static int findMaxUtil(Node root, Res res) {
		if(root == null) {
			return 0;
		}
		
		int l = findMaxUtil(root.left,res);
		int r = findMaxUtil(root.right,res);
		
		int maxlr=Math.max(l, r);
		int max_single = Math.max(maxlr+root.data, root.data);
		int max_top = Math.max(max_single, l+r+root.data);
		res.val = Math.max(res.val, max_top);
		return max_single;
		
		
	}

}
