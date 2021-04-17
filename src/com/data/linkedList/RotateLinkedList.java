package com.data.linkedList;

public class RotateLinkedList {
	
	public ListNode rotateRight(ListNode head, int k) {
		 if(head==null|| k==0 || head.next==null)
	            return head;
	        
	        int n =1;
	        ListNode curr = head;
	        while(curr.next!=null){
	            n++;
	            curr = curr.next;
	        }
	        
	        ListNode tail = curr;
	        ListNode newHead = null;
	        curr = head;
	        int size = n-k%n;
	        for(int i=0;i<size-1;i++){
	            curr=curr.next;
	        }
	        tail.next = head;
	        newHead = curr.next;
	        curr.next = null;
	        return newHead;
    }
	
	class Solution {
	    public void rotate(int[] nums, int k) {
	        
	        int n = nums.length-1;
	        k = k%nums.length;
	        reverse(0,n,nums);
	        reverse(0,k-1,nums);
	        reverse(k,n,nums);
	    }
	    
	    private void reverse(int l, int r, int[] nums){
	        while(l<r){
	            int tmp= nums[l];
	            nums[l] = nums[r];
	            nums[r] = tmp;
	            r--;
	            l++;
	        }
	    }
	}

}


// n=0 while(curr!=null), n=1 while(curr.next!=null) for total node calculation