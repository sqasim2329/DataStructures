package com.data.linkedList;

public class DelteElementMiddleofLinkedList {
	
	Node deleteMid(Node head) {
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }

}


//add 1 to a number represented as a linked list -- reverse linkedlist and add 1 to each and take the carry
