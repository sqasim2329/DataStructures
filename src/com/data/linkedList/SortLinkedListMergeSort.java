package com.data.linkedList;

public class SortLinkedListMergeSort {
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
	    public ListNode sortList(ListNode head) {
	        
	        return mergeSort(head);
	        
	        
	    }
	    
	    private ListNode mergeSort(ListNode head){
	        if(head == null || head.next==null)
	            return head;
	        
	        ListNode mid = getMid(head);
	        ListNode left = mergeSort(head);
	        ListNode right = mergeSort(mid);
	        return merge(left,right);
	        
	    }
	    
	    private ListNode getMid(ListNode head){
	        ListNode curr = head;
	        ListNode fast = curr;
	        ListNode slow = curr;
	        ListNode prev = null;
	        while(fast!=null && fast.next!=null){
	            prev=slow;
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        prev.next = null;
	        return slow;
	    }
	    
	    private ListNode merge(ListNode left, ListNode right){
	        ListNode curr = new ListNode(-1);
	        ListNode head = curr;
	        while(left!=null && right!=null){
	            if(left.val<=right.val){
	                curr.next = left;
	                left = left.next;
	            }else{
	                curr.next = right;
	                right = right.next;
	            }
	            curr = curr.next;
	        }
	        
	        if(left!=null)
	            curr.next = left;
	        else
	            curr.next = right;
	        
	        return head.next;
	    }
	}

}
