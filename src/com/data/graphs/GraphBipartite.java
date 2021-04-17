package com.data.graphs;

public class GraphBipartite {
	
	
	    
	    private static boolean visited[] ;
	    private static int color[] ;
	    
	    
	    public static void main(String args[]) {
			int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
			System.out.println(isBipartite(graph));
		}
	    
	    public static boolean isBipartite(int[][] graph) {
	        
	    visited = new boolean[graph.length];
	    color = new int[graph.length];    
	        
	        for(int i=0;i<graph.length;i++){
	            if(!visited[i] && !DFSUtil(i,0,graph))
	                return false;
	        }
	         return true;
	        
	    }
	    
	    
	    private static boolean DFSUtil(int i, int col,int [][] graph){
	        visited[i]=true;
	        color[i]=col;
	        for(int j:graph[i]){
	            if(!visited[j]){
	                if(!DFSUtil(j,col^1,graph)){
	                    return false;
	                }
	            }else{
	                if(color[i]==color[j])
	                    return false;
	            }
	        }
	        
	        return true;
	    }
	    
	    
	    public boolean possibleBipartition(int N, int[][] dislikes) {
	        
	        LinkedList<Integer>[] g = new LinkedList[N+1];
	        for(int i=0;i<=N;i++){
	            g[i]= new LinkedList<>();
	        }
	        
	        for(int[] people:dislikes){
	            g[people[0]].add(people[1]);
	            g[people[1]].add(people[0]);
	        }
	    
	        int[] color = new int[N+1];
	        Arrays.fill(color,-1);
	        for(int i=1;i<=N;i++){
	         if( color[i]==-1){
	             if(!dfs(i,color,0,g))
	             return false;
	            }
	        }
	        
	        return true;
	    }
	    
	    private boolean dfs(int s, int[] color,int col,LinkedList<Integer>[] g){
	        color[s]=col;
	        for(int adj:g[s]){
	            if(color[adj]==-1){
	                if(!dfs(adj,color,col^1,g))
	                    return false;
	            }else if(color[s]==color[adj]){
	                return false;
	            }
	        }
	        return true;
	    }
	
}
