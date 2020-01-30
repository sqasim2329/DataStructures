package com.data.trie;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatching {
	
	public static void main(String args[]) {
		String queries[]= {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
		String pattern ="FB";
		NodeTrie root=new NodeTrie();
        createTrie(root,pattern);
        helper(root,queries).stream().forEach(System.out::println);;
	}

	private static List<Boolean> helper(NodeTrie root, String[] queries) {
		List<Boolean> bool=new ArrayList<>();
        for(String query:queries){
        	NodeTrie current=root;
            int i=0;
            boolean flag = true;
            while(i < query.length()){
                char ch=query.charAt(i);
                if(current.children.containsKey(ch)){
                    current=current.children.get(ch);
                    i++;
                }else if(ch >='a' && ch <='z'){
                    i++;
                }else{
                    flag=false;
                    break;
                }
            }
            bool.add(current.endOfWord&flag);
        }
        return bool;
	}

	private static void createTrie(NodeTrie root, String pattern) {
		NodeTrie current=root;
	    for(char c:pattern.toCharArray()){
	        NodeTrie node=current.children.get(c);
	        if(node==null){
	            node=new NodeTrie();
	            current.children.put(c,node);
	        }
	        current = node;
	    }
	    current.endOfWord=true;
	}
	
	public List<Boolean> camelMatch(String[] queries, String pattern) {
	       List<Boolean> list = new ArrayList<>();
	       int p = pattern.length();
	       int n = queries.length;
	       for(int i = 0 ; i < n ; i++)
	       {
	           String str = queries[i];
	           if(check(str , pattern))
	               list.add(true);
	           else 
	               list.add(false);
	       }
	       return list;
	   }
	   
	   public boolean check(String str , String pattern)
	   {
	       int n = str.length();
	       int j = 0;
	       int i = 0;
	       while(i < n && j < pattern.length())
	       {
	           char patternChar = pattern.charAt(j);
	           char strChar = str.charAt(i);
	           if(strChar == patternChar)
	           {
	               i++;
	               j++;
	           }
	           else if(strChar >= 'a' && strChar <= 'z')
	                   i++;
	           else
	               return false;
	           
	       }
	       while(i < n) //We reach here if pattern is completed or string is. If string is not completed, check if all further characters are lowercase, if not return false
	       {
	           if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
	               return false;
	           else 
	               i++;
	       }
	       return i == n && j == pattern.length();
	   }
    
}


