package com.data.divideAndConquer;

public class LongestPalindromicSubstring {
	
	public static void main(String args[]) {
		String s= "MkEAEkM";
//		System.out.println(findLCSOfString(s,0,s.length()-1));
		System.out.println(dp(s));
	}

	private static int findLPSOfString(String s, int i, int j) {
		
		if(i > j) {
			return 0;
		}
		
		if(i == j) {
			return 1;
		}
		int x = 0;
		if(s.charAt(i)==s.charAt(j)) {
			int remainingLength = j-i-1;
			if(remainingLength == findLPSOfString(s,i+1,j-1) )
			 x = remainingLength+2;
		}
		int y = findLPSOfString(s,i+1,j);
		int z = findLPSOfString(s,i,j-1);
		int max1 = Math.max(x, y);
		return Math.max(max1, z);
	}
	
	
		public String longestPalindrome(String s) {
	        int n= s.length();
	        if(n==0)
	            return s;
	        int max = Integer.MIN_VALUE;
	        int [][]dp = new int[n][n];
	        for(int i =0;i<n;i++){
	            dp[i][i]=1;
	            max = 1;
	        }
	        
	        
	        int start=0;
	        for(int i=0;i<n-1;i++){
	            if(s.charAt(i)==s.charAt(i+1)){
	                dp[i][i+1]=2;
	                max = 2;
	                start=i;
	            }
	        }
	        
	        for(int k=3;k<=n;k++){
	            for(int i=0;i<n-k+1;i++){
	                int j = i+k-1;
	                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1] == j-i-1){
	                    dp[i][j] = 2+dp[i+1][j-1];
	                }else{
	                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
	                }
	                if(max < dp[i][j]){
	                        max = dp[i][j];
	                        start =i;
	                    }
	            }
	        }
	        
	        int length = dp[0][n-1];
	        System.out.println(max);
	        System.out.println(start);
	        return s.substring(start,start==0?max:start+max);
	        
	        
	       
	    }
		
		public int countSubstrings(String s) {
	        
	        int n = s.length();
	        boolean [][]dp = new boolean[n][n];
	        int count =0;
	        for(int i=0;i<n;i++){
	            dp[i][i]=true;
	            count++;
	        }
	        
	        for(int i=0;i < n-1;i++){
	            if(s.charAt(i)==s.charAt(i+1))
	            {
	                dp[i][i+1]=true;
	                count++;
	            }
	        }
	        
	        for(int k=3;k<=n;k++){
	            for(int i=0;i<=n-k;i++){
	                int j=i+k-1;
	                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
	                    dp[i][j]=true;
	                    count++;
	                }
	            }
	        }
	        
	        return count;
	        
	    }
	}
	
	
	





