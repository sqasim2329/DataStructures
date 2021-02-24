package com.data.interviewBit;

import java.util.Stack;

public class SimplifyPath {
	
	public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        String comp[] = path.split("\\/");
        StringBuilder sb = new StringBuilder();
        for(String st:comp){
            if(st.equals(".")) continue;
            else if(st.equals("..")){
                if(!stk.isEmpty()) stk.pop();
            }else if(st.length()==0) continue;
            else
                stk.push(st);
        }
        
        while(!stk.isEmpty()){
            sb.insert(0,"/"+stk.pop());
        }
        
        return sb.length()==0?"/":sb.toString();
        
    }

}
