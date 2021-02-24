package com.data.divideAndConquer;

public class LCSOfTwoStrings {
	
	
	public static void main(String args[]) {
		String s1 =  "elephant";
		String s2 = "eretpat";
		StringBuilder sb = new StringBuilder("");
		System.out.println(findLCSofTheStrings(s1,s2,0,0,sb));
		System.out.println(sb.toString());
	}

	private static int findLCSofTheStrings(String s1, String s2, int i, int j,StringBuilder sb) {
		// TODO Auto-generated method stub
		
		if(i >= s1.length() || j >=s2.length() )
			return 0;
		int x = 0;
		if(s1.charAt(i) == s2.charAt(j))
		{	
			x =1 + findLCSofTheStrings(s1,s2,i+1,j+1,sb);
		}
		
		int y = findLCSofTheStrings(s1,s2,i+1,j,sb);
		int z = findLCSofTheStrings(s1,s2,i,j+1,sb);
		    
		int max1 = Math.max(x, y);
		return Math.max(max1, z);
		
	}
	
	//dp[0][0] equal to 0 not 1 else will cause trouble in calculation
public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<=text1.length();i++)
            dp[i][0]=0;
            
        for(int i=0;i<=text2.length();i++)
            dp[0][i]=0;
        
        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                dp[i][j] = 1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                
            }
        }
        
        return dp[text1.length()][text2.length()];
        
        
    }

//Longest Repeating Subsequence

public int longestRepeatingSubsequence(String text1, String text1) {
    
    int[][] dp = new int[text1.length()+1][text1.length()+1];
    for(int i=0;i<=text1.length();i++)
        dp[i][0]=0;
        
    for(int i=0;i<=text1.length();i++)
        dp[0][i]=0;
    
    for(int i=1;i<=text1.length();i++){
        for(int j=1;j<=text1.length();j++){
            if(text1.charAt(i-1) == text1.charAt(j-1) && i!=j)
            dp[i][j] = 1+dp[i-1][j-1];
            else{
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
            
        }
    }
    
    return dp[text1.length()][text1.length()];
    
    
}


}
