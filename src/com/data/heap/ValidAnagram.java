package com.data.heap;

public class ValidAnagram {
	
	if(s == null && t== null)
        return true;
    
    if(s.length()!=t.length() || s==null || t==null)
        return false;
    
    int[] freq = new int[26];
    for(char c:s.toCharArray()){
        freq[c-'a']++;
    }
    
    for(char c:t.toCharArray()){
        freq[c-'a']--;
    }
    
    
    for(int i=0;i<26;i++){
        if(freq[i]!=0)
            return false;
    }
    
    return true;
    
}

}

public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}

