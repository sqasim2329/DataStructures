package com.data.trie;

import java.util.HashMap;
import java.util.Map;
//prefix tree
public class ImplementTrie {
	
	class Trie {
	    class TrieNode{
	        Map<Character,TrieNode> children = new HashMap<>();
	        boolean isEow;
	    }
	    
	    TrieNode root;

	    /** Initialize your data structure here. */
	    public Trie() {
	        root = new TrieNode();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        TrieNode current = root;
	        for(char c:word.toCharArray()){
	             TrieNode node = current.children.get(c);
	            if(node == null){
	                node = new TrieNode();
	                current.children.put(c,node);
	            }
	            current = node;
	        }
	        current.isEow = true;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        
	        TrieNode current = search(root,word);
	        return current==null?false:current.isEow;
	        
	    }
	    
	    private TrieNode search(TrieNode current,String word){
	        for(char c:word.toCharArray()){
	            TrieNode node = current.children.get(c);
	            if(node == null){
	                return node;
	            }
	            current = node;
	        }
	        return current;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        TrieNode current = search(root,prefix);
	        return current!=null;
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */

}
