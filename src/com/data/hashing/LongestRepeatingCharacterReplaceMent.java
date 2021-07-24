package com.data.hashing;

public class LongestRepeatingCharacterReplaceMent {
	
	class Solution {
    public int characterReplacement(String s, int k) {
        
        int l =0;
        int r =0;
        int[] freq = new int[26];
        int maxCount = 0;
        int maxSize = 0;
        while(r < s.length()){
            freq[s.charAt(r)-'A']++;
            maxCount= Math.max(maxCount,freq[s.charAt(r)-'A']);
            r++;
            while(r-l-maxCount > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            maxSize = Math.max(maxSize,r-l);
            
        }
        return maxSize;
        
    }
}
}

class Solution {
    public int longestOnes(int[] A, int K) {
        int l=0;
        int r=0;
        int ones = 0;
        int zeroes = 0;
        int max = 0;
        while( r < A.length){
            if(A[r] == 1)
                ones++;
            else
                zeroes++;
            r++;
            while(zeroes > K){
                if(A[l]==1)
                    ones--;
                else
                    zeroes--;
                l++;
            }
            max = Math.max(max,r-l);
        }
        
        return max;
        
        
        
    }
}

            
            
