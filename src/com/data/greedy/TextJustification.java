package com.data.greedy;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	
	class Solution {
	    public List<String> fullJustify(String[] text, int maxWidth) {
	        
	        int i =0;
	        int lineLength = 0;
	        int n = text.length;
	        List<String> justifiedText =  new ArrayList<>();
	        while(i< n){
	            int j = i+1;
		        while(j < n && (lineLength+text[j].length()+(j-i-1) < maxWidth)){
	                lineLength += text[j].length();
	                j++;
	            }

	            int diff = maxWidth - lineLength;
	            int noOfWordsInCurrentLine = j-i;
	            if(noOfWordsInCurrentLine <=1 && j>=n) justifiedText.add(leftJustify(text,i,j,diff));
	            else 
	            justifiedText.add(middleJustify(text,i,j,diff));
	            i=j;
	        }
	        return justifiedText;
	    }
	    
	    private String leftJustify(String[] text,int i, int j, int diff){
	        int spacesOnRight = diff - j-i-1; //total difference in words and width - necessary spaces;
	        StringBuilder sb = new StringBuilder(text[i]);
	        for(int k=i+1;k<j;k++)	{
	            sb.append(" ").append(text[k]);
	        }
	        for(int l=0;l<spacesOnRight;l++)
	        sb.append(" ");
	        return sb.toString();
	    }
	    
	    private String middleJustify(String[] text, int i, int j,int diff){
		    int spaceGroups = j-i-1;
		    int spaces = diff/spaceGroups;
		    int extraSpace = diff%spaceGroups;
		    StringBuilder sb = new StringBuilder(text[i]);
		    for(int k=i+1;k<j;k++){
		    	for(int l=0;l<(spaces+(extraSpace-->0?1:0));i++)
		    	sb.append(" ");
		    	sb.append(text[j]);
	        }
	        return sb.toString();
	    }


	}


	class Solution {
	    public String reorderSpaces(String text) {
	        int totalSpaces = 0;
	        int totalWords = 0;
	        
	        String[] words = text.trim().split("\\s+");
	        for(char c:text.toCharArray()){
	            if(c == ' ')
	                totalSpaces++;
	        }
	        totalWords = words.length;
	        int spaceGroups = totalWords-1;    
	        int minSpaces = spaceGroups!=0?totalSpaces/spaceGroups:0;
	        int extraSpaces = spaceGroups!=0?totalSpaces%spaceGroups:totalSpaces;
	        StringBuilder sb = new StringBuilder(words[0]);
	        for(int k=1;k<words.length;k++){
	                    for(int i=0;i<minSpaces;i++){
	                        sb.append(" ");
	                    }
	            sb.append(words[k]);
	        }
	        
	        for(int i=0;i<extraSpaces;i++){
	            sb.append(" ");
	        }
	        return sb.toString();
	    }
	}




}
