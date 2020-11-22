package com.data.mutithread;

import java.util.concurrent.*;

public class SemaphoreAsLocks {
	
	static class Shared{
		static int count = 0;
	}
	
	static class SemThread extends Thread{
		Semaphore sem;
		String name;
		
		SemThread(Semaphore sem, String name){
		this.name = name;
		this.sem = sem;
		}
		
		@Override
		public void run() {				
				try {
					sem.acquire();
					System.out.println(name +" acquires lock");
					for(int i=0; i< 5; i++) {
						Shared.count++;
						System.out.println(Shared.count);
						Thread.sleep(10);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sem.release();
				System.out.println(name+" release lock");
			}
			
		}
		
	
	
	public static void main(String args[]) throws InterruptedException {
		Semaphore sem = new Semaphore(2);
		
		SemThread t1 = new SemThread(sem,"A");
		SemThread t2 = new SemThread(sem,"B");
		
		t1.start();
		
		t2.start();
		
	}

}
