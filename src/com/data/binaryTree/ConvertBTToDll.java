package com.data.binaryTree;

public class ConvertBTToDll {
	
	
	static Node prev = null;// since its vakue can be retained across all recursive calls
    Node bToDLL(Node root)
    {
	    Node head = null;
	    head = dfs(root,head);
	    return head;
    }
    
    
    private Node dfs(Node root,Node head){
        if(root == null)
        return head;
        
        head =dfs(root.left,head);
        if(head == null){
            head = root;
        }else{
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        head = dfs(root.right,head);
        return head;
    }
    

}
