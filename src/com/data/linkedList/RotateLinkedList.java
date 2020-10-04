package com.data.linkedList;

public class RotateLinkedList {
	
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        if(k==0)
            return head;
        ListNode refNode = head;
        ListNode tail = head;
        ListNode newHead = null;
        int i=1;//becuase we are considering to start with index 1 and no index 0 sine it is linkedlist
        while(tail.next!=null){//if i ==1 then condition is tail.next for size of linkedlist
            i++;
            tail = tail.next;
        }
        int j = i-k%i;// find the mod of K and subtract from length 
        for(;j>1;j--){//j=1;j<n-k%n;j++
            refNode = refNode.next;
        }
        
        tail.next = head;
        newHead = refNode.next;
        refNode.next = null;
        return newHead;
    }

}
