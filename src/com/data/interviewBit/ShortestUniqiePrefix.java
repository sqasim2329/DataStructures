package com.data.interviewBit;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * 
 * Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov
 * 
 * ***/
public class ShortestUniqiePrefix {
	

    class TrieNode{
        Map<Character,TrieNode> children = new HashMap<>();
        Map<Character,Integer> count = new HashMap<>();
        boolean isWord;
    }
    public String[] prefix(String[] A) {
        TrieNode root = new TrieNode();
        for(String a:A)
            createTrie(a,root);
            
        for(int i=0;i<A.length;i++){
            A[i] = updatePrefix(A[i],root);
        }
        return A;
    }
    
    private void createTrie(String word,TrieNode root){
        TrieNode current = root;
        for(char c:word.toCharArray()){
            TrieNode node =  current.children.get(c);
            if(node == null){
                node = new TrieNode();
                current.children.put(c,node);
                current.count.put(c,1);
                current =  node;
            }else{
                current.count.put(c,current.count.get(c)+1);
                current = node; 
                
            }
        }
        current.isWord= true;
    }
    
    private String updatePrefix(String word,TrieNode root){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            if(current.children.containsKey(word.charAt(i))){
                if(current.count.get(word.charAt(i))==1){
                    return word.substring(0,i+1);
                }
            current = current.children.get(word.charAt(i));
            }
        }
        
        return word;
    }

}
