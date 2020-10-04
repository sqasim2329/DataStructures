package com.data.arrays;

public class IncreasingTripletSubsequenceContinuous {
	
	public static void main(String args[]) {
		int nums[] ={1,3,3,2,5};
		int m=3;
		int n= nums.length;
		int c=-1;
		int s=0;
		int e=0;
		boolean flag=false;
		
		while(s<=n-m) {
			e=s+m-1;
			flag=false;
			while(s<e) {//comparinf elem within window
				if(nums[s]<nums[s+1])
					s++;
				else {
					flag=true;
					break;
				}
			}
			if(flag)
				s=s+1;
			else {
				System.out.println("Exists");
				break;
			}
		}
		
	}

}
