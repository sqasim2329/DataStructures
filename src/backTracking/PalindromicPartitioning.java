package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
//O(n.2^n)  coulb be 2^N different subtrings
public class PalindromicPartitioning {
	
	 public List<List<String>> partition(String s) {
	        
	        List<List<String>> res = new ArrayList<>();
	        boolean [][]dp = new boolean[s.length()][s.length()];
	        List<String> ls = new ArrayList<>();
	        backTrack(res,ls,s,0);
	        return res;
	    }
	    
	    
	    private void backTrack(List<List<String>> res, List<String> ls,String s, int start){
	        
	        if(start >= s.length()){
	            res.add(new LinkedList<>(ls));
	            return;
	        }
	        
	        for(int end=start;end<s.length();end++){
	        	 if(dp[start][end] || isPalindrome(s,start,end)){
	                    dp[start][end] = true;
	                ls.add(s.substring(start,end+1));
	                backTrack(res,ls,s,end+1);
	                ls.remove(ls.size()-1);
	            }
	        }
	    }
	    
	    public boolean isPalindrome(String s, int low, int high){
	        while(low < high)
	         if(s.charAt(low++) != s.charAt(high--)) return false;
	        return true;
	} 
	    //count can be removed
	    public boolean canPermutePalindrome(String s) {
	        
	        if(s == null)
	            return true;
	        
	        int count=0;
	        Set<Character> set = new HashSet<>();
	        
	        for(char c:s.toCharArray())
	        {
	            if(set.contains(c)){
	                count++;
	                set.remove(c);
	            }else{
	                set.add(c);
	            }
	        }
	        
	        if(set.size()<=1){
	            return true;
	        }
	        return false;
	        
	    }
	    
	    
	    class Solution {
	        public int minCut(String s) {
	            int n=s.length();
	            int[][] dp =new int [n][n];
	            
	            for(int[] d:dp)
	                Arrays.fill(d,n+1);
	            
	            for(int i=0;i<n;i++)
	                dp[i][i]=0;
	            
	            for(int i=0;i<n-1;i++){
	                if(s.charAt(i)==s.charAt(i+1))
	                    dp[i][i+1]=0;
	                else
	                    dp[i][i+1]=1;
	            }
	            
	            for(int k=3;k<=n;k++){
	                for(int i=0;i<=n-k;i++){
	                    int j=i+k-1;
	                    if(isPalindrome(s,i,j))
	                        dp[i][j]=0;
	                        
	                    else{
	                        for(int c=i;c<j;c++){
	                            int curr=1+dp[i][c]+dp[c+1][j];
	                            dp[i][j]= Math.min(curr,dp[i][j]);
	                        }
	                    }
	                }
	            }
	            return dp[0][n-1];

	        }
	        
	        private boolean isPalindrome(String s, int i, int j){
	            while(i<j){
	                if(s.charAt(i++)!=s.charAt(j--))
	                    return false;
	            }
	            return true;
	        }
	    } 

	        

}
