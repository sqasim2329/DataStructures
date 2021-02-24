package com.data.interviewBit;

public class OnlinedStockSpan {
	
	class StockSpanner {
	    class Pair{
	        int first;
	        int second;
	        
	        public Pair(int first,int second){
	            this.first = first;
	            this.second = second;
	        }
	    }
	    Stack<Pair> stk;

	    public StockSpanner() {
	        stk = new Stack<>();    
	    }
	    
	    public int next(int price) {
	        int count = 0;
	        while(!stk.isEmpty() && stk.peek().first <= price)
	            count+=stk.pop().second;
	        stk.push(new Pair(price,count+1));
	        return count+1;
	    }
	}

}
