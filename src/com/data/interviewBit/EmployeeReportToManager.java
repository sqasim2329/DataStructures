package com.data.interviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeReportToManager {
	
	public Map<Character,List<Character>> findEmployees(char[][] relation){
		
		int[] outdegree = new int[26];
		Map<Character,List<Character>> indegree = new HashMap<>();
		Map<Character,List<Character>> reporteManagerMap = new HashMap<>();
		Map<Character,List<Character>> result = new HashMap<>();
		Queue<Character> q = new LinkedList<>();
		for(char[] reltn:relation) {
			indegree.putIfAbsent(reltn[0], new ArrayList<>());
			indegree.putIfAbsent(reltn[1], new ArrayList<>());
			if(reltn[0]!=reltn[1]) {
			 outdegree[reltn[0]-'a']++;
			indegree.get(reltn[1]).add(reltn[0]);
			}
		}
		
		for(Character c:indegree.keySet()) {
			if(outdegree[c-'a']==0) {
				q.add(c);
			}
		}
		
		while(!q.isEmpty()) {
			char c = q.poll();
			for(Character reportee:indegree.get(c)) {
				outdegree[reportee-'a']--;
				reporteManagerMap.putIfAbsent(c, new ArrayList<>());
				reporteManagerMap.get(c).add(reportee);
				if(outdegree[reportee-'a']==0)
					q.add(reportee);
			}
		}
		for(Map.Entry<Character, List<Character>> entry:reporteManagerMap.entrySet()) {
			List<Character> values = entry.getValue();
			result.putIfAbsent(entry.getKey(), new ArrayList<>());
			for(Character c:entry.getValue()) {
				result.get(entry.getKey()).addAll(reporteManagerMap.get(c));
			}
			
		}
		
		
		return result;
		
	}
	
	public static void main(String args[]) {
		char[][] reltn= {{'a','a'},{'b','a'},{'c','b'},{'d','b'},{'e','d'},{'f','e'}};
		EmployeeReportToManager emp = new EmployeeReportToManager();
		System.out.println(emp.findEmployees(reltn));
	}

}
