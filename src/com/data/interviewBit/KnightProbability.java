package com.data.interviewBit;
//give tim elimit, there is an efficient solution for this suing dp
public class KnightProbability {
	
	class Solution {
	    
	    private int[][] directions = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
	    class Pair{
	        int row;
	        int col;
	        double prob;
	        
	        public Pair(int row, int col,double prob){
	            this.row = row;
	            this.col = col;
	            this.prob = prob;
	        }
	    }
	    
	    public double knightProbability(int N, int K, int r, int c) {
	        Set<String> set = new HashSet<>();
	        double prob = 1/8d;
	        Queue<Pair> q = new LinkedList<>();
	        q.add(new Pair(r,c,1));
	        double finalProbability = 0d;
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int i=0;i<size;i++){
	                Pair tmp = q.poll();
	                if(K == 0)
	                    finalProbability+=tmp.prob;
	                else{
	                    for(int j=0;j<directions.length;j++){
	                        int nr = tmp.row+directions[j][0];
	                        int nc = tmp.col+directions[j][1];
	                        if(nr >=0 && nr < N && nc >=0 && nc < N){
	                            q.add(new Pair(nr,nc,((prob)*tmp.prob)));
	                        }
	                    }
	                }
	            }
	            K--;
	        }
	        return finalProbability;
	        
	    }
	}

}
