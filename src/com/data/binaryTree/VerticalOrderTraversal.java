package com.data.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

import com.data.binaryTree.BottomViewBinaryTree.Node;

public class VerticalOrderTraversal {
	
	public static void main(String args[]) {
		Node root = new Node(1); 
	    root.left = new Node(2); 
	    root.right = new Node(3); 
	    root.left.left = new Node(4); 
	    root.left.right = new Node(5); 
	    root.right.left = new Node(6); 
	    root.right.right = new Node(7); 
	    root.right.left.right = new Node(8); 
	    root.right.right.right = new Node(9); 
	    root.right.right.left= new Node(10); 
	    root.right.right.left.right= new Node(11); 
	    root.right.right.left.right.right= new Node(12);
	    verticalOrderTracersal(root);
	}

	private static void verticalOrderTracersal(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		Map<Integer,List<Integer>> map = new TreeMap<>();
		root.hd = 0;
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int hd = temp.hd;
			if(map.containsKey(hd)) {
				map.get(hd).add(temp.data);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(temp.data);
				map.put(hd, list);
			}
			
			if(temp.left!=null) {
				temp.left.hd = hd-1;
				q.add(temp.left);
			}
			if(temp.right!=null) {
				temp.right.hd = hd+1;
				q.add(temp.right);
			}
		}
		
		Set<Entry<Integer,List<Integer>>> entrySet =  map.entrySet();
		Iterator<Entry<Integer,List<Integer>>> itr = entrySet.iterator();
		while(itr.hasNext()) {
			Entry<Integer,List<Integer>> e = itr.next();
			System.out.println(e.getKey()+"--"+e.getValue());
		}
		
		
	}

}
