package com.data.mutithread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class BuildingH2O {
	
	class H2O {
	    
	    Semaphore semH;
	    Semaphore semO;
	    CyclicBarrier barrier;

	    public H2O() {
	        semH = new Semaphore(2);
	        semO = new Semaphore(1);
	        barrier = new CyclicBarrier(3);
	    }

	    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
	        try{
	        semH.acquire();
	        barrier.await();
	        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
	        releaseHydrogen.run();    
	        }catch(Exception e){
	            
	        }finally{
	          semH.release();  
	        }
			
	    }

	    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
	        try{
	            semO.acquire();
	            barrier.await();
	        // releaseOxygen.run() outputs "O". Do not change or remove this line.
			    releaseOxygen.run();    
	        }catch(Exception e){
	            
	        }finally{
	           semO.release(); 
	        }
	        
	    }
	}

}
