package com.data.linkedList;
//dont use while loop dorectly check if for loop can be used
public class AddTwoNumbers {
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	        ListNode current = new ListNode(-1);
	        ListNode head = current;
	        int carry=0;
	        while(l1!=null || l2!=null){
	            int x = l1==null?0:l1.val;
	            int y = l2==null?0:l2.val;
	            
	            int sum = x+y+carry;
	            carry = sum/10;
	            current.next = new ListNode(sum%10);
	            current= current.next;
	            l1= l1!=null?l1.next:null;
	            l2= l2!=null?l2.next:null;
	        }
	        
	        if(carry > 0)
	            current.next = new ListNode(carry);
	        return head.next;
	        
	    }
	 
	 //recursive function , since we have to return head when we return
	 //back to first call in stack, so return a new node for each recursive
	 public ListNode addTwoNumbers(ListNode l1,ListNode l2,int carry) {
		 if(l1 == null && l2 == null && carry ==0)
			 return null;
		 if(carry > 0)
			 return new ListNode(carry);
		 
		 int x = l1==null?0:l1.val;
         int y = l2==null?0:l2.val;
         
         int sum = x+y+carry;
         carry = sum/10;
         ListNode newNode = new ListNode(sum%10);
         newNode.next = addTwoNumbers(l1!=null?l1.next:null,l2!=null?l2.next:null,carry);
         return newNode;
	 }

}
