package com.data.google.microsoft;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// euler path
public class ReconstructItenary {
	
	class Solution {
	    public List<String> findItinerary(List<List<String>> tickets) {
	        
	        
	        Map<String, LinkedList<String>> gph = new HashMap<>();
	        for(List<String> ticket:tickets){
	            gph.putIfAbsent(ticket.get(0),new LinkedList<>());
	            gph.get(ticket.get(0)).add(ticket.get(1));
	            Collections.sort(gph.get(ticket.get(0)));
	        }
	        
	        LinkedList<String> res = new LinkedList<>();
	        dfs("JFK",res,gph);
	        return res;
	    }
	    
	    private void dfs(String origin, LinkedList<String> res,Map<String, LinkedList<String>> gph){
	        LinkedList<String> adjList = gph.get(origin);
	        while(adjList!=null && !adjList.isEmpty()){
	            String adj = adjList.pollFirst();
	            dfs(adj,res,gph);
	        }
	        res.addFirst(origin);   
	    }
	}


	// ["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]

	// JFK -> MUC -> LHR -> SFO -> SJC


	    


}
