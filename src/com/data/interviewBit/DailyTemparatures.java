package com.data.interviewBit;

public class DailyTemparatures {
	

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer>  stk = new Stack<>();
        int[] res = new int[T.length];
        for(int i=0;i<T.length;i++){
            while(!stk.isEmpty() && T[stk.peek()] < T[i]){
                int index = stk.pop();
                res[index] = i-index;
            }
            stk.push(i);
        }
            return res;
        }
    }

}
