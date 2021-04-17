package com.data.facebooj;

public class ConvertBTToCircularDoublyLinkedList {
	
	
	/*
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	};
	*/

	class Solution {
	    
	    public Node treeToDoublyList(Node root) {
	        if(root == null)
	            return null;
	        Node head = null;
	        Node tail = null;
	        Node[] node =  dfs(root,new Node[]{head,tail});
	        node[1].right = node[0];
	        node[0].left = node[1];
	        return node[0];
	        
	    }
	    
	    
	    private Node[] dfs(Node root, Node[] node){
	        if(root == null)
	            return node;
	        
	        node = dfs(root.right,node);
	        Node head = node[0];
	        Node tail = node[1];
	        root.right = head;
	        if(head!=null){
	            head.left = root;
	        }
	        head = root;
	        if(tail == null){
	            root.right = tail;
	            tail = root;
	        }
	        node = dfs(root.left,new Node[]{head,tail});    
	        return node;
	    }
	}

}
