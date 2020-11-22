package com.data.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class FlipEquivalentBinaryTrees {
	
	class Solution {
	    class Pair{
	        Integer left;
	        Integer right;
	        public Pair(Integer left,Integer right){
	            this.left =left;
	            this.right = right;
	        }
	    }
	    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
	        Map<Integer,Pair> map1 = new HashMap<>();
	        Map<Integer,Pair> map2 = new HashMap<>();
	        
	        dfs(root1,map1);
	        dfs(root2,map2);
	        
	        if(map1.size()!=map2.size())
	            return false;
	        
	        for(Map.Entry<Integer,Pair> e:map1.entrySet()){
	            if(map2.containsKey(e.getKey())){
	                Pair p1 = e.getValue();
	                Pair p2 = map2.get(e.getKey());
	                if((p1.left==p2.left || p1.left == p2.right) &&(p1.right==p2.right || p1.right ==p2.left)){        
	                    continue;
	                }else{
	                    return false;
	                }
	            }else{
	                return false;
	            }
	        }
	        
	        return true;
	        
	    }
	    
	    private void dfs(TreeNode root, Map<Integer,Pair> map){
	        if(root == null)
	            return;
	        
	        TreeNode left = root.left;
	        TreeNode right = root.right;
	        map.put(root.val,new Pair(left!=null?left.val:null,right!=null?right.val:null));
	        dfs(root.left,map);
	        dfs(root.right,map);
	    }
	}

}
