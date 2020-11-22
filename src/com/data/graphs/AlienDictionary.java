package com.data.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class AlienDictionary {
	
	public static void main(String args[]) {
		String words1[] = {"baa", "abcd", "abca", "cab", "cad"};
//		String words[] = {"caa", "aaa", "aab"};
		Map<Character,List<Character>> graph = new HashMap<>();
		Map<Character,Integer> indegree = new HashMap<>();
		
		
		for(int i=0;i<words1.length;i++) {
			for(Character c:words1[i].toCharArray()) {
			graph.putIfAbsent(c, new ArrayList<>());
			indegree.putIfAbsent(c, 0);
			}
		}
		
		createGraphAndUpdateIndegree(words1,graph,indegree);
		//either perform topological sort or follow below procedure
		printTheOrder(graph,indegree);
	
	}

	private static void printTheOrder(Map<Character, List<Character>> graph, Map<Character, Integer> indegree) {
	Queue<Character> queue =new LinkedList<>();
	StringBuffer sb= new StringBuffer();
	queue.addAll(indegree.entrySet().stream().filter(e->e.getValue()==0).map(e->e.getKey()).collect(Collectors.toList()));
	while(!queue.isEmpty()) {
		char c =queue.poll();
		sb.append(c);
		for(Character ch:graph.get(c)) {
			indegree.put(ch,indegree.get(ch)-1);
			if(indegree.get(ch)==0) {
				queue.add(ch);
			}
		}
		
		
	}
	System.out.println(sb);
		
	}

	private static void createGraphAndUpdateIndegree(String[] words, Map<Character, List<Character>> graph,
			Map<Character, Integer> indegree) {
		
		for(int i=0;i<words.length-1;i++) {
			String word1= words[i];
			String word2= words[i+1];
			int index = 0;
			while(index<word1.length() && index < word2.length()) {
				Character c1 = word1.charAt(index);
				Character c2 = word2.charAt(index);
				if(c1!=c2) {
					graph.get(c1).add(c2);
					indegree.put(c2, indegree.get(c2)+1);
					break;
				}
				index++;
			}
			
		}
		
	}

}
//verify alien dictionary
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] orderArr = new int[26];
        for(int i=0;i<order.length();i++){
            orderArr[order.charAt(i)-'a']=i;
        }
        
        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int k=0,j=0;
            int compare = 0;
            while(k<word1.length() && j< word2.length()){
                char c1 = word1.charAt(k);
                char c2 = word2.charAt(j);
                
                if(c1!=c2){
                    compare = orderArr[c1-'a'] - orderArr[c2-'a'];
                    break;
                }
                k++;
                j++;
            }
            
            if(word1.length() > word2.length() && compare ==0)
                return false;
            else if(compare > 0)
                return false;
            
            
        }
        
        
        return true;
        
    }
}
