package com.data.linkedList;
class Node{
	public int val;
    public Node prev;
    public Node next;
    public Node child;
}
public class FlattenMultiuValuedLinkedList {
	
	class Solution {
	    public Node flatten(Node head) {
	        
	        Node curr = head;
	        while(curr!=null){
	            
	            if(curr.child == null)
	                curr = curr.next;
	            else{
	                Node child = curr.child;
	                while(child.next!=null)
	                    child = child.next;
	                child.next = curr.next;
	                if(child.next!=null) child.next.prev = child;
	                curr.next = curr.child;
	                curr.next.prev = curr;
	                curr.child = null;
	            }
	        }
	        return head;
	        
	    }
	}

    }

}

   
 