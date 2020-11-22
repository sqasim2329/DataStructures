package com.data.dynamicProgramming;

public class DecodeWays {
	
public int numDecodings(String s) {
        
        int dp[]= new int[s.length()+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        for(int i=2;i<=s.length();i++){
            int oneDigit = Integer.valueOf(s.substring(i-1,i));
            int twoDigits = Integer.valueOf(s.substring(i-2,i));
            if(oneDigit>=1)
                dp[i]+=dp[i-1];
            
            if(twoDigits>=10 && twoDigits<=26){
                 dp[i]+=dp[i-2];
            }
        }
        
        return dp[s.length()];
        
    }

public int numDecodingsRecursive(String s) {
    
    return solve(s,0);
}
 
 private int solve(String s, int indx){
     if(indx == s.length())
         return 1;
     
     if(indx > s.length())
         return 0;
     
     Integer oneDigit = Integer.parseInt(s.substring(indx,indx+1));
     Integer twoDigit = indx<s.length()-1?Integer.parseInt(s.substring(indx,indx+2)):null;
     int x =0;
     int y =0;
     if(oneDigit > 0)
         x= solve(s,indx+1);
     if(twoDigit!=null && twoDigit>=10 && twoDigit<=26)
         y = solve(s,indx+2);
     
     return x+y;
 }
 
 public static void main(String args[]) {
	 String s = "111111111111111111111111111111111111111111111";
	 DecodeWays d = new DecodeWays();
	 System.out.println(d.numDecodingsRecursive(s));
	 
 }

}
