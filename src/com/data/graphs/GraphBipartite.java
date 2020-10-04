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
	
}
