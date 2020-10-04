 package com.data.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
	
	 Queue<Integer> q1 = new LinkedList<Integer>();
	 Queue<Integer> q2 = new LinkedList<Integer>();
	 
	 private void addToStack(int x) {
		 while(!q1.isEmpty()) {
			 int val = q1.poll();
			 q2.add(val);
		 }
		 q1.add(x);
		 while(!q2.isEmpty()) {
			 q1.add(q2.poll());
		 }
	 }
	 
	 private int removeFromStack() {
		
		 return q1.poll();
	 }
	 
	 public static void main(String args[]) {
		 StackUsingQueues stk = new StackUsingQueues();
		 stk.addToStack(2);
		 stk.addToStack(3);
		 System.out.println(stk.removeFromStack());
		 stk.addToStack(1);
		 System.out.println(stk.removeFromStack());
		 System.out.println(stk.removeFromStack());
	 }
	 //using one queue
	 private void push(int ele) {
		 q1.add(ele);
		 int size = q1.size();
		 while(size > 1) {
			 q1.add(q1.remove());// moving elem at front to back except last ele
			 size--;
		 }
	 }
	 
	 private int poll() {
		 return q1.poll();
	 }
	 
	 private int peek() {
		return q1.peek();
	 }
	 
	 private boolean isEmpty() {
		return q1.isEmpty();
	 }
	 

}
