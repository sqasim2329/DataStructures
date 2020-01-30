package com.data.trie;

import java.util.Set;
import java.util.TreeMap;

class TTNode{
	TreeMap<Character,TTNode> children;
	boolean endOfWord;
	public TTNode() {
		children=new TreeMap<>();
	}
}

public class SortingArrayOfString {
	
	public static void main(String args[]) {
		String arr[]= {"geeks", "for", "geeks", "a", "portal", 
		        "to", "learn", "can", "be", "computer", 
		        "science", "zoom", "yup", "fire", "in", "data"};
		TTNode root=new TTNode();
		for(int i=0;i<arr.length;i++)
		createTrie(arr[i],root);
		String s="";
		printTrieWords(root,s);
	}

	private static void printTrieWords(TTNode root,String s) {
		if(root.endOfWord==true) {
			System.out.println(s);
			return;
					}
		Set<Character> keys=root.children.keySet();
		for(char ch:keys) {
			printTrieWords(root.children.get(ch),s+ch);
		}
	}


	private static void createTrie(String word, TTNode root) {
		TTNode current= root;
		for(int i=0;i<word.length();i++) {
			char ch=word.charAt(i);
			TTNode node=root.children.get(ch);
			if(node==null) {
				node=new TTNode();
				current.children.put(ch,node);
			}
			current=node;
		}
		current.endOfWord=true;
	}

}
