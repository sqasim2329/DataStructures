package com.data.mutithread;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
	
	static class MyThread implements Runnable{
		ReentrantLock re;
		String name;
		public MyThread(ReentrantLock re, String name) {
			this.re = re;
			this.name = name;
		}

		@Override
		public void run() {
			boolean done = false;
			while(!done) {
			if(!re.tryLock()) {
				System.out.println("Thread :"+name+" cannot acquire lock");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
			
			System.out.println("Thread :"+name+"is running");
			re.lock();
			System.out.println("Thread :"+name+"acquired lock");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			re.unlock();
			re.unlock();
			System.out.println("Thread :"+name+"releases lock");
			done = true;
			}
		}
	 }
		
	}
	
	public static void main(String args[]) {
		
		ReentrantLock re = new ReentrantLock(true);
		Thread t1 = new Thread(new MyThread(re,"A"));
		Thread t2 = new Thread(new MyThread(re,"B"));
		Thread t3 = new Thread(new MyThread(re,"C"));
		
		t1.start();
		t3.start();
		t2.start();
		
		
		
		
		
	}

}
