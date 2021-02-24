package com.data.divideAndConquer;

public class SubSequncePatterbMatching {
		
	public int numMatchingSubseq(String S, String[] words) {
        
        List<StringBuilder>[] waiting = new ArrayList[26];
        
        for(int i=0;i<26;i++)
            waiting[i]=new ArrayList<>();
        
        for(String word:words){
            waiting[word.charAt(0)-'a'].add(new StringBuilder(word));
        }
        
        int count=0;
        for(char c:S.toCharArray()){
            if(waiting[c-'a'].size()>0){
                List<StringBuilder> advance = waiting[c-'a'];
                waiting[c-'a'] = new ArrayList<>();
                for(StringBuilder sb:advance){
                    sb.deleteCharAt(0);
                    if(sb.length()==0)
                        count++;
                    else
                        waiting[sb.charAt(0)-'a'].add(sb);
                }
                
            }
        }
        return count;
    }
	
	    
	    public boolean isSubsequence(String s, String t) {
	        
	        if(s.length()>t.length())
	            return false;
	        
	       int i=0;
	       int j=0;
	        
	        while(i<s.length() && j < t.length()){
	            if(s.charAt(i)==t.charAt(j))
	            {
	                i++;
	            }
	            j++;
	        }
	        
	        return i==s.length();
	    }

}
