package com.data.interviewBit;

import java.util.Arrays;
import java.util.PriorityQueue;
//O(mn)(log(mn))
public class MinEffortPath {
    private int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    class Cell{
        int row ;
        int col;
        int distance;
        
        public Cell(int row, int col,int distance){
            this.row=row;
            this.col=col;
            this.distance = distance;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int row =heights.length;
        int col =heights[0].length;
        int[][] distance= new int[row][col];
        for(int[] d:distance)
            Arrays.fill(d,Integer.MAX_VALUE);
        PriorityQueue<Cell> q = new PriorityQueue<>((a,b)->Integer.compare(a.distance,b.distance));
        q.add(new Cell(0,0,0));
        distance[0][0]=0;
        boolean visited[][] = new boolean[row][col];
        while(!q.isEmpty()){
            Cell cell = q.poll();
            visited[cell.row][cell.col]=true;
            if(cell.row == row-1 && cell.col == col-1)
                return cell.distance;
            int currentEffort = cell.distance;
            for(int[] dir:directions){
                int nr = cell.row+dir[0];
                int nc = cell.col+dir[1];
                
                if(isSafe(nr,nc,heights) && !visited[nr][nc]){
                    int adjMaxEffort= Math.max(cell.distance,Math.abs(heights[cell.row][cell.col]-heights[nr][nc]));
                    if(distance[nr][nc] > adjMaxEffort){
                        q.add(new Cell(nr,nc,adjMaxEffort));
                        distance[nr][nc] = adjMaxEffort;
                    }
                }
            }
            
        }
        return distance[row-1][col-1];
        
    }
    
    
    
    boolean isSafe(int x, int y, int[][] heights) {
        return x >= 0 && x <= heights.length-1 && y >= 0 && y <= heights[0].length-1;
    }}
