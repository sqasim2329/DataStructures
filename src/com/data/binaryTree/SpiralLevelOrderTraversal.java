package com.data.binaryTree;

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

}
