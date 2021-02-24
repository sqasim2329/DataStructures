package com.data.google;

public class MovingAverage {
	
	/** Initialize your data structure here. */
    List<Integer> ls;
    int k=0;
    double sum = 0d;
    public MovingAverage(int size) {
        k = size;
        ls = new ArrayList<>();
    }
    
    public double next(int val) {
            ls.add(val);
            sum+=val;
        if(ls.size()>k){
            sum-= ls.get(0);
            ls.remove(0);
        }
        return sum/ls.size();
    }

}
