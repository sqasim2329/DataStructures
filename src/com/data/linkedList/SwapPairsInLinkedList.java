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
	 
	 public ListNode swapPairs(ListNode head) {
	        if(head == null || head.next == null)
	            return head;
	        ListNode dummy = new ListNode(-1);
	        ListNode prev = head.next;
	        while(head!=null && head.next!=null){
	            ListNode first = head;
	            ListNode second = head.next;
	            
	            dummy.next = first.next;
	            first.next = second.next;
	            second.next = first;
	            dummy = first;
	            head = first.next;
	        }
	        
	        return prev;
	        
	    }

}
