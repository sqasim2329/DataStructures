package com.data.linkedList;

import java.util.HashMap;
import java.util.Map;

//Delete the elements in an linked list whose sum is equal to zero O(n) time complexity and O(n) sapce
public class DeleteEleminLinkedListWHichSumtoZero {
	
	public ListNode solve(ListNode head) {

        
	       Map<Integer,ListNode> prefixMap = new HashMap<>();
	        ListNode curr = head;
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        prefixMap.put(0,dummy);
	        int sum =0;
	        while(curr!=null){
	            sum+=curr.val;
	            prefixMap.put(sum,curr);
	            curr = curr.next;
	        }
	        
	        sum = 0;
	        curr = dummy;// since this will failitate in case the entire list sums to 0
	        while(curr!=null){
	            sum += curr.val;
	            if(prefixMap.containsKey(sum))
	                curr.next = prefixMap.get(sum).next;
	            curr = curr.next;
	        }
	        
	        return dummy.next;
	    
	}

}

//    1 -> -2 -> 2 -> 2
//	0:0 1:2 -1:-2 3:2 
//	 
//  
