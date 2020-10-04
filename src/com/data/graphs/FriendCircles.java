package com.data.graphs;

public class FriendCircles {
	
	public int findCircleNum(int[][] m) {
        int count = 0;
        int n = m.length;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,m,vis);
                count++;
            }
        }
    return count;
        
    }
    
    
    private void dfs(int i,int[][] m,boolean[] vis){
        for(int j=0;j<m.length;j++){
            if(!vis[j] && m[i][j]==1){
                vis[j]=true;
                dfs(j,m,vis);
            }
        }
        
    }
	    
	    public static void main(String args[]) {
	    	FriendCircles f= new FriendCircles();
	    	int [][]m= {{1,1,0},{1,1,0},{0,0,1}};
	    	System.out.println(f.findCircleNum(m));
	    }
	

}
/********
 * imagine as adjacency matrix
 */