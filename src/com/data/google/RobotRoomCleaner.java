package com.data.google;

public class RobotRoomCleaner {
	/**
	 * // This is the robot's control interface.
	 * // You should not implement it, or speculate about its implementation
	 * interface Robot {
	 *     // Returns true if the cell in front is open and robot moves into the cell.
	 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
	 *     public boolean move();
	 *
	 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
	 *     // Each turn will be 90 degrees.
	 *     public void turnLeft();
	 *     public void turnRight();
	 *
	 *     // Clean the current cell.
	 *     public void clean();
	 * }
	 */

	class Solution {
	                //clockwise                    
	    private int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	    
	    public void cleanRoom(Robot robot) {
	        Set<String> seen = new HashSet<>();
	        backTrack(robot,0,0,0,seen);
	    }
	    
	    private void backTrack(Robot robot,int row, int col,int direcIndex,Set<String> seen){
	        String key =row+"*"+col;
	        seen.add(key);
	        robot.clean();
	        for(int i=0;i<directions.length;i++){
	            int dir = (direcIndex+i)%4;
	            int nrow = row+directions[dir][0];
	            int ncol = col+directions[dir][1];
	            key = nrow+"*"+ncol;
	            if(!seen.contains(key) && robot.move()){
	                backTrack(robot,nrow,ncol,dir,seen);
	                fallBack(robot);
	            }
	            robot.turnRight();
	        }
	    }
	    
	    private void fallBack(Robot robot){
	        robot.turnRight();
	        robot.turnRight();
	        robot.move();
	        robot.turnRight();
	        robot.turnRight();
	    }
	}
}
