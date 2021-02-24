package com.data.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignInMemeoryFileSystem {
	class FileSystem {
	    class TrieNode{
	        Map<String,TrieNode> children;
	        List<String> directory;
	        Map<String,String> filePath;   
	        StringBuilder content;
	        
	        public TrieNode(){
	            children = new HashMap<>();
	            directory = new ArrayList<>();
	            filePath = new HashMap<>();
	            content = new StringBuilder();
	        }
	        
	        public void createTrie(String path,boolean isFile,String content){
	            String[] component = path.split("/");
	            TrieNode current = root;
	            for(int i=1;i<component.length;i++){
	                TrieNode node = current.children.get(component[i]);
	                if(node ==null){
	                    node = new TrieNode();
	                    current.children.put(component[i],node);
	                    current.directory.add(component[i]);
	                }
	                current = node;
	                if(isFile && i == component.length-1){
	                    current.content.append(content);
	                    current.filePath.put(component[i],current.content.toString());
	                }                    
	            }
	        }
	    
	    
	            public TrieNode search(String[] component){   
	                TrieNode current = root;
	                for(int i=0;i<component.length;i++){
	                    TrieNode node =current.children.get(component[i]);
	                    if(node == null)
	                        return null;
	                    current = node;
	                }
	                return current;
	            }
	    
	    }
	    
	    TrieNode root;
	    
	    public FileSystem() {
	    root = new TrieNode();    
	    }
	    
	    public List<String> ls(String path) {
	        String[] comp = new String[]{};
	        if(path.length()>1)// this means that /a.... else we have only /
	         comp = path.substring(1).split("/");
	        
	        TrieNode current = root.search(comp);
	        List<String> result = new ArrayList<>();
	        if(current!=null){
	        result.addAll(current.directory);
	        Map<String,String> filePath = current.filePath;
	        List<String> files = new ArrayList<>(filePath.keySet());
	        result.addAll(files);
	        Collections.sort(result,(a,b)-> a.compareTo(b));
	        }
	        return result;        
	    }
	    
	    public void mkdir(String path) {
	        
	      root.createTrie(path,false,null);
	        
	    }
	    
	    public void addContentToFile(String filePath, String content) {
	        root.createTrie(filePath,true,content);
	    }
	    
	    public String readContentFromFile(String filePath) {
	        String[] comp = filePath.substring(1).split("/");
	        String fileName = comp[comp.length-1];
	        TrieNode node =root.search(comp);
	        if(node !=null && node.filePath.containsKey(fileName)){
	            return node.filePath.get(fileName);
	        }
	        return null;
	    }
	}

	/**
	 * Your FileSystem object will be instantiated and called as such:
	 * FileSystem obj = new FileSystem();
	 * List<String> param_1 = obj.ls(path);
	 * obj.mkdir(path);
	 * obj.addContentToFile(filePath,content);
	 * String param_4 = obj.readContentFromFile(filePath);
	 */

}
