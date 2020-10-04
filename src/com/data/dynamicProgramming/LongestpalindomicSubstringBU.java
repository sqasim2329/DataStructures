package com.data.dynamicProgramming;

public class LongestpalindomicSubstringBU {
	
	public static void main(String args[]) {
		String s = "MADiAMAS";
		System.out.println(findLPSOfString(s));
	}

	private static int findLPSOfString(String s) {
		// TODO Auto-generated method stub
		int dp[][] = new int[s.length()][s.length()];
		for(int i = s.length()-1 ; i >= 0 ; i--) {
			for(int j = 0; j<= s.length()-1; j++) {
				if(i > j) {
					dp[i][j] = 0;
				}else if(i == j) {
					dp[i][j] = 1;
				}else {
					int x= 0;
					if(s.charAt(i)==s.charAt(j)) {
						int remaininglength = j-i-1;// end -start - 1
						if(remaininglength == dp[i+1][j-1]) {
							x = remaininglength + 2;
						}
					}
					
					int y = dp[i+1][j];
					int z= dp[i][j-1];
					dp[i][j] = Math.max(x, Math.max(y, z));
				}
			}
		}
				return dp[0][s.length()-1];
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

}
