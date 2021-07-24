package com.data.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ValidGraphTree {class Solution {
    class Disjoint{
        int[] rep;
        int rank[];
        public Disjoint(int v){
            rep = new int[v];
            rank = new int[v];
            for(int i=0;i<v;i++)
                rep[i]=i;
        }
        
        private int findSet(int i){
            int parent =rep[i];
            if(parent ==i )
                return parent;
            rep[i]=findSet(rep[i]);
            return rep[i];
        }
        
        private boolean union(int i , int j){
            int pi= findSet(i);
            int pj= findSet(j);
            
            
            if(pi == pj)
                return false;
            
            if(rank[pi]>=rank[pj]){
                rank[pi]=rank[pi]==rank[pj]?rank[pi]+1:rank[pi];
                rep[pj]=pi;
            }else{
                rep[pi]=pj;
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        
        if (edges.length != n - 1) return false;
        Disjoint union = new Disjoint(n);
        for(int[] edge:edges){
            int x = edge[0];
            int y = edge[1];
            if(!union.union(x,y))
                return false;
        }
        
        return true;
        
    }
    
    
}}
