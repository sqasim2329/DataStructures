package com.data.google.microsoft;

import java.util.Arrays;
import java.util.Collections;

public class MinimumNumberOfStepsToMakePilesEqualHeight {
	
	public static void main(String args[]) {
		Integer[] piles= {1, 1, 2, 2, 2, 3, 3, 3, 4, 4};
		if(piles.length <= 1)
		{
			System.out.println(0);
			return;
		}
		Arrays.sort(piles,Collections.reverseOrder());
		int res = 0;
		for(int i=1;i<piles.length;i++) {
			if(piles[i]!=piles[i-1]) {
				res+=i;
			}
		}
		System.out.println(res);
	}

}
/*4 ,4 ,3 ,3 , 3 , 2 , 2 , 2 , 1 , 1
*
*3 ,3 ,3 ,3 , 3 , 2 , 2 , 2 , 1 , 1   here to convert 4 to 3 two 4's to be reduced hence 2 steps
*
*2 ,2 ,2 ,2 , 2 , 2 , 2 , 2 , 1 , 1   here to convert 3 to 2 five 3's to be reduced hence 5+2 steps
*
*1 ,1 ,1 ,1 , 1 , 1 , 1 , 1 , 1 , 1   here to convert 2 to 1 8 2's to be redcued hence 5+2+8 steps
* 
*/
