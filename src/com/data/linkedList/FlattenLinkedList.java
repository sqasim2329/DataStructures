package com.data.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
// this does in O(Constant space), but need to check without space
public class FlattenLinkedList {
	
	Node flatten(Node root)
    {
        
	    PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>(){
	        public int compare(Node a, Node b){
	            return Integer.compare(a.data,b.data);
	        }
	    });
	    while(root!=null){
	        q.add(root);
	        root=root.next;
	    }
	    
	    Node head = new Node(-1);
	    Node curr = head;
	    while(!q.isEmpty()){
	        
	        Node popped = q.poll();
	        System.out.println(popped.data);
	        curr.next = popped;
	        if(popped.bottom!=null)
	        q.add(popped.bottom);
	        curr.bottom = null;
	        curr = curr.next;
	    }
	    
	    return head.next;}
	
	public static void main(String args[]) {
		Node node = new Node(5);
		node.next = new Node(10);
		node.bottom = new Node(7);
		node.bottom.bottom = new Node(8);
		node.bottom.bottom.bottom = new Node(30);
		node.next.bottom = new Node(20);
		FlattenLinkedList f=new FlattenLinkedList();
		f.flatten(node);
	}

}
