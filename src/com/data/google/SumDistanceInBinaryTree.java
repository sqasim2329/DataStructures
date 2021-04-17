package com.data.google;
//https://github.com/tyqi11/leetcode/blob/master/834_Sum_of_Distances_in_Tree.java
public class SumDistanceInBinaryTree {
	
	class Solution {
	    public int[] sumOfDistancesInTree(int N, int[][] edges) {
	        
	        LinkedList<Integer>[] gph = new LinkedList[N];
	        for(int i=0;i<N;i++ )
	            gph[i]=new LinkedList<>();
	        
	        for(int[] edge:edges){
	            gph[edge[0]].add(edge[1]);
	            gph[edge[1]].add(edge[0]);
	        }
	        int[] distance = new int[N];
	        int[] count = new int[N];
	        postOrder(gph,distance,count,0,-1);
	        preOrder(gph,distance,count,0,-1);
	        return distance;
	    }
	    
	    private void postOrder(LinkedList<Integer>[] gph,int[] distance,int [] count,int node,int parent){
	        for(int adj:gph[node]){
	            if(adj==parent)continue;
	             postOrder(gph,distance,count,adj,node);
	            count[node] += count[adj];
	            distance[node]+=distance[adj]+count[adj];
	        }
	        count[node]=count[node]+1;
	    }
	    
	    private void preOrder(LinkedList<Integer>[] gph,int[] distance,int [] count,int node,int parent){
	        
	        for(int adj:gph[node]){
	            if(adj==parent)continue;
	            distance[adj]=distance[node]-count[adj]+gph.length-count[adj];
	            preOrder(gph,distance,count,adj,node);
	        }
	        
	    }
	}

}
