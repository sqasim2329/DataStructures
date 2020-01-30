package com.data.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Node {

	Map<Integer, Node> children;
	boolean endOfWord;
	

	public Node() {
		super();
		this.children = new HashMap<>();
	}

}

public class PrintUniqueRows {
	
	
	public static void main(String args[]) {
		int arr[][] = {{0, 1, 0, 0, 1}, 
		        {1, 0, 1, 1, 0}, 
		        {0, 1, 0, 0, 1}, 
		        {1, 0, 1, 0, 0} 
		    }; 
		Node trie=new Node();
		createAndPrintUniqueTries(arr,trie);
		
	}

	private static void createAndPrintUniqueTries(int[][] arr, Node trie) {
		int row=0;
		while(row <= arr.length-1) {
			Node current=trie;
			boolean exists=true;
			for(int col=0;col<arr[row].length;col++) {
				int val=arr[row][col];
				Node node = current.children.get(val);
				if(node==null) {
					node=new Node();
					current.children.put(val,node);
					exists=false;
				}
				current=node;
			}
							
			current.endOfWord=true;
			if(exists==false) {
				Arrays.stream(arr[row]).forEach(e->{
					System.out.print(e);
					
				});
				System.out.println();
			}
			row++;
			
			
		}
		
	}

}
