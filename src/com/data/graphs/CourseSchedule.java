package com.data.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
//O(V+E) ,O(2V)
public class CourseSchedule {
	
	public boolean canFinish(int nc, int [][] preq) {
		int[] od= new int[nc];
		Queue<Integer> q= new LinkedList<>();
		for(int i=0;i<preq.length;i++) {
			od[preq[i][0]]++;
		}
		
		for(int i=0;i<preq.length;i++) {
			if(od[i]==0) 
				q.add(i);
		}
		int count=0;
		while(!q.isEmpty()) {
			int pop = q.poll();
			count++;
			for(int i=0;i<preq.length;i++) {// can use a map to impreiove efficiency
				if(preq[i][1]==pop) {
					od[preq[i][0]]--;
					if(od[preq[i][0]]==0)
						q.add(preq[i][0]);
				}
			}
		}
		
		return count==nc;
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