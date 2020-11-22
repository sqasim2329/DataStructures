package com.data.greedy;

import java.util.Stack;

public class CoinChangeProblem {
	
	public static void main(String args[]) {
		int denominations[] = {1,2,5,10,20,50,100,500,1000};
		int value = 2048;
		findChange(denominations,value);
		
	}

	private static void findChange(int[] denominations, int value) {
		int i =0;
		int n = denominations.length;
		while(value > 0 || i<denominations.length) {
			if(value >= denominations[n-1-i]){
				value -= denominations[n-1-i];
				System.out.println(denominations[n-1-i]);
			}else {
				i++;
			}
		}
	}

	

}
