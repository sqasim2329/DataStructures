package com.data.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

}
