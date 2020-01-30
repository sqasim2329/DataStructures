package Algos;

import java.util.ArrayList;
import java.util.List;

public class Stockbuyandsell {
	
	static class BuySell{
		int buy;
		int sell;
		//total-decoding-messages
	}
	
	public static void main(String args[]) {
		int arr[]= {100,180,260,310,40,535,695};
		int n=arr.length;
		int i=0;
		int count=0;
		List<BuySell> ls=new ArrayList<>();
		while(i<n-1) {
			while(i<n-1 && arr[i+1]<=arr[i]) i++;//findmin
			if(i==n-1)
				break;
			BuySell bs= new BuySell();
			bs.buy=i++;
			
			while(i<n && arr[i]>=arr[i-1])i++;//findMax
			bs.sell=i-1;
			count++;
			
			
		}
		
		
		
	}
	
//	max Profit in arr
//	 int min=Integer.MAX_VALUE;
//     int maxProfit=0;
//     int n=prices.length;
//     for(int i=0;i<n;i++){
//         if(prices[i]<min){
//             min=prices[i];
//         }else{
//             maxProfit=Math.max(maxProfit,prices[i]-min);
//         }
//     }
//     return maxProfit;
	
}

	