package com.data.linkedList;

public class ReverseLinkedList2 {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
	       ListNode tail = head;
	       ListNode prev = null;
	       for(int i=1;i<m;i++){
	           prev=tail;
	           tail=tail.next;
	       }
	      ListNode conn = prev;
	      ListNode curr = tail;
	      for(int i=1;i<=n-m+1;i++){
	          ListNode next = curr.next;
	          curr.next = prev;
	          prev = curr;
	          curr = next;
	      }
	    if(conn!=null)//edge case [5] m=1, n=1;
	    conn.next = prev;
	        else
	            head = prev;//edge case [3,5] m=1, n=2;
	    tail.next = curr;
	    return head;
	    }

}
