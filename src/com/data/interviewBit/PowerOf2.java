package com.data.interviewBit;

public class PowerOf2 {
	
	static boolean isPowerOfTwo (int x)
    {
      /* First x in the below expression is 
        for the case when x is 0 */
        return x!=0 && ((x&(x-1)) == 0);
         
    }
	
	//Math.ceil(Math.log(n)/Math.log(2))==Math.floor(Math.log(n)/Math.log(2));
	
//	0100 & 0011
//	00000

	
}
