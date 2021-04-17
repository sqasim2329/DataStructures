package com.data.mutithread;

public class BoundedThreadSafeBlockingQueue {
	
	import java.util.concurrent.locks.ReentrantLock; 
	import java.util.concurrent.locks.Condition; 

	class BoundedBlockingQueue {
	    
	    private ReentrantLock lock = new ReentrantLock();
	    private Condition fullCond = lock.newCondition();
	    private Condition emptyCond = lock.newCondition();
	    private int[] queue;
	    private int head;
	    private int tail;
	    private int size;
	    public BoundedBlockingQueue(int capacity) {
	        
	        queue = new int[capacity];
	        head = 0;
	        tail = 0;
	        size = 0;
	    }
	    
	    public void enqueue(int element) throws InterruptedException {
	        lock.lock();
	        try{
	            while(size == queue.length)
	                fullCond.await();// to avoid spurious wakeup of threads , put in while loop;
	            
	            queue[tail++]=element;
	            tail = tail % queue.length;
	            size++;
	            emptyCond.signal();
	        }
	        finally{
	            lock.unlock();
	            }
	        }
	    
	    public int dequeue() throws InterruptedException {
	        lock.lock();
	        try{
	            while(size == 0)
	                emptyCond.await();
	            
	            int ele = queue[head++];
	            head = head % queue.length;
	            size--;
	            fullCond.signal();
	            return ele;
	        }
	        finally{
	            lock.unlock();
	        }
	    }
	    
	    public int size() {
	        return this.size;
	    }
	}

}
