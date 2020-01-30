package com.data.binaryTree;

import java.util.Iterator;
import java.util.Stack;

public class PathOfBT {
	
	public static void main(String args[]) {
	Node root = new Node(1); 
    root.left = new Node(2); 
    root.right = new Node(3); 
    root.left.left = new Node(4); 
    root.left.right = new Node(5); 
    root.right.left = new Node(6);
    Stack<Integer> stk=new Stack<>();
    printPath(root,stk);
	}

	private static void printPath(Node root,Stack<Integer> stk) {
		if(root==null)
			return;
		
		stk.push(root.data);
		if(root.left==null && root.right==null) {
			printStack(stk);
		return;
		}
		
		printPath(root.left,stk);
		stk.pop();
		printPath(root.right,stk);
		stk.pop();		
		
		
		
	}

	private static void printStack(Stack<Integer> stk) {
		Iterator<Integer> itr=stk.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
			
		}
		
		System.out.println();
		
		
	}
	
	

}
