package com.data.interviewBit;

public class FindDuplicateFileINFileSystem {
	
	class Solution {
	    public List<List<String>> findDuplicate(String[] paths) {
	        
	        Map<String,List<String>> map = new HashMap<>();
	        for(String path:paths){
	            String[] pathComp = path.split("\\s+");
	            for(int i=1;i<pathComp.length;i++){
	                String[] fileNameNCon = pathComp[i].replace("("," ").split("\\s+");
	                String fileName = fileNameNCon[0];
	                String content = fileNameNCon[1].replace(")","");
	                map.putIfAbsent(content,new ArrayList<>());
	                map.get(content).add(pathComp[0]+"/"+fileName);
	            }
	        }
	        List<List<String>> res = new ArrayList<>();
	        for(List<String> ls:map.values()){
	            if(ls.size()>1)
	            res.add(ls);
	        }
	        return res;
	        
	    }
	}
//	Imagine you are given a real file system, how will you search files? DFS or BFS?
//			If the file content is very large (GB level), how will you modify your solution?
//			If you can only read the file by 1kb each time, how will you modify your solution?
//			What is the time complexity of your modified solution? What is the most time-consuming part and memory consuming part of it? How to optimize?
//			How to make sure the duplicated files you find are not false positive?
	
//	BFS vs DFS
//	BFS explores neigbours first. This means that files which are located close to each other are also accessed one after another. This is great for space locality and that's why BFS is expected to be faster. Also, BFS is easier to parellelize.
//
//	Very large files and false positives
//	For very large files we should do the following comparisons in this order:
//
//	compare sizes, if not equal, then files are different and stop here!
//	hash them with a fast algorithm e.g. MD5 or use SHA256 (no collisions found yet), if not equal then stop here!
//	compare byte by byte to avoid false positives due to collisions.
//	Have you used an IDE in remote development mode?
//	For example, CLion has some options on how to compare the local files with the remote server files and then decides to synchronize or not.
//
//	Complexity
//	Runtime - Worst case (which is very unlikely to happen): O(N^2 * L) where L is the size of the maximum bytes that need to be compared
//	Space - Worst case: all files are hashed and inserted in the hashmap, so O(H^2*L), H is the hash code size and L is the filename size

}
