package com.data.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndexPairsOfString {
	
	public static void main(String args[]) {
		String word="thestoryofleetcodeandme";
		String arr[]= {"story", "fleet", "leetcode"};
		
		NodeTrie root=new NodeTrie();
		for(int i=0;i<arr.length;i++) {	
			createTrie(root,arr[i]);
			}
		
		int[][] out=indexPairs(word, root);
		for(int[] o:out) {
			Arrays.stream(o).forEach(System.out::print);
			System.out.println();
		}
	}

	
	private static int[][] indexPairs(String s, NodeTrie root){
        int i=0;
        List<int[]> res = new ArrayList<>();
        NodeTrie current = root;
        while(i < s.length()){
            int j=i;
            current = root;
            while(j<s.length() && current.children.get(s.charAt(j))!=null){
                current = current.children.get(s.charAt(j));
                
                if(current!=null && current.endOfWord)
                    res.add(new int[]{i,j});
                
                j++;
            }
            i++;
        }
        return res.toArray(new int[res.size()][]);
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
