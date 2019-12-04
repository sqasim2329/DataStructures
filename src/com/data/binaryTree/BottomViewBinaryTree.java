package com.data.binaryTree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;



public class BottomViewBinaryTree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		int hd;
		
		Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String args[]) {
		Node root = new Node(20);
		root.left = new Node(8); 
	    root.right = new Node(22); 
	    root.left.left = new Node(5); 
	    root.left.right = new Node(3); 
	    root.right.left = new Node(4); 
	    root.right.right = new Node(25); 
	    root.left.right.left = new Node(10); 
	    root.left.right.right = new Node(14);
	    Map<Integer, Integer> map = new HashMap<>();
	    printbottomView(root);
	    
	}

	private static void printbottomView(Node root) {
		Queue<Node> q = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		root.hd = 0;
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int hd = temp.hd; 
			map.put(hd, temp.data);
			if(temp.left!=null) {
				temp.left.hd = hd -1;
				q.add(temp.left);
			} if(temp.right != null) {
				temp.right.hd = hd +1;
				q.add(temp.right);
			}
		}
		
		Set<Entry<Integer,Integer>> mapset = map.entrySet();
	    Iterator<Entry<Integer,Integer>> itr = mapset.iterator();
	    while(itr.hasNext()) {
	    	System.out.println(itr.next().getValue());
	    }
		
	}

}
