package com.data.mutithread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread {
	
	static class MyThread extends Thread{
		CountDownLatch cdl ;
		String name;
		public MyThread(CountDownLatch cdl, String name) {
			super(name);
			this.cdl = cdl;
			this.name = name;
		}
		
		@Override
		public void run() {
			if(name.equals("A")) {
				try {
					System.out.println("Thread A started");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cdl.countDown();
				System.out.println("Thread A completed");
			}else if(name.equals("B")){
				try {
					System.out.println("Thread B Started");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cdl.countDown();
				System.out.println("Thread B completed");
			}else {
				try {
					System.out.println("Thread C Started");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread C Completed");
			}
		}
		
		
		
		
		
	} 
	
	public static void main(String args[]) throws InterruptedException {
		CountDownLatch cdl = new CountDownLatch(2);
		MyThread a = new MyThread(cdl,"A");
		MyThread b = new MyThread(cdl,"B");
		MyThread c = new MyThread(cdl,"C");
		
		a.start();
		b.start();
		System.out.println("waitig for countDown");
		cdl.await();
		System.out.println("done countDown");
		c.start();
		
	}

}
