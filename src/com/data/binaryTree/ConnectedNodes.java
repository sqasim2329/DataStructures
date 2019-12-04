package com.data.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedNodes {
	
	public static void main(String args[]) {
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.right.right.left = new Node(10);
        root.right.right.right = new Node(11);
        connectNodes(root); 
	}

	private static void connectNodes(Node root) {
		Queue<Node> s1 = new LinkedList<>();
		Queue<Node> s2 = new LinkedList<>();
		s1.add(root);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				Node temp = s1.poll();
				if(s1.isEmpty()) {
					temp.nextRight = null;
				}else {
					temp.nextRight = s1.peek();
				}
				Object nextRight = temp.nextRight==null?"null":temp.nextRight.data;
				System.out.println(temp.data+"->"+nextRight);
				if(temp.left!=null) {
					s2.add(temp.left);
				}
				if(temp.right!=null) {
					s2.add(temp.right);
				}
			}
			
			while(!s2.isEmpty()) {
				Node temp = s2.poll();
				if(s2.isEmpty()) {
					temp.nextRight = null;
				}else {
					temp.nextRight = s2.peek();
				}
				Object nextRight = temp.nextRight==null?"null":temp.nextRight.data;
				System.out.println(temp.data+"->"+nextRight);
				if(temp.left!=null) {
					s1.add(temp.left);
				}
				if(temp.right!=null) {
					s1.add(temp.right);
				}
			}
		}
		
	}

}
