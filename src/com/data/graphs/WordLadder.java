package com.data.graphs;



public class WordLadder {
//	https://leetcode.com/problems/as-far-from-land-as-possible/	
	class Solution {
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        
	        Queue<String> q = new LinkedList<>();
	        Set<String> seen = new HashSet<>(wordList);
	        q.add(beginWord);
	        int distance =1;
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int j=0;j<size;j++){
	                String word = q.poll();
	                if(word.equals(endWord))
	                    return distance;
	                for(int i=0;i<word.length();i++){
	                    char tmp = word.charAt(i);
	                    char[] wordChar = word.toCharArray();
	                    for(char c='a';c<='z';c++){
	                        char chr = wordChar[i];
	                        wordChar[i] = c;
	                        String w = new String(wordChar);
	                        if(!seen.contains(w)) continue;
	                        seen.remove(w);
	                        q.add(w);
	                        wordChar[i] = chr;
	                    }
	                    wordChar[i]=tmp;
	                }
	                
	            }
	            distance++;
	        }
	        
	        return 0;
	        
	    }
	}


	 

}
