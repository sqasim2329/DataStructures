package com.data.google;

public class MaxAbsoluteValueOFExpression {
	
	public int maxAbsValExpr(int[] arr1, int[] arr2) {
	    int max1 = Integer.MIN_VALUE;
	    int max2 = Integer.MIN_VALUE;
	    int max3 = Integer.MIN_VALUE;
	    int max4 = Integer.MIN_VALUE;
	    int min1 = Integer.MAX_VALUE;
	    int min2 = Integer.MAX_VALUE;
	    int min3 = Integer.MAX_VALUE;
	    int min4 = Integer.MAX_VALUE;
	    int n = arr1.length;
	    for (int i = 0; i < n; i++){
	        // 1st scenario arr1[i] + arr2[i] + i
	        max1 = Integer.max(arr1[i]+arr2[i]+i, max1);
	        min1 = Integer.min(arr1[i]+arr2[i]+i, min1);
	        // 2nd scenario arr1[i] + arr2[i] - i
	        max2 = Integer.max(arr1[i] + arr2[i] - i, max2);
	        min2 = Integer.min(arr1[i] + arr2[i] - i, min2);
	        // 3rd scenario arr1[i] - arr2[i] - i
	        max3 = Integer.max(arr1[i] - arr2[i] - i, max3);
	        min3 = Integer.min(arr1[i] - arr2[i] - i, min3);
	        // 4th scenario arr1[i] - arr2[i] + i
	        max4 = Integer.max(arr1[i] - arr2[i] + i, max4);
	        min4 = Integer.min(arr1[i] - arr2[i] + i, min4);
	    }
	    int diff1 = max1 - min1;
	    int diff2 = max2 - min2;
	    int diff3 = max3 - min3;
	    int diff4 = max4 - min4;
	    return Integer.max(Integer.max(diff1,diff2),Integer.max(diff3,diff4));
	    }

}
