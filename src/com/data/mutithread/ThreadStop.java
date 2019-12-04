package com.data.mutithread;

public class ThreadStop {
	
	
	
	static class MyThread extends Thread{
		private volatile String flag;
		
		public MyThread(String flag) {
			this.flag = flag;
		}
		public void run() {
			while(flag.equals("A")) {
				System.out.println("flag"+flag);
			}
			System.out.println("flag"+flag);
		}
	}
	
	public static void main(String args[]) {
		 
		MyThread t1= new MyThread("A");
		MyThread t2= new MyThread("B");
		t1.start();
		t2.start();
	}

}
