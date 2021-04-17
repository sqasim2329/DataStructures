package com.data.google.microsoft;

public class ExclusiveTimeOfFunctions {
	
public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<int[]> stk = new Stack<>();
        int[] res = new int[n];
        for(String log:logs){
           String l[] =  log.split(":");
           int indx = Integer.valueOf(l[0]);
           int t = Integer.valueOf(l[2]);
            
           if(l[1].equals("start")) {
               stk.push(new int[]{indx,t});
           }else{
               int v = t-stk.pop()[1]+1;
               res[indx]+=v;
               if(!stk.isEmpty()) res[stk.peek()[0]]-=v;
           }
        }
        
        return res;
    }

}
