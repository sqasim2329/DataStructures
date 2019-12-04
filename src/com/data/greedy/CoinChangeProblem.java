package com.data.greedy;

import java.util.Stack;

public class CoinChangeProblem {
	
	public static void main(String args[]) {
		int denominations[] = {1,2,5,10,20,50,100,500,1000};
		int value = 2048;
//		findChange(denominations,value);
		Stack<Integer> s= new Stack<>();
		for(int i=0; i < denominations.length; i++) {
			s.push(denominations[i]);
		}
		findChange(s,value);
	}

	private static void findChange(Stack<Integer> s, int value) {
		while(!s.isEmpty() || value > 0) {
			int denom = s.pop();
			if(value-denom>denom) {
				value=value-denom;
				System.out.println(denom);
				s.push(denom);
			}else if(value >= denom) {
				value=value-denom;
				System.out.println(denom);
			}
		}
	}

	private static void findChange(int[] denominations, int value) {
		if(value==0) {
			return;
		}
		int den = findLargestDenominationLessThanValue(value, denominations);
		
		value = value - den;
		System.out.println(den);
		findChange(denominations,value);
		 
		
		
	}

	private static int findLargestDenominationLessThanValue(int value, int[] denominations) {
		int den = 0;
		for(int i=denominations.length-1; i >= 0; i--) {
			if(denominations[i]<=value) {
				den = denominations[i];
				break;
			}
		}
		return den;
		
	}

}
