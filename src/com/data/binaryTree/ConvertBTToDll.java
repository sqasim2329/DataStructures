package com.data.binaryTree;

import java.util.Stack;

public class ConvertBTToDll {
	
	
	Node head;
    Node bToDLL(Node root)
    {
	    
	    dfs(root);
	    return head;
    }
    
    
    private void dfs(Node root){
    	if(root== null)
    		return;
    	
    	dfs(root.right);
    	root.right = head;
    	if(head!=null)
    		head.left =root;
 
    	head = root;
    	dfs(root.left);
    }
    
    

}
