package com.data.google;

public class 	 {
	
	
	 public int minimumSemesters(int n, int[][] relations) {
	        
	        int[] indegree = new int[n+1];
	        LinkedList<Integer>[] g = new LinkedList[n+1];
	        for(int i=0;i<=n;i++){
	            g[i] = new LinkedList<>();
	        }
	        
	        for(int[] relt:relations){
	            g[relt[0]].add(relt[1]);
	            indegree[relt[1]]++;
	        }
	        
	        Queue<Integer> q = new LinkedList<>();
	        
	        for(int i=1;i<=n;i++)
	            if(indegree[i]==0)
	                q.add(i);
	        
	        int sem=0;
	        while(!q.isEmpty()){
	            int size=q.size();
	            for(int i=0;i<size;i++){
	                int s = q.poll();
	                n--;
	                for(int adj:g[s]){
	                    indegree[adj]--;
	                    if(indegree[adj]==0)
	                        q.add(adj);
	                }
	            }
	            sem++;
	        }
	        return n==0?sem:-1;
	    }

}
