package com.data.arrays;

public class CountSubarrayWith1And0 {
	
public int findMaxLength(int[] nums) {
        
        Map<Integer,Integer> prefix = new HashMap<>();
        int sum =0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum+=-1;
            }else{
                sum+=1;
            }
            
            if(sum == 0)
                max = Math.max(i+1,max);
            if(prefix.containsKey(sum)){
                max =Math.max(max,i-prefix.get(sum));
            }
            prefix.putIfAbsent(sum,i);
        }
        
        return max;
        
    }

}
