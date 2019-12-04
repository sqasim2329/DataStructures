package com.data.divideAndConquer;

public class HouseTheif {
	
	public static void main(String args[]) {
		int arr[] = {6,7,1,30,2,4};
		System.out.println(getMaxStealth(arr,0));
	}

	private static int getMaxStealth(int[] arr, int index) {
		// TODO Auto-generated method stub
		if(index > arr.length-1) {
			return 0;
		}
		int currentHouseStealth = arr[index]+ getMaxStealth(arr,index+2);
		int skipCurrentHouseStealth = getMaxStealth(arr,index+1);
		return Math.max(currentHouseStealth, skipCurrentHouseStealth);
	}



}
