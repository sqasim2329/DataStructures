package com.data.miscellenious;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

public class DequeClass {
	
	Node front, rear;
	int size;
	
	public DequeClass() {
		front = rear = null;
		size = 0;
	}
	
	private void insertFront(int x) {
		
		Node newNode = new Node(x);
		if(this.front == null) {
			front = newNode;
		}else {
			newNode.next = front;
			front.prev = newNode;
			front = newNode; 
		}		
		size++;
	}
	
	private void insertRear(int x) {
		
		Node newNode = new Node(x);
		if(this.rear == null) {
			rear = newNode;
		}else {
			rear.next = newNode;
			newNode.prev = rear;
			rear = newNode;
		}
		size++;
	}
	
	private Node deleteFront() {
		
		if(front == null) {
			return null;
		}else {
			
			Node temp = front;
			front = front.next;
			front.prev =null;
			size--;
			return temp;
			
		}
	}
	
	
private Node deleteRear() {
		
		if(rear == null) {
			return null;
		}else {
			
			Node temp = rear;
			rear = rear.prev;
			rear.next =null;
			size--;
			return temp;
			
		}
	}



}
