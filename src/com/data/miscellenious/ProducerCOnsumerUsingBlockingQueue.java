package com.data.miscellenious;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerCOnsumerUsingBlockingQueue {
	
	static class ProduceConsume{
		private BlockingQueue<Integer> q;
		public ProduceConsume(BlockingQueue<Integer> q) {
			this.q = q;
		}
		
		public synchronized void produce() {
			for(int i=0 ;i< 7; i++) {
				try {
					q.put(i);
					System.out.println("put:"+ i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public synchronized void consume() {
			for(int i=0; i< 7; i++) {
				System.out.println(q.poll());
			}
		}
	}
	
	public static void main(String args[]) {
		BlockingQueue<Integer> q= new LinkedBlockingQueue<>(6);
		ProduceConsume pc= new ProduceConsume(q);
		Thread t1 = new Thread(()-> pc.produce());
		Thread t2 = new Thread(()-> pc.consume());
		t1.start();
		t2.start();
	}

}
