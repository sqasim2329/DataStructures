package com.data.google;

public class ShortestWordDistance2 {
	class WordDistance {
	    Map<String,List<Integer>> map = new HashMap<>();
	    public WordDistance(String[] words) {
	        addToMap(words);
	    }
	    
	    private void addToMap(String[] words){
	        for(int i=0;i<words.length;i++){
	            map.putIfAbsent(words[i],new ArrayList<>());
	            map.get(words[i]).add(i);
	        }
	    }
	    
	    public int shortest(String word1, String word2) {
	        List<Integer> ls = map.get(word1);
	        List<Integer> rs = map.get(word2);
	        int min = Integer.MAX_VALUE;
	        int i=0,j=0;
	        while(i < ls.size() && j < rs.size()){
	           min = Math.min(min,Math.abs(ls.get(i)-rs.get(j)));
	            if(ls.get(i) < rs.get(j))
	                i++;
	            else
	                j++;
	                
	        }
	        return min;
	    }
	}

	/**
	 * Your WordDistance object will be instantiated and called as such:
	 * WordDistance obj = new WordDistance(words);
	 * int param_1 = obj.shortest(word1,word2);
	 */

	// a -> 0,3
	// b-> 2    


}
