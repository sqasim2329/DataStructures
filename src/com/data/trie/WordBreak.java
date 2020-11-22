package com.data.trie;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean a[] = new boolean[s.length()+1];
        HashSet<String> set = new HashSet<>(wordDict);
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i+1;j<=s.length();j++){
                if(j == s.length() && set.contains(s.substring(i)))
                    a[i]=true;
                 else if(a[j] && set.contains(s.substring(i,j))) 
                     a[i]|=a[j];
            }
        }
        
        return a[0];
        
        
    }

}
