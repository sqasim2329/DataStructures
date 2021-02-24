package com.data.divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
O(N * 2^N)
public class Subsets {
	
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(ls,res,nums,0);
        return res;
    }
    
    private void backTrack(List<Integer> ls, List<List<Integer>> res, int[] nums,int start){
        if(start == nums.length)
        {
            res.add(new ArrayList<Integer>(ls));
            return;
        }
         res.add(new ArrayList<>(ls));
        
        for(int i=start;i<nums.length;i++){
            ls.add(nums[i]);
            backTrack(ls,res,nums,i+1);
            ls.remove(ls.size()-1);
        }
    }
    
    public static void main(String args[]) {
    	int nums[] = {2,4,9};
    	Subsets ss= new Subsets();
    	System.out.println(ss.subsets(nums));
    }

}

class Subsets2{

public List<List<Integer>> subsetsWithDup(int[] nums) {
    
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ls = new ArrayList<>();
    Arrays.sort(nums);
    backTrack(ls,res,nums,0);
    return res;
}

private void backTrack(List<Integer> ls, List<List<Integer>> res,int[] nums, int start){
    
    if(start == nums.length){
        res.add(new ArrayList<>(ls));
        return;
    }
    
    res.add(new ArrayList<>(ls));
    
    for(int i=start;i<nums.length;i++){
        if(i>start && nums[i]==nums[i-1]) continue;
        ls.add(nums[i]);
        backTrack(ls,res,nums,i+1);
        ls.remove(ls.size()-1);
    }
 }
}