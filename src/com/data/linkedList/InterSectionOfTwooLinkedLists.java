package com.data.linkedList;

public class InterSectionOfTwooLinkedLists {
	
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        ListNode left = headA;
	        ListNode right = headB;
	        
	        while(left!=right){
	            left = left == null ? headB:left.next;//once smaller one reaches null, small is assigned to head of big list
	            right = right == null ? headA:right.next;// once big one reaches null, big is assigned to head of small list
	        }
	        return left;
	    }

}
