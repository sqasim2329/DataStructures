package Algos;

import java.util.ArrayList;
import java.util.List;

public class Stockbuyandsell {
	
	static class BuySell{
		int buy;
		int sell;
		//total-decoding-messages
	}
	//find multiple time
	public static void main(String args[]) {
		int prices[]= {100,180,260,310,40,535,695};
		int n=price.length;
		int i=0;
		int count=0;
		List<BuySell> ls=new ArrayList<>();
		while(i<n-1) {
			int i = 0;
	        int valley = prices[0];
	        int peak = prices[0];
	        int maxprofit = 0;
	        while (i < prices.length - 1) {
	            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
	                i++;
	            valley = prices[i];
	            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
	                i++;
	            peak = prices[i];
	            maxprofit += peak - valley;
	        }
	        return maxprofit;
	    }
		}
		
		ls.forEach(System.out::println);
		
	}
	//find once
	public static void main(String args[]) {
		int prices[]= {};
		int minPrice = Integer.MAX_VALUE;
		int maxProfit= 0;
		for(int i=0;i<prices.length;i++) {
			if(prices[i] < minPrice)
				minPrice = prices[i];
			else if(prices[i]-minPrice > maxProfit) {
				maxProfit = prices[i]-minPrice;
			}
				
		}
		return maxProfit;
	}
	

	
}

	