package com.data.graphs;
//https://www.geeksforgeeks.org/minimum-steps-needed-to-cover-a-sequence-of-points-on-an-infinite-grid/
public class MinStepsneedToCover {
	
	static class Point{
		int a;
		int b;
		
		public Point(int a, int b) {
			this.a=a;
			this.b=b;
		}
	}
	
	private void findMinSteps(Point[] points) {
		int steps=0;
		for(int i=0;i<points.length-1;i++) {
			steps += shortestPath(points[i],points[i+1]);
			
		}
		
		System.out.println(steps);
	}

	private int shortestPath(Point p, Point q) {
		
		int dx= Math.abs(p.a-q.a);
		int dy =Math.abs(p.b-q.b);
		
		return Math.max(dx, dy);
	}
	
	
	public static void main(String args[]) {
		MinStepsneedToCover g= new MinStepsneedToCover();
		Point arr[] = new Point[4]; 
	    arr[0] = new Point(4, 6); 
	    arr[1] = new Point(1, 2); 
	    arr[2] = new Point(4, 5); 
	    arr[3] = new Point(10, 12); 
	    g.findMinSteps(arr);
	}

}
