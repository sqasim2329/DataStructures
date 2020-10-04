package com.data.greedy;

public class Bulbs {
	
	public static void main(String args[]) {
		int nums[]= {1,0,0,0,0};
		int switchCnt =0;
		for(int i=0;i<nums.length;i++) {
			
			if(switchCnt%2==0 && nums[i]==0) 
				switchCnt++;
			
			else if(switchCnt%2==1 && nums[i]==1)
				switchCnt++;
			
		}
		
		System.out.println(switchCnt);
		
	}

}


// pressing a switch twice will result in same value eg 1 --> 0--> 1
//if even and original value was 0 then  curr value will be same so switch ++ to turn on
// if odd and original value was 1 then  curr value will be 0 switch ++ to turn on;