package com.data.linkedin;

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
	///With binary search: Worst case time complexity would be O(N*logN) since you will have to run the binary search O(N) times.

//With two pointers scan (one at first head, other at second head, and keep incrementing the one which is smaller at each step and updating the distance), you can do that in O(N) in worst case.
	
	class WordDistance {
	    Map<String,TreeSet<Integer>> map = new HashMap<>();
	    public WordDistance(String[] words) {
	        addToMap(words);
	    }
	    
	    private void addToMap(String[] words){
	        for(int i=0;i<words.length;i++){
	            map.putIfAbsent(words[i],new TreeSet<>());
	            map.get(words[i]).add(i);
	        }
	    }
	    
	    public int shortest(String word1, String word2) {
	        TreeSet<Integer> ls = map.get(word1);
	        TreeSet<Integer> rs = map.get(word2);
	        int min = Integer.MAX_VALUE;
	        
	        for(int i:ls){
	            Integer floor = rs.floor(i);
	            Integer ceil = rs.ceiling(i);
	            if(floor!=null)
	                min = Math.min(min,i-floor);
	            if(ceil!=null)
	                min = Math.min(min,ceil-i);
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
	
	class Solution {
	    public int shortestWordDistance(String[] words, String word1, String word2) {
	        
	        List<Integer> word1Index = new ArrayList<>();
	        List<Integer> word2Index = new ArrayList<>();
	        for(int i=0;i<words.length;i++){
	            if(words[i].equals(word1))
	                word1Index.add(i);
	            if(words[i].equals(word2))
	                word2Index.add(i);
	        }
	        
	        int i = 0,j = 0;
	            int min = words.length;
	        while(i < word1Index.size() && j < word2Index.size()){
	            if(word1Index.get(i)-word2Index.get(j) !=0)
	            min = Math.min(min,Math.abs(word1Index.get(i)-word2Index.get(j)));
	            
	            if(word1Index.get(i) < word2Index.get(j))
	                i++;
	            else
	                j++;
	                
	        }
	        
	        return min;
	        
	    }
	}


}
