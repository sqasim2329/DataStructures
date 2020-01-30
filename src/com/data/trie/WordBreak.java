package com.data.trie;

public class WordBreak {
	
	public static void main(String args[]) {
		String s= "catsandog";
		String wordDict[] = {"cats", "dog", "sand", "and", "cat"};
		
		NodeTrie root= new NodeTrie();
		for(int i=0;i<wordDict.length;i++)
		createTrie(root,wordDict[i]);
		System.out.println(wordBreak(root,s));
		
	}

	private static boolean wordBreak(NodeTrie root, String s) {
		if(s.length()==0)
			return true;
		
		for(int i=0;i<s.length();i++) {
			if(search(root,s.substring(0, i+1)) &&
			wordBreak(root,s.substring(i+1)))
			return true;
		}
		return false;
		
		
	}

	private static boolean search(NodeTrie root, String substring) {
		NodeTrie current=root;
		for(int i=0;i<substring.length();i++) {
			char ch=substring.charAt(i);
			NodeTrie node=current.children.get(ch);
			if(node==null) {
				return false;
			}
			current=node;
		}	
		return current.endOfWord;
	}

	private static void createTrie(NodeTrie root, String word) {
		NodeTrie current=root;
		for(int i=0;i<word.length();i++) {
			char ch=word.charAt(i);
			NodeTrie node=current.children.get(ch);
			if(node==null) {
				node=new NodeTrie();
				current.children.put(ch,node);
			}
			current=node;
		}
		current.endOfWord=true;
		
	}

}
