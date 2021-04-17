package com.data.google.microsoft;

public class ReverseWordInStirng {
	
	class Solution {
	    public void reverseWords(char[] s) {
	        int i =0;
	        int j =s.length-1;
	        swap(i,j,s);
	        i=0;j=0;
	        while(j < s.length){
	            while(j < s.length && s[j]!=' ')j++;
	            swap(i,j-1,s);
	            i = j+1;
	            j = j+1;
	        }
	        
	    }
	    
	    private void swap(int i, int j, char s[]){
	        while(i < j){
	            char tmp = s[i];
	            s[i] = s[j];
	            s[j] = tmp;
	            i++;j--;
	        }
	    }
	}









}
