package com.data.google.microsoft;
//O(n * k2)
public class PaintHouse2 {
	
	 public int minCostII(int[][] costs) {

	        Map<String,Integer> map = new HashMap<>();
	        return solve(costs,0,-1,map);
	    }
	    
	    private int solve(int[][] costs,int house,int prevColor,Map<String,Integer> map){
	        String key = String.valueOf(house)+"|"+String.valueOf(prevColor);
	        if(map.containsKey(key))
	            return map.get(key);
	        
	        if(house == costs.length)
	            return 0;
	        
	        int min = Integer.MAX_VALUE;
	        for(int i = 0;i<costs[house].length;i++){
	            if(prevColor == i) continue;
	            int curr = solve(costs,house+1,i,map);
	            min = Math.min(curr+costs[house][i],min);
	        }
	            map.put(key,min);
	            return map.get(key);
	    }
	    
	    public int minCostII(int[][] costs) {
	        int k= costs[0].length;
	        int min1 = -1; int min2 =-1;
	        for(int i=0;i<costs.length;i++){
	            int last1 = min1;
	            int last2 = min2;
	            min1=-1;
	            min2=-1;
	            for(int j=0;j<k;j++){
	                if(j!=last1)
	                    costs[i][j]+=last1< 0?0:costs[i-1][last1];
	                else
	                    costs[i][j]+=last2<0 ?0:costs[i-1][last2];
	                
	                if(min1 < 0 || costs[i][j] < costs[i][min1]){
	                    min2 =min1;
	                    min1 =j ;
	                }else if(min2 < 0 || costs[i][j] < costs[i][min2])
	                    min2=j;
	            }
	        }
	        
	        return costs[costs.length-1][min1];
	    }

}
