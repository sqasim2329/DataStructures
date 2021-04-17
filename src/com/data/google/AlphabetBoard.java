package com.data.google;

public class AlphabetBoard {
	
	
	class Solution {
	    public String alphabetBoardPath(String target) {
	        int prow=0;
	        int pcol=0;
	        StringBuilder sb = new StringBuilder();
	        for(char c:target.toCharArray()){
	            int crow =(c-'a')/5;
	            int ccol =(c-'a')%5;
	            if(prow == crow && pcol == ccol)
	                sb.append("!");
	            else
	            {
	                determineMove(crow,ccol,prow,pcol,sb);
	                sb.append("!");
	                prow =crow;
	                pcol =ccol;
	            }
	        }
	        return sb.toString();
	    }
	    //LDUR
	    private void determineMove(int crow,int ccol, int prow, int pcol, StringBuilder sb){
	        while(pcol > ccol){
	            sb.append("L");
	            pcol--;
	        }
	        
	        
	        while(prow < crow){
	            sb.append("D");
	            prow++;
	        }
	        
	        while(prow > crow){
	            sb.append("U");
	            prow--;
	        }
	        
	        while(pcol < ccol){
	            sb.append("R");
	            pcol++;
	        }
	    }
	}

}
