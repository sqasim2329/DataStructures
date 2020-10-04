package com.data.linkedList;

public class RemoveLoopfromCyleInLinkedList {
	
	public ListNode removeCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && slow!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
               fast = head; 
               while(fast.next!=slow.next){
                   fast = fast.next;
                   slow = slow.next;
               }
                slow.next = null;
            }
            
        }
        return  head;
    }

}
