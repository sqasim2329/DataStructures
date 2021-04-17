package com.data.binaryTree;

import java.util.Stack;

public class ConvertBTToDll {
	
	
	Node bToDLL(Node root)
    {
	    return dfs(root,null);
	    
    }
    
    private Node dfs(Node root,Node head){
        if(root == null)
        return head;
        
        head = dfs(root.right,head);
        root.right =head;
        if(head!=null)
            head.left = root;
        head = root;    
        head = dfs(root.left,head);    
        return head;
    }
    

}
