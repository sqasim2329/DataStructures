package com.data.linkedList;

public class FindMiddleElementInLinkedList {
	public ListNode middleNode(ListNode head) {
        ListNode slw = head;
        ListNode fst = head;
        
        while(fst!=null && fst.next!=null){
            fst = fst.next.next;
            slw = slw.next;
        }
        
        return slw;
    }
	
	
	//recursive
	public ListNode middleNode(ListNode slow, ListNode fast) {
		if(fast!=null || fast.next!=null)
			return slow;
		
		slow= slow.next;
		fast = fast.next.next;
		return middleNode(slow,fast);
	}
}
