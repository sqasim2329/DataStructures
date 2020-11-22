package com.data.linkedList;

import java.util.Stack;

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
	 
	 public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
	        
	        
	        Stack<ListNode> stk1 = new Stack<>();
	        Stack<ListNode> stk2 = new Stack<>();
	        while(l1!=null){
	            stk1.push(l1);
	            l1 = l1.next;
	        }
	        
	        while(l2!=null){
	            stk2.push(l2);
	            l2=l2.next;
	        }
	        int carry = 0;
	        ListNode head = new ListNode(-1);
	        ListNode curr = head;
	        
	        while(!stk1.isEmpty()||!stk2.isEmpty()){
	            int x = stk1.isEmpty()?0:stk1.pop().val;
	            int y = stk2.isEmpty()?0:stk2.pop().val;
	            
	            int val = x+y+carry;
	            carry = val/10;
	            ListNode node = new ListNode(val%10);;
	            if(curr.next==null)
	            curr.next = node; 
	            else{
	                node.next = curr.next;// placing the new node before the next node
	                curr.next = node;
	            }
	            }
	        
	        if(carry > 0){
	            ListNode node = new ListNode(carry);
	            node.next = curr.next;
	            curr.next = node;
	        }
	        
	        return head.next;
	    }

}

//https://www.geeksforgeeks.org/subtract-two-numbers-represented-as-linked-lists/
