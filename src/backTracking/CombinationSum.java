package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CombinationSum { 
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
    
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ls = new ArrayList<>();
    backTrack(res,candidates,target,0,ls,0);
    return res;
    
}

	private void backTrack(List<List<Integer>> res, int[] candidates, int target, int sum, List<Integer> ls,
			int start) {

		if (sum == target) {
			res.add(new LinkedList<>(ls));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (sum < target) {
				ls.add(candidates[i]);
				backTrack(res, candidates, target, sum + candidates[i], ls, i);
				ls.remove(ls.size() - 1);
			}
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	    
	    List<List<Integer>> res = new ArrayList<>();
	    List<Integer> ls = new ArrayList<>();
	    Arrays.sort(candidates);
	    backTrack(candidates,target,ls,res,0);
	    return res;
	}

	private void backTrack(int[] cand, int target,List<Integer> ls,List<List<Integer>> res, int indx){
	    
	    
	    
	    if(target < 0)
	        return;
	    
	    if(target == 0)
	    {
	        res.add(new ArrayList<>(ls));
	        return;
	    }
	    
	    
	    
	    for(int i=indx;i<cand.length;i++){
	        if(i > indx && cand[i]==cand[i-1]) continue;
	        ls.add(cand[i]);
	        backTrack(cand,target-cand[i],ls,res,i+1);
	        ls.remove(ls.size()-1);
	    }
	    
	    
	}
	
	
	
	    public List<List<Integer>> combinationSum3(int k, int n) {
	        
	        List<List<Integer>> res = new ArrayList<>();
	        List<Integer> ls = new ArrayList<>();
	        backTrack(k,n,ls,res,1);
	        return res;
	    }
	    
	    private void backTrack(int k, int n,List<Integer> ls, List<List<Integer>> res, int indx){
	         
	        if(n == 0 && k==0){
	         res.add(new ArrayList<>(ls));
	         return;
	        }
	        
	        if(k <=0 || indx > 9 || n < 0)
	            return ;
	        
	        
	        for(int i=indx;i<10;i++){
	            ls.add(i);
	            backTrack(k-1,n-i,ls,res,i+1);
	            ls.remove(ls.size()-1);
	        }

	    }
	    
	    
	    class Solution {
	        Map<Integer,Integer> dp = new HashMap<>();
	        public int combinationSum4(int[] nums, int target) {
	            
	            if(dp.containsKey(target))
	                return dp.get(target);
	            if(target == 0){
	                return 1;
	            }
	            
	            if(target < 0)
	                return 0;
	            
	            int count = 0;
	            for(int i = 0; i< nums.length;i++){
	                count+=combinationSum4(nums,target-nums[i]);
	            }
	            dp.put(target,count);
	            return count;
	            
	            
	        }
	    }

}


