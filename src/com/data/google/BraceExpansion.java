package com.data.google;

public class BraceExpansion {
	
	class Solution {
	    public String[] expand(String s) {
	        
	        List<List<Character>> option = new ArrayList<>();
	        List<String> res = new ArrayList<>();
	        boolean isOpen = false;
	        List<Character> ls= new ArrayList<>();
	        for(char c:s.toCharArray()){
	            if(c == ',') continue;
	            if(!isOpen)  ls = new ArrayList<>();
	            if(c == '{'){
	                isOpen = true;
	            }else if(c == '}')
	            {
	                isOpen = false;
	            }
	            else{
	                ls.add(c);
	            }
	            if(!isOpen){
	                option.add(ls);
	            }
	        }
	        
	        backTrack(0,"",option,res);
	        Collections.sort(res);
	        return res.toArray(new String[res.size()]);
	    }
	    
	    private void backTrack(int indx, String s, List<List<Character>> option, List<String> res){
	        if(indx == option.size()){
	            res.add(new String(s));
	            return ;
	        }
	        
	        for(int i=0;i< option.get(indx).size();i++){
	            backTrack(indx+1,s+option.get(indx).get(i),option,res);
	        }
	    }
	}

}
