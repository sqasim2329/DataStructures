package com.data.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
//O(V+E) ,O(2V)
public class CourseSchedule {
	
public boolean canFinish(int nc, int[][] prerequisites) {
        
        
        int[] indegree=new int[nc];
        LinkedList<Integer>[] adj = new LinkedList[nc];
        for(int i=0;i<nc;i++)
            adj[i]= new LinkedList<>();
        
        for(int[] preq:prerequisites){
            indegree[preq[1]]++;
            adj[preq[0]].add(preq[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
            int source= q.poll();
            nc--;
            for(int ad:adj[source]){
                indegree[ad]--;
                if(indegree[ad]==0){
                    q.add(ad);
                }
            }
        }
        
        
        return nc==0;
        
        
        
    }
	
	public static void main(String args[]) {
		int nc=2;
		int [][] prerequisites = {{1,0}};
		CourseSchedule c=new CourseSchedule();
		System.out.println(c.canFinish(nc,prerequisites));
	}

}

/***
 * 
 * Create a map called indegree and put(preq[i][1],[preq[i][0]]);
 * and then ignore the for loop
 * /
 *///handling the cyclic cases as well
 
 class Solution {
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	        int nc = numCourses;
	        int[] od = new int[nc];
	        Map<Integer,List<Integer>> id = new HashMap<>();
	        List<Integer> op= new ArrayList<>();
	        Queue<Integer> q = new LinkedList<>();
	        
	        for(int i=0;i<prerequisites.length;i++){
	            od[prerequisites[i][0]]++;
	            id.putIfAbsent(prerequisites[i][1],new ArrayList<>());
	            id.get(prerequisites[i][1]).add(prerequisites[i][0]);
	        }
	        
	        for(int i=0;i<od.length;i++){
	            if(od[i]==0){
	                   q.add(i);
	            }
	        }
	        
	        while(!q.isEmpty()){
	            int vertex = q.poll();
	            op.add(vertex);
	            nc--;
	            if(id.containsKey(vertex)){
	                for(int adj:id.get(vertex)){
	                    od[adj]--;
	                    if(od[adj]==0)
	                        q.add(adj);
	                }
	                }
	        }
	        
	        return nc==0?op.stream().mapToInt(i->i).toArray():new int[0];
	        
	        
	    }
	}