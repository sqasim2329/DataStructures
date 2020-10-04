package com.data.stack;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges2 {
	class Orange{
        int i;
        int j;
        public Orange(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
	
public int orangesRotting(int[][] grid) {
        
        int countFresh = 0;
        int n = grid.length;
        Queue<Orange> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    q.add(new Orange(i,j));
                if(grid[i][j]==1)
                    countFresh++;
            }
        }
        int time =0;
        while(!q.isEmpty()){
            time++;
            int size = q.size();
            while(!q.isEmpty() && size > 0){
                size--;
                Orange o = q.poll();
                countFresh -=rotten(q,o,grid);
            }
        }
        
        return countFresh==0?time:-1;
        
    }
    
    
    private int rotten(Queue<Orange> q, Orange o, int[][]grid){
        int i = o.i;
        int j = o.j;
        int countRot = 0;
        if(isSafe(i+1,j,grid) && grid[i+1][j]==1){
            countRot++;
            q.add(new Orange(i+1,j));
        }
        if(isSafe(i-1,j,grid) && grid[i-1][j]==1){
            countRot++;
            q.add(new Orange(i-1,j));
        }
        if(isSafe(i,j+1,grid) && grid[i][j+1]==1){
            countRot++;
            q.add(new Orange(i,j+1));
        }
        if(isSafe(i,j-1,grid) && grid[i][j-1]==1){
            countRot++;
            q.add(new Orange(i,j-1));
        }
        return countRot;
        
    }
    
    private boolean isSafe(int i, int j, int[][]grid){
        return (i>=0 && i<grid.length && j>=0 && j< grid.length);
    }
}
