package com.data.linkedList;

import java.util.HashMap;
import java.util.Map;

class LNode{
	int val;
	LNode next;
	LNode random;
	public LNode(int val) {
		this.val=val;
	}
}
//O(1) space and O(3N) time complexity
public class CloneLinkedListWithRandomAndNextPointer {
	
	public LNode clone(LNode head) {
		LNode curr = head;
		while(curr!=null) {
			LNode node = new LNode(curr.val);
			node.next = curr.next;
			curr.next = node;	
		}
		curr = head;
		LNode copy = curr.next;
		while(curr!=null) {
			if(curr.next!=null) {
				curr.next.random =  curr.random!=null?curr.random.next:curr.random;
			}
			curr =  curr.next!=null?curr.next.next:curr.next;
			
		}
		
		curr=head;
		copy= curr.next;
		LNode newHead = copy;
		while(curr!=null) {
			curr =  curr.next!=null?curr.next.next:curr.next;
			copy =  copy.next!=null?copy.next.next:copy.next;
			curr = curr.next;
			copy = copy.next;
		}
		return newHead;
	}
	
	//O(N) space and O(2N) time complexity
	public LNode cloneWithHashMap(LNode head) {
		Map<LNode,LNode> copyMap= new HashMap<>();
		LNode curr = head;
		while(curr!=null) {
			LNode node = new LNode(curr.val);
			copyMap.put(curr,node);	
			curr = curr.next;
		}
		curr = head;
		while(curr!=null) {
			LNode copy = copyMap.get(curr);
			copy.next = copyMap.get(curr.next);
			copy.random = copyMap.get(curr.random);
			curr = curr.next;
		}
		return copyMap.get(head);
		
	}

}
