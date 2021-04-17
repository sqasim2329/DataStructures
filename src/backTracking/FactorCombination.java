package backTracking;

public class FactorCombination {
	class Solution {
	    public List<List<Integer>> getFactors(int n) {
	        
	        List<List<Integer>> res = new ArrayList<>();
	        if(n ==1)
	            return res;
	        List<Integer> ls = new ArrayList<>();
	        
	        backTrack(n,res,ls,2,n);
	        return res;
	    }
	    
	    
	    private void backTrack(int n, List<List<Integer>> res , List<Integer> ls, int indx,int cur){
	        if(cur == 1 ){
	            res.add(new LinkedList<>(ls));
	            return;
	        }
	        
	        if(cur < 1)
	            return;
	        
	        for(int i=indx;i<=n-1;i++){
	            if(cur % i != 0) continue;
	            ls.add(i);
	            backTrack(n,res,ls,i,cur/i);
	            ls.remove(ls.size()-1);
	        }
	    }
	}

}
