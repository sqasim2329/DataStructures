package com.data.arrays;

public class IncreasingTripletSubsequenceContinuous {
	
	public static void main1(String args[]) {
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
	
	public static void  main(String args[]) {
		int nums[]= {1,3,2,4,5};
		int n= nums.length;
		int m= 3;
		int j=0;
		int count =1;
		boolean flag = false;
		for(int i=0;i<=n-m;i++) {
			j=i+1;
			while( j<n && nums[j]> nums[j-1]) {
				count++;j++;
			}
			if(count >= m)
				flag=true;
			else {
				count=0;
				flag=false;
			}
		}
		System.out.println(flag);
	}

}
