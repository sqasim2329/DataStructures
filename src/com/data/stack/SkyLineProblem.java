package com.data.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SkyLineProblem {
	
	
	    class Building implements Comparable<Building>{
	        boolean isStart = false;
	        int x;
	        int height;
	        
	        public Building(int x, int height,boolean isStart){
	            this.x = x;
	            this.height = height;
	            this.isStart = isStart;
	        }
	        
	        public int compareTo(Building other){
	            if(this.x != other.x)
	                return this.x - other.x;
	            
	            return (this.isStart?-this.height:this.height)-(other.isStart?-other.height:other.height);
	        }

	    }
	    
	    public List<List<Integer>> getSkyline(int[][] buildings) 
	    { 
	        List<Building> buildingPoints = new ArrayList<>();
	        for(int[] building:buildings){
	            Building start = new Building(building[0],building[2],true);
	            Building end = new Building(building[1],building[2],false);
	            buildingPoints.add(start);
	            buildingPoints.add(end);
	        }
	    
	        Collections.sort(buildingPoints);
	        List<List<Integer>> result = new ArrayList<>();
	        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
	        q.add(0);
	        int max = 0;
	        for(Building building:buildingPoints){
	            if(building.isStart){
	                q.add(building.height);
	            }else{
	                q.remove(building.height);
	            }
	            
	            if(max!=q.peek()){
	                max = q.peek();
	                List<Integer> point = new ArrayList<>();
	                point.add(building.x);
	                point.add(max);
	                result.add(point);
	            }
	        }
	        
	        return result;
	    
	        
	    }
	
	
	public static void main(String args[]) {
		int[][] buidling = {{0,2,3},{2,5,3}};
		SkyLineProblem skl = new SkyLineProblem();
		skl.getSkyline(buidling);
	}

}
