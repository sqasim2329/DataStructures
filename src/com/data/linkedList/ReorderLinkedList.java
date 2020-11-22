package com.data.linkedList;

public class ReorderLinkedList {
	
public void reorderList(ListNode head) {
        
        if(head == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode prev = null;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        ListNode first = head;
        ListNode second = prev;
        
        while(second.next!=null){
            ListNode ref = first.next;
            first.next = second;
            first =ref;
            
            ref = second.next;
            second.next = first;
            second = ref;
        }
        
        
    }

}
/***********
*
*		1. Find middle of the linkedlist
*		2. Reverse the elemenst starting from middle
*		3. Merge the two linkedList.
*		1->2->3
*		4->3-null--------------- check code line number 29
*
**/


