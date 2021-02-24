package com.data.interviewBit;

public class MaxMinValuePath {
	

    
    
    private int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    
    public int maximumMinimumPath(int[][] A) {
        
        int row = A.length;
        int col = A[0].length;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(b[2],a[2]));
        q.add(new int[]{0,0,A[0][0]});
        boolean vis[][] = new boolean[row][col];
        while(!q.isEmpty()){
            int[] cell = q.poll();
            vis[cell[0]][cell[1]]=true;
            if(cell[0] == row-1 && cell[1]==col-1)
                return cell[2];
            for(int[] dir:directions){
                int nr = cell[0]+dir[0];
                int nc = cell[1]+dir[1];
                if(isSafe(nr,nc,A) && !vis[nr][nc]){
                    int adjMinValue = Math.min(cell[2],A[nr][nc]);
                    q.add(new int[]{nr,nc,adjMinValue});
                }
            }
            
        }
        
        return -1;
    }
    
    boolean isSafe(int x, int y, int[][] heights) {
        return x >= 0 && x <= heights.length-1 && y >= 0 && y <= heights[0].length-1;
    }

}
