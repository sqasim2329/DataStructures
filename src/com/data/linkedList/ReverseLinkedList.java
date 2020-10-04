package com.data.linkedList;

public class ReverseLinkedList {
	
	 public ListNode reverseList(ListNode head) {
	        ListNode tmp = null;
	        while(head!=null){
	            ListNode pt = head.next;
	            head.next = tmp;
	            tmp =head;
	            head = pt;
	        }
	        return tmp;
	 }
	 
	 public ListNode reverseListRecursively(ListNode head) {
	       ListNode tmp = null;
	       return reverse(head,tmp);
	        
	    }
	    
	    private ListNode reverse(ListNode head,ListNode tmp){
	        if(head == null)
	            return tmp;
	        ListNode pt = head.next;
	        head.next = tmp;
	        tmp =head;
	        head = pt;
	        return reverse(head,tmp);
	    }
	        

}
