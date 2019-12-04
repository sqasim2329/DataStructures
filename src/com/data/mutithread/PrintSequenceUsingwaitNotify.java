package com.data.mutithread;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintSequenceUsingwaitNotify {
	
	 static class PrintSequenceRunnable implements Runnable{
		public int PRINT_NUMBERS_UPTO=10;
		static int  number=1;
		int remainder;
		static Object lock=new Object();
	 
		PrintSequenceRunnable(int remainder)
		{
			this.remainder=remainder;
		}
	 
		@Override
		public void run() {
			while (number < PRINT_NUMBERS_UPTO-1) {
				synchronized (lock) {
					while (number % 3 != remainder) { // wait for numbers other than remainder
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName() + " " + number);
					number++;
					lock.notifyAll();
				}
			}
		}
	}

	
	public static void main(String args[]) {
		Thread t1 = new Thread(new PrintSequenceRunnable(1));
		Thread t2 = new Thread(new PrintSequenceRunnable(2));
		Thread t3 = new Thread(new PrintSequenceRunnable(0));
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
