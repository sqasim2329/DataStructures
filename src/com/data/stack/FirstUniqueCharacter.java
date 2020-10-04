package com.data.stack;
//https://leetcode.com/problems/first-unique-character-in-a-string/submissions/
public class FirstUniqueCharacter {
	
public int firstUniqChar(String s) {
        
        int freq[] = new int[26];
        
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        
        for(char c:s.toCharArray()){
            if(freq[c-'a']==1){
                return s.indexOf(c);
            }
        }
        return -1;
    }

}
