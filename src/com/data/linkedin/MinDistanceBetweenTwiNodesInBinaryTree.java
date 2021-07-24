package com.data.linkedin;

public class MinDistanceBetweenTwiNodesInBinaryTree {
	
	class GfG {
	    
	    int findDist(Node root, int a, int b) {
	        Node lnode = lcs(root,a,b);
	        int dist = findDist(0,lnode,a);
	        dist += findDist(0,lnode,b);
	        return dist;
	    }
	    
	    private static Node lcs(Node root,int a, int b){
	        if(root == null || root.data == a || root.data == b)
	            return root;
	        
	        Node left = lcs(root.left,a,b);    
	        Node right = lcs(root.right,a,b);    
	        if(left!=null && right!=null)
	            return root;
	        else if(left == null && right == null)
	            return null;
	        else if(right!=null)
	            return right;
	        else
	            return left;
	        
	    }
	    
	    
	    private int findDist(int cost,Node curr,int a){
	        if(curr == null)
	            return -1;
	        
	        if(curr.data == a)   
	            return cost;
	            
	        int left = findDist(cost+1,curr.left,a);    
	        if(left == -1)
	            return findDist(cost+1,curr.right,a);
	        return left;
	        
	        
	    }
	}

}
