package com.data.mutithread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
	
	static class BlockingQueueUsingLinkedList{
	private List<String> queue = new LinkedList<>();
	private int capacity;
	public BlockingQueueUsingLinkedList(int capacity) {
		this.capacity = capacity;
	}
	
	public synchronized void enqeue(String item) throws InterruptedException {
		if(queue.size() == capacity) {
			System.out.println(item+" is waiting to be added");
			wait();
			
		}
		if(queue.size() == 0) {
			notifyAll();
		}
		System.out.println(item+" is added");
		this.queue.add(item);
	}
	
	public synchronized String deqeue() throws InterruptedException{
		if(queue.size() == 0) {
			wait();
			System.out.println("nothing to remove");
		}
		if(queue.size() == capacity) {
			notifyAll();
		}
		return this.queue.remove(0);
	}
	
 }	
	
	
	public static void main(String args[]) throws InterruptedException {
		BlockingQueueUsingLinkedList q = new BlockingQueueUsingLinkedList(5);
			Thread t1 = new Thread(()->{
				
				
				try {
					q.enqeue("A");
					q.enqeue("B");
					q.enqeue("C");
					q.enqeue("D");
					q.enqeue("E");
					q.enqeue("F");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			});
			
			Thread t2 = new Thread(()->{
				try{
					q.deqeue();
				}catch(InterruptedException e) {
				  e.printStackTrace();	
				}
				});
			
			t1.start();
			Thread.sleep(500);
			t2.start();
			}
			
		
	}
	
		
	 


