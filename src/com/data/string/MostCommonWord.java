package com.data.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MostCommonWord {
	

    public String mostCommonWord(String paragraph, String[] banned) {
        
        String normString = paragraph.replaceAll("[^a-zA-Z0-9]"," ").toLowerCase();
        
        String[] strArray = normString.split("\\s+");
        
        Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());
        Map<String,Integer> freq = new HashMap<>();
        String ans="";
        int max = Integer.MIN_VALUE;
        for(String str:strArray){
            if(!bannedSet.contains(str)){
                freq.put(str,freq.getOrDefault(str,0)+1);
                if(freq.get(str)>max){
                    max = freq.get(str);
                    ans = str;
                }
            }
        }
        return ans;   
    }

}
/********
 * 
 *   Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned. 
 * 
 * **********/
 