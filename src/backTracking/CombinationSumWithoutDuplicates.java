package backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumWithoutDuplicates {
	
	class Solution {
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> res= new ArrayList<>();
	        StringBuffer sb = new StringBuffer();
	        List<Integer> ls = new ArrayList<>();
	        backTrack(candidates,target,0,res,ls);
	        return res;
	        
	    }
	    
	    
	    private void backTrack(int[] cand,int target, int index, List<List<Integer>> res,List<Integer> ls){
	        if(target == 0){
	            res.add(new ArrayList<>(ls));
	            return;
	        }
	        
	        if(target < 0 || index >=cand.length)
	            return;
	        
	        for(int i=index;i<cand.length;i++){
	            ls.add(cand[i]);
	            backTrack(cand,target-cand[i],i,res,ls);
	            ls.remove(ls.size()-1);
	        }
	    }
	}

}
