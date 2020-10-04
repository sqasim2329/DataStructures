package com.data.greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuatuinOfArray {
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res,nums,0);
        return res;
    }
    
    private void backTrack(List<List<Integer>> res,int[] nums,int start){
        if(start >= nums.length){
            List<Integer> ls = new ArrayList<>();
            for(int i:nums){
                ls.add(i);
            }
            res.add(ls);
            return;
        }
        
        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            backTrack(res,nums,start+1);
            swap(nums,start,i);
        }
    }
    
    private void swap(int[]nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
//At recursion level 0, we have [1] + permute[1,2], [1] + permute[1,2], [2] + permute[1,1]
// since 1 has appeared before so no need to continue for the cobination
class Permutations2{
public List<List<Integer>> permuteUnique(int[] nums){
        
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res,nums,0);
        return res;
    }
    
    private void backTrack(List<List<Integer>> res,int[] nums,int start){
        if(start ==  nums.length){
            List<Integer> ls = new ArrayList<>();
            for(int i:nums){
                ls.add(i);
            }
            res.add(ls);
            return;
        }
        
        Set<Integer> appeared = new HashSet<>();
        for(int i=start;i<nums.length;i++){
            if(appeared.add(nums[i])){
                swap(nums,start,i);
                backTrack(res,nums,start+1);
                swap(nums,start,i);
            }
        }

    }

    private void swap(int nums[],int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
