package com.data.linkedList;

public class MergeTwoSortedLinkedList {
	
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        
	        ListNode current = new ListNode();
	        ListNode head = current;
	        
	        while(l1!=null && l2!=null){
	            if(l1.val <= l2.val){
	                current.next = l1;
	                l1 = l1.next;
	            }else{
	                current.next = l2;
	                l2 = l2.next;
	            }
	            current=current.next;
	        }
	        
	        if(l1!=null)
	            current.next = l1;
	        else
	            current.next = l2;
	        
	        head = head.next;
	        return head;
	        
	    }
	 
	 //O(1) space keep head as the smaller of the first two nodes and  ref as the larger and keep comparing until 
	 // you see the tail.next.data > ref.data, so at this point move tail to ref and make a pointer to the next
	 class LinkedList
	 {
	     Node sortedMerge(Node headA, Node headB) {
	      Node head = null;
	      Node tail = null;
	      Node ref = null;
	      
	      if(headA==null && headB == null)
		      return null;
	      
	      if(headA == null)
	      return headB;
	      
	      if(headB == null)
	      return headA;
	      
	      
	      
	      if(headA.data < headB.data){
	          head = headA;
	          ref = headB; 
	      }else{
	          head = headB;
	          ref = headA;
	      }
	      tail = head;
	      
	      while(tail!=null && ref != null){
	          while(tail!=null && tail.next!= null && tail.next.data < ref.data)
	           tail = tail.next;
	           
	           Node next = tail.next;
	           tail.next = ref;
	           tail = ref;
	           ref = next;
	      }
	      
	      return head;
	    } 
	 }

}
