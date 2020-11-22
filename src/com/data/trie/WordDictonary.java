package com.data.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictonary {
	
	    
	    class TrieNode{
	        Map<Character,TrieNode> children;
	        boolean eow;
	        
	        public TrieNode(){
	            children = new HashMap<>();
	            eow =false;
	        }
	    }
	    
	    TrieNode root;

	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        root = new TrieNode();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        TrieNode current = root;
	        for(char ch:word.toCharArray()){
	            TrieNode node = current.children.get(ch);
	            if(node == null){
	                node = new TrieNode();
	                current.children.put(ch,node);
	            }
	            current = node;
	        }
	        current.eow = true;
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        return search(word,root);
	    }
	    
	    private boolean search(String word,TrieNode current){
	        for(int i=0;i<word.length();i++){
	            char ch = word.charAt(i);
	            
	            TrieNode node = current.children.get(ch);
	            if(node == null){
	                if(ch == '.'){
	                    for(char c:current.children.keySet()){
	                        TrieNode child = current.children.get(c);
	                        if(search(word.substring(i+1),child))
	                            return true;
	                    }
	                }
	                
	                return false;
	            }else{
	                current = node;
	            }
	        }
	        
	        return current.eow;
	    }
	    
	    
	    
	

	/**
	 * Your WordDictionary object will be instantiated and called as such:
	 * WordDictionary obj = new WordDictionary();
	 * obj.addWord(word);
	 * boolean param_2 = obj.search(word);
	 */

}
