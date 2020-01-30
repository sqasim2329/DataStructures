??package com.data.binaryTree;

public class ConvertBTToDll {
	
	public static class NodeDLL{
		int val;
		NodeDLL next;
		NodeDLL prev;
	}
	
	public static void main(String args[]) {
	Node root = new Node(10); 
    root.left = new Node(12); 
    root.right = new Node(15); 
    root.left.left = new Node(25); 
    root.left.right = new Node(30); 
    root.right.left = new Node(36);
    Node head = null;
    		head = convertDLL(root,head);
    		System.out.println(head);
	}

	private static Node convertToDLL(Node root, Node head) {
		if(root==null) return head;
		head = convertToDLL(root.left,head);
		if(head == null) {
			head = root;
		}else {
			head.right = root;
			root.left = head ; 
			head = root;
		}
		head  = convertToDLL(root.right,head);
		return head;
	}
	
	private static Node convertDLL(Node root, Node head) {
		if(root == null) {
			return head;
		}
		head = convertDLL(root.left,head);
		if(head == null) {
			head = root;
		}else {
			Node temp = head;
			head.right = root;
			head = head.right;
			head.left = temp;
		}
		head = convertDLL(root.right,head);
		return head;
	}
    

}
