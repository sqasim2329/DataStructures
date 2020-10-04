package com.data.linkedList;
//edge cases [1] 1
public class RemoveNthNodeFromEndOfLinkedList {
	
public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        
       for(int i=1;i<=n && fast!=null;i++){
           if(fast.next == null){
               if(i==n){
                   head = head.next;
                   return head;
               }
           }
           fast = fast.next;
       }
        
        
        while(fast.next!=null){
            slow= slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }

}
//logic
//initially when f covers n spaces, s is at o .
// Now when f covers total space, then s is still n spaces behind f
//so if f is at end then s is n spaces behind n;