package com.data.linkedList;

public class StackUsingLinkedList {
	
	class MyStack {

	    // Note that top is by default null
	    // in Java
	    ListNode top;
	    

	    void push(int a) {
	        if(top == null){
	            top = new ListNode(a);
	        }
	        else{
	        	ListNode node = new ListNode(a);
	            node.next = top;
	            top = node;
	        }
	    }
	    int pop() {
	       if(top == null)
	       return -1;
	       else{
	           int val = top.val;
	           top = top.next;
	           return val;
	       }
	    }
	}

}
