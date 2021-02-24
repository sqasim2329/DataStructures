package com.data.interviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
	
	class Solution {
	    class DisjointSet{
	        int[] rep;
	        int[] rank;
	        
	        public DisjointSet(int v){
	            rep = new int[v];
	            for(int i=0;i<v;i++)
	                rep[i]=i;
	            rank= new int[v];
	        }
	        
	        public int findSet(int i){
	            int parent = rep[i];
	            if(parent == i)
	                return parent;
	            rep[i]=findSet(rep[i]);
	            return rep[i];
	        }
	        
	        public boolean union(int i, int j){
	            int pi = findSet(i);
	            int pj = findSet(j);
	            
	            if(pi == pj)
	                return false;
	            if(rank[pi]>=rank[pj]){
	                rank[pi]=rank[pi]==rank[pj]?rank[pi]+1:rank[pi];
	                rep[pj]=rep[pi];
	            }else{
	                rep[pi]=rep[pj];
	            }
	            return true;
	        }
	    }
	    public List<List<String>> accountsMerge(List<List<String>> accounts) {
	        DisjointSet disjoint = new DisjointSet(10001);
	        Map<String,Integer> emailToId = new HashMap<>();
	        Map<String,String> emailToName = new HashMap<>();
	        int id=0;
	        for(List<String> account:accounts){
	            String name ="";
	            for(String email:account){
	                if(name.equals("")){
	                name = email;
	                continue;    
	                }
	                emailToName.put(email,name);
	                emailToId.putIfAbsent(email,id++);
	                disjoint.union(emailToId.get(account.get(1)),emailToId.get(email));
	            }
	        }
	        Map<Integer,List<String>> result = new HashMap<>();
	        for(String email:emailToName.keySet()){
	            id = emailToId.get(email);
	            int repId = disjoint.findSet(id);
	            result.putIfAbsent(repId,new ArrayList<>());
	            result.get(repId).add(email);
	        }
	        
	        for(List<String> coll:result.values()){
	            Collections.sort(coll);
	            coll.add(0,emailToName.get(coll.get(0)));
	        }
	        
	        return new ArrayList<>(result.values());
	    }
	            
	}            

}
