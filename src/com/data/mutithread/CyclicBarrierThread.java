package com.data.mutithread;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

public class CyclicBarrierThread {
	
	static class MyThread implements Runnable{
		private CyclicBarrier cb ;
		private String name;
		private int waitTime;
		
		public MyThread(CyclicBarrier cb,String name, int waitTime) {
			this.cb = cb;
			this.name = name;
			this.waitTime = waitTime;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				System.out.println("Invoking thread:"+name+" "+Thread.currentThread().getName());
				Thread.currentThread().sleep(waitTime);
				System.out.println("Thread:"+name+"awoke");
				cb.await();
				System.out.println("Exiting");
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	static class MyAnotherThread implements Runnable{

		@Override
		public void run() {
			System.out.println("Cyclic task completed:"+Thread.currentThread().getName());
			
		}
		
	}
	
	public static void main(String args[]) throws InterruptedException {
		CyclicBarrier cb =  new CyclicBarrier(2,new MyAnotherThread());
		Thread t1 = new Thread(new MyThread(cb,"A",1000));
		Thread t2 = new Thread(new MyThread(cb,"B",5000));
		List<String> ls = new ArrayList<>();
		t1.start();
		t2.start();
		t1.join();
			
	}

}
