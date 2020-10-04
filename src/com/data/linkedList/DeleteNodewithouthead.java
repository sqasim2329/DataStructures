package com.data.linkedList;

public class DeleteNodewithouthead {
	
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
/*******
 * 
 * 
 *  if allowed to manuplicate the linkedlist it is possible if not no
 *  
 * 
 */
