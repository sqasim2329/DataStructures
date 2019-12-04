package com.data.mutithread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ProducerConsumer {
	
	static class ProduceConsume{
		List<Integer> buffer = new LinkedList<>();
		int capacity =2; 
		static int count=10;
		static int i=0;
		
		private void produce() throws InterruptedException {
			synchronized(this) {
			while(i++ <= 10) {
			while(buffer.size() == capacity) {
				wait();
				System.out.println("producer thread waiting");
				
			}
			buffer.add(1);
			System.out.println("buffer produce");
			notify();
			
			}
			}
		}
		
		private  void consume() throws InterruptedException {
			synchronized(this) {
			while(i++ <= 10) {
			while(buffer.size() == 0) {
				wait();
				System.out.println("consumer thread waiting");
			}
			buffer.remove(0);
			System.out.println("buffer consume");
			notify();
			
			
			}
			
		}
	}
	}		
	
	public static void main(String args[]) throws InterruptedException {
		ProduceConsume pc = new ProduceConsume();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		FutureTask fi= new FutureTask(new Callable() {
			public Integer call() {
				return 1;
			}
		});
		Thread c= new Thread(fi);
		c.start();
		c.join();
		try {
			System.out.println(fi.get());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
