package com.data.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//https://leetcode.com/problems/redundant-connection-ii/ can be done using union find
public class EvaluateDivision {
	
	class Solution {
	    
	    class Pair{
	        String node;
	        double val;
	        
	        public Pair(String node,double val){
	            this.node = node;
	            this.val = val;
	        }
	    }
	    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
	        
	        Map<String,List<Pair>> g = new HashMap<>();
	        buildGraph(g,equations,values);
	        double res[]=new double[queries.size()];
	        int index=0;
	        for(List<String> query:queries){
	            res[index++] = dfs(query.get(0),query.get(1),new HashSet<>(),g);
	        }
	        return res;
	    }
	    
	    private double dfs(String s, String d, Set<String> seen,Map<String,List<Pair>> g){
	        if(!g.containsKey(d) || !g.containsKey(s))// if either are not there then return -1;
	            return -1.0;
	        
	        if(s.equals(d))
	            return 1.0;
	        
	        seen.add(s);
	        for(Pair adj:g.get(s)){
	            if(!seen.contains(adj.node)){
	                double tmp = dfs(adj.node,d,seen,g);
	                if(tmp == -1.0) continue;
	                return tmp * adj.val;
	            }
	        }
	        return -1.0;
	    }
	    
	    private void buildGraph(Map<String,List<Pair>> g, List<List<String>> equations,double[] values){
	        for(int i=0;i<values.length;i++){
	            List<String> nodes =equations.get(i);
	            g.putIfAbsent(nodes.get(0),new ArrayList<>());
	            g.putIfAbsent(nodes.get(1),new ArrayList<>());
	            g.get(nodes.get(0)).add(new Pair(nodes.get(1),values[i]));
	            g.get(nodes.get(1)).add(new Pair(nodes.get(0),1/values[i]));
	        }
	    }
	    
	    
	}

}
