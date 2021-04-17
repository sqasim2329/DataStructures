package com.data.google;

public class MovingAverage {
	
	class MovingAverage {

	    /** Initialize your data structure here. */
	    Queue<Integer> q;
	    int k=0;
	    double sum = 0d;
	    public MovingAverage(int size) {
	        k = size;
	        q = new LinkedList<>();
	    }
	    
	    public double next(int val) {
	            q.add(val);
	            sum+=val;
	        
	           if(q.size()>k)
	            sum-= q.poll();
	        return sum/q.size();
	    }
	}

	/**
	 * Your MovingAverage object will be instantiated and called as such:
	 * MovingAverage obj = new MovingAverage(size);
	 * double param_1 = obj.next(val);
	 */


	    

}
