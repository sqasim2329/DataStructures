package com.data.graphs;

public class FloodFillAlgorithm {
	
	    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        
	        dfs(image,sr,sc,newColor,image[sr][sc]);
	        return image;
	    }
	    
	    private void dfs(int [][]image,int r,int c, int color, int oldcolor){
	        if(r< 0 || c < 0 || r >= image.length || c >= image[r].length  || image[r][c]==color || image[r][c]!=oldcolor)
	            return;
	        image[r][c]=color;
	        dfs(image,r+1,c,color,oldcolor);
	        dfs(image,r-1,c,color,oldcolor);
	        dfs(image,r,c+1,color,oldcolor);
	        dfs(image,r,c-1,color,oldcolor);
	        
	        
	    }

}
