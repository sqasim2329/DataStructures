package com.data.heap;

public class BestTimeToBuySellStock {
	//1
	public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int min = prices[0];
        int maxProfit = 0;
        for(int i=0; i<prices.length;i++ ){
            min = Math.min(min,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-min);
        }
        return maxProfit;
        
    }
	//2
//	// 7 1 5 3 6 4
//    1 5
//        3 6
////1 2 3 4 5
// 1 2       
//   2 3
//     3  4
//        4  5
//        
	public int maxProfit2(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
            profit+=prices[i]-prices[i-1];
        }
        return profit;
    }
	//3
	 public int maxProfit3(int[] prices) {
	        Integer b1 = Integer.MAX_VALUE;
	        int p1 = 0;
	        Integer b2 = Integer.MAX_VALUE;
	        int p2 = 0;
	        for(int i=0;i<prices.length;i++){
	            b1 = Math.min(b1,prices[i]);
	            p1 = Math.max(p1,prices[i]-b1);
	            b2 = Math.min(b2,prices[i]-p1);
	            p2 = Math.max(p2,prices[i]-b2);
	        }
	        return p2;
	        
	    }
	 
	 
	 class Solution {
		    public int maxProfit(int k, int[] prices) {
		        
		        if(k==0 || prices.length==0)
		            return 0;
		        
		        int[] profits = new int[prices.length];
		        int max = 0;
		        if(k >= prices.length/2){
		            for(int i=1;i<prices.length;i++){
		                if(prices[i]>prices[i-1]){
		                   max += prices[i]-prices[i-1]; 
		                }
		            }
		        return max;    
		        }
		        
		        int b1 = Integer.MAX_VALUE;
		        int p1 =0;
		        for(int i=0;i<prices.length;i++){
		            b1 = Math.min(b1,prices[i]);
		            p1 = Math.max(p1,prices[i]-b1);
		            profits[i]= p1;
		        }
		        
		        for(int i=1;i<k;i++){
		            kTimes(prices,profits);
		        }
		        
		        for(int i:profits){
		          max = Math.max(i,max);
		        }
		        return max;
		    }
		    
		    private void kTimes(int[] prices,int[] profit){
		        int b2  = Integer.MAX_VALUE;
		        int p2  = 0;
		        for(int i=0;i<prices.length;i++){
		        b2 = Math.min(b2,prices[i]-profit[i]);
		        p2 = Math.max(p2,prices[i]-b2);   
		        profit[i] = p2;
		        }
		    }
		}


}
