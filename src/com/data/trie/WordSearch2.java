package com.data.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch2 {

	class Solution {
	    class TrieNode{
	        Map<Character,TrieNode> children;
	        String word;
	        public TrieNode(){
	            children = new HashMap<>();
	            word = null;
	        }
	    }
	    public List<String> findWords(char[][] board, String[] words) {
	        List<String> res = new ArrayList<>();
	        TrieNode root = new TrieNode();
	        for(String word:words)
	        createTrie(word,root);
	        
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[0].length;j++){
	                if(root.children.containsKey(board[i][j]))
	                    backTrack(i,j,root,board,res);
	            }
	        }
	        return res;

	    }
	    
	    private void createTrie(String word,TrieNode root){
	        TrieNode current = root;
	        for(char ch:word.toCharArray()){
	            TrieNode node = current.children.get(ch);
	            if(node == null){
	                node = new TrieNode();
	                current.children.put(ch,node);
	            }
	            current =node;
	        }
	        current.word = word;
	    }
	    
	    private void backTrack(int r, int c,TrieNode parent,char[][] board, List<String> res){
	        
	        char letter = board[r][c];
	        TrieNode current = parent.children.get(letter);
	        
	        if(current.word!=null){
	            res.add(current.word);
	            current.word = null;
	        }
	        
	        board[r][c]='#';
	        
	        if(isSafe(r+1,c,board) && current.children.containsKey(board[r+1][c])){
	            backTrack(r+1,c,current,board,res);
	        }
	        
	        if(isSafe(r-1,c,board) && current.children.containsKey(board[r-1][c])){
	            backTrack(r-1,c,current,board,res);
	        }
	        
	        if(isSafe(r,c+1,board) && current.children.containsKey(board[r][c+1])){
	            backTrack(r,c+1,current,board,res);
	        }
	        
	        if(isSafe(r,c-1,board) && current.children.containsKey(board[r][c-1])){
	            backTrack(r,c-1,current,board,res);
	        }
	        
	        
	        board[r][c]=letter;
	        if(current.children.isEmpty()){
	            parent.children.remove(letter);
	        }
	        
	    }
	    
	    private boolean isSafe(int r,int c,char[][]board){
		        return r>=0 && r<board.length && c>=0 && c<board[r].length;
		    }
	}}
