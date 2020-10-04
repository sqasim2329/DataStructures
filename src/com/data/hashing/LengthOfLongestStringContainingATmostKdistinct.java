package com.data.hashing;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestStringContainingATmostKdistinct {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length()==0 || s=="")
           return 0;
       int left =0;
       int minleft = 0;
       int len = 0;
       int right=0;
       int count =0;
       Map<Character,Integer> map = new HashMap<>();
       while(right < s.length()){
           map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
           if(map.get(s.charAt(right))==1)
               count++;
           right++;
           while(count > k){
               map.put(s.charAt(left),map.get(s.charAt(left))-1);
               if(map.get(s.charAt(left))==0)
                   count--;
               left++;
           }
           len = Math.max(len,right-left);
       }
       
       return len;
   }

}
