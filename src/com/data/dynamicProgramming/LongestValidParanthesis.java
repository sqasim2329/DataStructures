package com.data.dynamicProgramming;

public class LongestValidParanthesis {
	
	public static void main(String args[]) {
		String s = "(()";
	
	
		if(s == null || s == "")
            return 0;
        
        int open =0;
        int closed =0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                open++;
            else
                closed++;
            
            if(open == closed)
                max = Math.max(max,open+closed);
            else if(closed > open){
                open =0;
                closed = 0;
            }
        }
        open =0;
        closed=0;
        
        for(int i=s.length()-1;i>0;i--){
            if(s.charAt(i) == ')')
                closed++;
            else
                open++;
            
            if(open == closed)
                max = Math.max(max,open+closed);
            else if(open > closed){
                open = 0;
                closed = 0;
            }
        }
        System.out.println(max);


}
