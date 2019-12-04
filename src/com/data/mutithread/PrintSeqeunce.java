package com.data.mutithread;

import java.util.concurrent.Semaphore;

public class PrintSeqeunce {
	
	static class MyThread1 implements Runnable{
		Semaphore A;
		Semaphore B;
		private int x,y;
		
		public MyThread1( Semaphore a, Semaphore b, int i , int j) {
			super();
			A = a;
			B = b;
			this.x=i;
			this.y=j;
		}

		@Override
		public void run() {
			try {
				
				for(int i=x;i<=y;i=i+3) {
					A.acquire();
					System.out.println(Thread.currentThread().getId()+": "+i);
					B.release();	
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	static class MyThread2 implements Runnable{
		Semaphore A;
		Semaphore B;
		
		public MyThread2( Semaphore a, Semaphore b) {
			super();
			A = a;
			B = b;
		}

		@Override
		public void run() {
			try {
				
				for(int i=1;i<=49;i=i+3) {
					A.acquire();
					System.out.println("T2: "+i);
					B.release();	
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	static class MyThread3 implements Runnable{
		Semaphore A;
		Semaphore B;
		
		public MyThread3( Semaphore a, Semaphore b) {
			super();
			A = a;
			B = b;
		}

		@Override
		public void run() {
			try {
				
				for(int i=2;i<=48;i=i+3) {
					A.acquire();
					System.out.println("T3: "+i);
					B.release();	
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public static void main(String args[]) {
		Semaphore a = new Semaphore(1);
		Semaphore b = new Semaphore(0);
		Semaphore c = new Semaphore(0);
		Thread t1 = new Thread(new MyThread1(a,b,0,50));
		Thread t2 = new Thread(new MyThread1(b,c,1,49));
		Thread t3 = new Thread(new MyThread1(c,a,2,48));
//		Thread t2 = new Thread(new MyThread2(b,c));
//		Thread t3 = new Thread(new MyThread3(c,a));
		
		t1.start();
		t2.start();
		t3.start();
		
	}



}
