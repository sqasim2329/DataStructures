package com.data.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParanthesis {
	
public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        backTrack(res,"",0,0,n);
        return res;
    }
    
    ///String is immutable, so when it returns back to previous function call, it doesnt hold the updated value
//hence no need to remove the last elem from string
    private void backTrack(List<String> res,String curr,int open, int close,int n){
        
        
        if(curr.length()== n*2){
            res.add(curr);
            return;
        }
        
        if(open < n)
            backTrack(res,curr+"(",open+1,close,n);
        if(close < open)
            backTrack(res,curr+")",open,close+1,n);
    }
    
    public static void main(String args[]) {
    	GenerateParanthesis g = new GenerateParanthesis();
    	System.out.println(g.generateParenthesis(3));
    }
    
    class Solution {
        public boolean isValid(String s) {
            
            Stack<Character> stk = new Stack<>();
            boolean flag = false;
            for(char c:s.toCharArray()){
                if(c=='('||c=='{'||c=='['){
                    stk.push(c);
                }else{
                    if(c==')')
                        flag = checkForValidity('(',stk);
                    else if(c == ']')
                        flag = checkForValidity('[',stk);
                    else if(c == '}')
                        flag = checkForValidity('{',stk);
                    if(!flag)
                        break;
                    
                }
            }
            return flag&&stk.isEmpty();//"([]){"
            
        }
        
        private boolean checkForValidity(char c,Stack<Character> stk){
            if(!stk.isEmpty() && stk.peek()==c){
                stk.pop();
                return true;
            }
            return false;
        }
    }
    

}
