package com.data.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

	Map<Character, TrieNode> children;
	boolean endOfWord;
	int ends;

	public TrieNode() {
		super();
		this.children = new HashMap<>();
	}

}

class MaxObj {
	int maxLength = Integer.MIN_VALUE;
	int maxEnds = Integer.MIN_VALUE;
	String word = "x";
}

public class LongestWordInDictionary {

	public static void main(String args[]) {
		String[] words = {"yo","ew","yodn","ewq","yod","ewqz","y" };
		TrieNode root = new TrieNode();
		MaxObj ob = new MaxObj();

		for (int i = 0; i < words.length; i++) {
			createTrie(words[i], root, ob);
		}

		System.out.println(ob.word);

	}

	private static void createTrie(String word, TrieNode root, MaxObj ob) {
		TrieNode current = root;
		int end = 0;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			end = current.ends;
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
				current.ends=end;
			}
			current = node;
		}
		current.endOfWord = true;
		current.ends = end + 1;
		if ((current.ends > ob.maxEnds && word.length() == ob.maxLength)
				|| (current.ends == ob.maxEnds && word.length() == ob.maxLength && word.compareTo(ob.word) < 0)) {
			ob.maxLength = word.length();
			ob.maxEnds = current.ends;
			ob.word = word;
		}
	}
}
