package com.data.dynamicProgramming;

import java.util.Arrays;

public class ShortestCommonSuperSequence {
	
	class Solution {
	    public String shortestCommonSupersequence(String str1, String str2) {
	        
	        String lcs = lcs(str1,str2);
	        int i=0,j=0;
	        StringBuilder sb = new StringBuilder();
	        for(char c:lcs.toCharArray()){
	            while(i< str1.length() && c!=str1.charAt(i))
	                sb.append(str1.charAt(i++));
	            while(j< str2.length() && c!=str2.charAt(j))
	                sb.append(str2.charAt(j++));
	            sb.append(c);
	            i++;
	            j++;
	        }
	        sb.append(str1.substring(i)).append(str2.substring(j));
	        return sb.toString();
	    }
	    
	    private String lcs(String str1,String str2){
	        String[][] dp = new String[str1.length()+1][str2.length()+1];
	        for(String[] str:dp){
	            Arrays.fill(str,"");
	        }
	        
	        for(int i=1;i<=str1.length();i++){
	            for(int j=1;j<=str2.length();j++){
	                if(str1.charAt(i-1)==str2.charAt(j-1)){
	                    dp[i][j]=dp[i-1][j-1]+str1.charAt(i-1);
	                }else{
	                    dp[i][j]=dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
	                }
	            }
	        }
	        return dp[str1.length()][str2.length()];
	        
	    }
	}

}
