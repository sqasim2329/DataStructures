package com.data.linkedList;

public class DetectTheStartOfCycle {
	
	 public ListNode detectCycle(ListNode head) {
	        ListNode fast = head;
	        ListNode slow = head;
	        while(fast!=null && slow!=null && fast.next!=null){
	            fast = fast.next.next;
	            slow = slow.next;
	            if(fast == slow){// until here it will let ius know that cycle exist but not neccessarily the start point
	               fast = head; 
	               while(fast!=slow){
	                   fast = fast.next;
	                   slow = slow.next;
	               }
	                return slow;
	            }
	            
	        }
	        return  null;
	    }
	 
	 
	 public ListNode detectCyle(ListNode fast,ListNode slow,ListNode head) {
		 if(fast==null || fast.next == null)
			 return null;
		 
		 if(fast == slow) {
			 fast = head; 
             while(fast!=slow){
                 fast = fast.next;
                 slow = slow.next;
             }
              return slow;
		 }
		 
		 return detectCyle(fast.next.next,slow.next,head);
		 
		 
		 
	 }

}


//it is always true that head and slow will be equal distant from the start point, hence we take teh fast
//pointer and make it go one step and slow point also until they meet