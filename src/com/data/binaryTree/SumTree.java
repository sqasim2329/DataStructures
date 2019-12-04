package com.data.binaryTree;

public class SumTree {
	
	boolean isSumTree(Node node)
	{
	    if(node==null)
	    return true;
	     
	    if(node.left!=null && node.right!=null 
	    && sum(node.left)+sum(node.right)==node.data)
	    return true;
	    else if(node.left==null && node.right==null)
	    return true;
	    else
	    return false;
	    
           
              
	}
	
	int sum(Node root){
	    if(root==null)
	    return 0;
	    
	    int sumLeft=sum(root.left);
	    int sumRight=sum(root.right);
	    
	    return sumLeft+sumRight+root.data;
	    
	}
	
	public static void main(String args[]) {
		
		
	}

}
