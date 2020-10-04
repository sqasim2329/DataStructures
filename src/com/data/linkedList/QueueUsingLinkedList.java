package com.data.linkedList;

public class QueueUsingLinkedList {
	
	class MyQueue
	{
	    ListNode front, rear;
	    
	    
		void push(int a)
		{
	        if(front == null){
	        front = new ListNode(a);
	        rear = front;
	        }
	        else{
	        	ListNode n = new ListNode(a);
	        rear.next = n;
	        rear = rear.next;
	        }
		}
		
		int pop()
		{   
		    if(front == null)
		    return -1;
		    ListNode removedNode = front;
	        front = front.next;
	        return removedNode.val;
	        
		}
	}

}
