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
	 

}
