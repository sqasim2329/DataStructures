package com.data.linkedList;

public class SplitIntoEqualParts {
	

	public ListNode[] splitListToParts(ListNode head, int k) {
	        int N=0;
	        ListNode ls[] = new ListNode[k];
	        ListNode curr = head;
	        while(curr!=null){
	            curr= curr.next;
	            N++;
	        }
	        int size = N/k;// give the min size that each index in array should have
	        int extra = N%k;// extra size that arrays must have from index=0
	        curr = head;
	        for(int i=0; i<k && head!=null;i++){
	            ls[i]=head;
	            curr =head;
	            int incre = extra >0?1:0;
	            ListNode prev = null;
	            for(int j=0;j<(size+incre);j++){
	                prev = curr;
	                curr = curr.next;
	            }
	            head = curr;
	            prev.next = null;
	            extra--;
	        }
	        
	        return ls;
	    }
        
    }


