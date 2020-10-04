package com.data.linkedList;

public class SwapPairsInLinkedList {
	
	 public ListNode swapPairs(ListNode head) {
	        if(head==null || head.next==null)//since we will do next.next
	            return head;
	        
	        ListNode next = head.next;
	        head.next = swapPairs(next.next);
	        next.next = head;
	        return next;

	    }

}
