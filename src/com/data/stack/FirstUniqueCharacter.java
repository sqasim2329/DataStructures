package com.data.stack;
//https://leetcode.com/problems/first-unique-character-in-a-string/submissions/
public class FirstUniqueCharacter {
	
public int firstUniqChar(String s) {
        
        int freq[] = new int[26];
        
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }

}
