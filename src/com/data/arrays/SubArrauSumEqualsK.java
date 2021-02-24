package com.data.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrauSumEqualsK {
	
	public static void main(String args[]) {
		int []nums= {1,1,1};
		Map<Integer,Integer> map = new HashMap<>();
		int sum =0;
		int k=2;
		int res = 0;
		map.put(sum,1);//since we have seen 0 once
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			if(map.containsKey(sum-k)) {
				res+=map.get(sum-k)     ;
			}
			map.put(sum,map.getOrDefault(sum, 0)+1);
		}
		
		System.out.println(res);
	}

}
//Maximum Size Subarray Sum Equals k
public int maxSubArrayLen(int[] nums, int k) {
    
    Map<Integer,Integer> map = new HashMap<>();
    int sum =0;
    map.put(sum,-1);
    int max =0;
    for(int i=0;i<nums.length;i++){
        sum+=nums[i];
        if(nums[i]==k)
            max = Math.max(max,1);
        
        if(sum==k)
            max = Math.max(max,i-map.get(sum-k));
        if(map.containsKey(sum-k)){
            max = Math.max(max,i-map.get(sum-k));
        }
                map.putIfAbsent(sum,i);
        

    }
    return max;
    
    
}


//subarray-sums-divisible-by-k
Map<Integer,Integer> map = new HashMap<>();
int sum = 0;
int count =0;
map.put(sum,1);
for(int i=0;i<A.length;i++){
    sum+=A[i];
    if(K!=0) 
        sum =sum%K;
    if(sum < 0) sum+=K;
    if(map.containsKey(sum))
        count+=map.get(sum);
    map.put(sum,map.getOrDefault(sum,0)+1);
}
return count;