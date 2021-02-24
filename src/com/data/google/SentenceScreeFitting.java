package com.data.google;

public class SentenceScreeFitting {
	
	public int wordsTyping(String[] sentence, int rows, int cols) {

        String s = String.join(" ", sentence) + " ";
        int l = s.length();
        int start =0;
        for(int i=0;i<rows;i++){
            start+=cols;
            if(s.charAt(start%l)==' '){
                start++;
            }else{
                while(start > 0 && s.charAt((start-1)%l)!=' '){
                    start--;
                }
            }
        }
        
        return start/l;
        
        
    }

}
