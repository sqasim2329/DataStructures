
package com.data.divideAndConquer;

public class NumerFactor {
//	use 1,3,4 to get 5
	public static void main(String args[]) {
		int number = 5;
		System.out.println(waysToGetN(number));
	}

	private static int waysToGetN(int number) {
		if(number < 0 ) {
			return 0;
		}
		if(number==0 || number==1)
			return 1;
		
		int x = waysToGetN(number-1);
		int y = waysToGetN(number-3);
		int z = waysToGetN(number-4);
		 return x+y+z;
	}
}
