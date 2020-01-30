package com.data.trie;

import java.util.HashMap;

class NodeTrie{
	HashMap<Character,NodeTrie> children;
	boolean endOfWord;
	public NodeTrie() {
		children = new HashMap<>();
	}
	
}

public class WordBoggle {
	
	public static void main(String args[]) {
		String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
		char boggle[][]   = {{'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}};
		
		NodeTrie root= new NodeTrie();
		for(int i=0;i<dictionary.length;i++) {	
		createTrie(root,dictionary[i]);
		}
		
		findWord(root,boggle);
	}

	private static void findWord(NodeTrie root, char[][] boggle) {
		int m=boggle.length;
		int n=boggle[0].length;
		boolean visited[][]= new boolean[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				String s="";
				if(root.children.get(boggle[i][j])!=null)					
				searchWord(root.children.get(boggle[i][j]),visited,i,j,s+boggle[i][j],boggle);
				s="";
			}
		}
	}
//replaced if else with if since it will run through all the elemensts in the map;  
	private static void searchWord(NodeTrie root, boolean[][] visited, int i, int j, String s, char[][] boggle) {
		if(root.endOfWord==true)
			System.out.println(s);
		if(isSafe(i,j,boggle.length,boggle[0].length)) {
			visited[i][j]=true;
			if(isSafe(i,j+1,boggle.length,boggle[0].length) && !visited[i][j+1] 
					&& root.children.get(boggle[i][j+1])!=null) {
				char c=boggle[i][j+1];
				searchWord(root.children.get(c),visited,i,j+1,s+c,boggle);
			}
			if(isSafe(i+1,j,boggle.length,boggle[0].length) && !visited[i+1][j] 
					&& root.children.get(boggle[i+1][j])!=null) {
				char c=boggle[i+1][j];
				searchWord(root.children.get(c),visited,i+1,j,s+c,boggle);
			}
			if(isSafe(i+1,j+1,boggle.length,boggle[0].length) && !visited[i+1][j+1] 
					&& root.children.get(boggle[i+1][j+1])!=null) {
				char c=boggle[i+1][j+1];
				searchWord(root.children.get(c),visited,i+1,j+1,s+c,boggle);
			}
			if(isSafe(i,j-1,boggle.length,boggle[0].length) && !visited[i][j-1] 
					&& root.children.get(boggle[i][j-1])!=null) {
				char c=boggle[i][j-1];
				searchWord(root.children.get(c),visited,i,j-1,s+c,boggle);
			}
			if(isSafe(i-1,j,boggle.length,boggle[0].length) && !visited[i-1][j] 
					&& root.children.get(boggle[i-1][j])!=null) {
				char c=boggle[i-1][j];
				searchWord(root.children.get(c),visited,i-1,j,s+c,boggle);
			}
			if(isSafe(i-1,j-1,boggle.length,boggle[0].length) && !visited[i-1][j-1] 
					&& root.children.get(boggle[i-1][j-1])!=null) {
				char c=boggle[i-1][j-1];
				searchWord(root.children.get(c),visited,i-1,j-1,s+c,boggle);
			}
			if(isSafe(i-1,j+1,boggle.length,boggle[0].length) && !visited[i-1][j+1] 
					&& root.children.get(boggle[i-1][j+1])!=null) {
				char c=boggle[i-1][j+1];
				searchWord(root.children.get(c),visited,i-1,j+1,s+c,boggle);
			}
			if(isSafe(i+1,j-1,boggle.length,boggle[0].length) && !visited[i+1][j-1] 
					&& root.children.get(boggle[i+1][j-1])!=null) {
				char c=boggle[i+1][j-1];
				searchWord(root.children.get(c),visited,i+1,j-1,s+c,boggle);
			}
			visited[i][j]=false;
		}
		
		
		
	}

	private static boolean isSafe(int i, int j, int m, int n) {
		if((i>=0 && i<m ) && (j>=0 && j<n))
			return true;
		return false;
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
