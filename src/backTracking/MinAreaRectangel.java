package backTracking;

public class MinAreaRectangel {
	
	class Solution {
	    
	    class Point{
	        int x;
	        int y;
	        
	        public Point(int x, int y){
	            this.x =x;
	            this.y =y;
	        }
	        
	        @Override
	        public boolean equals(Object other){
	            Point p = (Point)other;
	            return this.x == p.x && this.y == p.y;
	        }
	        
	        @Override
	        public int hashCode(){
	            return Objects.hash(x,y);
	        }
	    }
	    
	    public int minAreaRect(int[][] points) {
	        if(points.length==0 || points[0].length==0) return 0;
	        Set<Point> seen = new HashSet<>();
	        int minArea = Integer.MAX_VALUE/10;
	        for(int[] p:points){
	            seen.add(new Point(p[0],p[1]));
	        }
	        
	        for(int i=0;i<points.length-1;i++){
	            for(int j=i+1;j<points.length;j++){
	                if(points[i][0]==points[j][0] || points[i][1]==points[j][1])
	                    continue;
	                
	                Point p1 = new Point(points[i][0],points[j][1]);
	                Point p2 = new Point(points[j][0],points[i][1]);
	                if(seen.contains(p1) && seen.contains(p2)){
	                    int currArea = Math.abs(points[i][0]-points[j][0])*Math.abs(points[i][1]-points[j][1]);
	                    if(minArea > currArea && currArea!=0)
	                        minArea =currArea;
	                }
	                
	            }
	        }
	        return minArea==Integer.MAX_VALUE/10?0:minArea;
	        
	    }
	}



	    
	    
	    

}
