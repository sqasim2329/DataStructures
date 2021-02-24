package com.data.graphs;

public class WallsAndGates {
	
	  static final int INF = 2147483647;
	    public void wallsAndGates(int[][] rooms) {
	        
	        Queue<int[]> q = new LinkedList<>();
	        for(int r = 0;r<rooms.length;r++){
	            for(int c =0;c<rooms[r].length;c++){
	                if(rooms[r][c]==0)
	                    q.add(new int[]{r,c});
	            }
	        }
	        
	        while(!q.isEmpty()){
	            int[] pos = q.poll();
	            int row = pos[0];
	            int col = pos[1];
	            if(isSafe(row+1,col,rooms) && rooms[row+1][col]==INF){
	                rooms[row+1][col] = rooms[row][col]+1;
	                q.add(new int[]{row+1,col});
	            }
	            if(isSafe(row-1,col,rooms) && rooms[row-1][col]==INF){
	                rooms[row-1][col] = rooms[row][col]+1;
	                q.add(new int[]{row-1,col});
	            }
	            if(isSafe(row,col+1,rooms) && rooms[row][col+1]==INF){
	                rooms[row][col+1] = rooms[row][col]+1;
	                q.add(new int[]{row,col+1});
	            }
	            if(isSafe(row,col-1,rooms) && rooms[row][col-1]==INF){
	                rooms[row][col-1] = rooms[row][col]+1;
	                q.add(new int[]{row,col-1});
	            }
	        }
	        
	    }
	    
	    private boolean isSafe(int row, int col, int[][] rooms){
	        return row >=0 && row < rooms.length && col>=0 && col <rooms[row].length;
	    }

}
