package com.data.trie;

public class IndexPairsOfString {
	
	public static void main(String args[]) {
		String word="thestoryofleetcodeandme";
		String arr[]= {"story", "fleet", "leetcode"};
		
		NodeTrie root=new NodeTrie();
		for(int i=0;i<arr.length;i++) {	
			createTrie(root,arr[i]);
			}
		
		printPairs(word, root);
	}


	private static void printPairs(String word, NodeTrie root) {
		int i=0;
		while(i<word.length()) {
			int st=i;
			int end=i;
			NodeTrie current=root;
			while(end < word.length()) {
				char ch=word.charAt(end);
				if(current.children.get(ch)!=null &&
						current.children.get(ch).endOfWord) {
					System.out.println(st+" "+end);
				}
				if(current.children.get(ch)!=null && current.children.get(ch).children.size()>0) {
					end++;
					current=current.children.get(ch);
				}else {
					break;
				}
				
			}
			i++;
		}
	}
	
	
	private static void createTrie(NodeTrie root, String dictionary) {
		NodeTrie current=root;
		for(int i=0; i<dictionary.length();i++) {
			char ch=dictionary.charAt(i);
			NodeTrie node = current.children.get(ch);
			if(node==null) {
				node = new NodeTrie();
				current.children.put(ch,node);
			}
			current=node;
			
		}
		current.endOfWord=true;
		
		
	}

}
