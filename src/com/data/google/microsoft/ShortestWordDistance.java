package com.data.google.microsoft;

public class ShortestWordDistance {
	
	public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Integer i1 = null;
        Integer i2 = null;
        int min = wordsDict.length;
        for(int i=0;i<wordsDict.length;i++){
            if(wordsDict[i].equals(word1))
                i1 = i;
            else if(wordsDict[i].equals(word2))
                i2 = i;
            if(i1!=null && i2!= null)
            min = Math.min(min,Math.abs(i1-i2));
        }
     return min;   
    }

}
