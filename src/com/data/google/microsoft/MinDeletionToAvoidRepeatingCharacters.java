package com.data.google.microsoft;

public class MinDeletionToAvoidRepeatingCharacters {
	
public int minCost(String s, int[] cost) {
        
        Stack<Integer> stk = new Stack<>();
        int minCost = 0;
        for(int i=0;i<s.length();i++){
            if(!stk.isEmpty() && s.charAt(stk.peek()) == s.charAt(i)){
                if(cost[stk.peek()] < cost[i]){
                    minCost += cost[stk.pop()];
                    stk.push(i);
                }else{
                    minCost+=cost[i];
                }
            }else{
                stk.push(i);
            }
        }
        return minCost;
        
    }

}


class Solution {
    public int minCost(String s, int[] cost) {
        
        
        int maxCost = cost[0];
        int res = cost[0];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                res -=maxCost;
                maxCost = 0;
            }
            res +=cost[i];
            maxCost = Math.max(maxCost,cost[i]);
        }
        return res-maxCost;
    }
}



// aabaa
// 12341

// res = 1+2-2-0+4+1-4
// max =  4
