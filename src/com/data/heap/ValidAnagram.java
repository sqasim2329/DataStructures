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
