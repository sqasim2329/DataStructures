package com.data.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Trie{
    Map<Character,Trie> children = new HashMap<>();
    int index = -1;
}

class MaxObj {
	int maxLength = Integer.MIN_VALUE;
	int maxEnds = Integer.MIN_VALUE;
	String word = "x";
}

public class LongestWordInDictionary {

	public static void main(String args[]) {
		String[] words = {"w","wo","wor","worl", "world"};
		Trie root = new Trie();
		LongestWordInDictionary l =new LongestWordInDictionary();
		System.out.println(l.longestWord(words));

	}

	public String longestWord(String[] words) {
        Trie root= new Trie();
        int index = 0;
        for(String word:words)
        createTrie(word,index++,root);
        return dfs(root,words);
    }
	
	private int createTrie(String word,int index,Trie root){
        Trie current = root;
        for(char ch: word.toCharArray()){
            Trie node = current.children.get(ch);
            if(node == null){
                node = new Trie();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.index = index;
        return index;
    }
    
    private String dfs(Trie root,String[] words){
        Stack<Trie> stk = new Stack<>();
        stk.push(root);
        String ans = "";
        int max = 0;
        while(!stk.isEmpty()){
            Trie node = stk.pop();
            if(node.index > -1 || node == root){
                if(node!=root){
                    String query = words[node.index];
                    if(query.length()>max || query.length()==max && query.compareTo(ans)<0)
                    {
                        max = query.length();
                        ans = query;
                    }
                }
                    for(Trie child : node.children.values()){
                        stk.push(child);
                    }
                
            }
        }
        
        return ans;
    }
}
