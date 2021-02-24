package com.data.trie;

public class FileSystem {
	
	class FileSystem {
	    class TrieNode{
	        Map<String,TrieNode> children = new HashMap<>();
	        int val = -1;
	    }
	    
	    TrieNode root;

	    public FileSystem() {
	        root = new TrieNode();
	    }
	    
	    public boolean createPath(String path, int value) {
	        String[] component = path.split("/");
	        TrieNode curr = root;
	        for(int i=1;i<component.length;i++){
	            TrieNode node = curr.children.get(component[i]);
	            if(node == null){
	                if(i==component.length-1){
	                    node = new TrieNode();
	                    curr.children.put(component[i],node);
	                }else{
	                    return false;
	                }
	            }
	            curr = node;
	        }
	        if(curr.val!=-1)    
	            return false;
	        curr.val = value;    
	        return true;
	        
	    }
	    
	    public int get(String path) {
	        TrieNode curr = root;
	        String[] component = path.split("/");
	        for(int i=1;i<component.length;i++){
	            TrieNode node = curr.children.get(component[i]);
	            if(node == null)
	                return -1;
	            curr = node;
	        }
	        return curr.val;
	    }
	}

	/**
	 * Your FileSystem object will be instantiated and called as such:
	 * FileSystem obj = new FileSystem();
	 * boolean param_1 = obj.createPath(path,value);
	 * int param_2 = obj.get(path);
	 */

	                   

}
