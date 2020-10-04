package com.data.linkedList;

import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
	
	
	    Node mergeKList(Node[]a,int N)
	    {
	        PriorityQueue<Node> q = new PriorityQueue<>((Node b,Node c)->Integer.compare(b.data,c.data));
	        for(Node n:a){
	            if(n!=null)
	            q.add(n);
	        }
	        Node head = new Node(-1);
	        Node tail = head;
	        while(!q.isEmpty()){
	            Node poped = q.poll();
	            if(poped.next!=null)
	                q.add(poped.next);
	            poped.next = null;
	            tail.next = poped;
	            tail = tail.next;
	        }
	        return head.next;
	        
	    }
	

}
