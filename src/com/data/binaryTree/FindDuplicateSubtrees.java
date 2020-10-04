package com.data.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        dfs(root,map,res);
        return res;
    }
    
    private String dfs(TreeNode root,Map<String,Integer> map,List<TreeNode> res){
        if(root == null)
            return "x,";
        String left = dfs(root.left,map,res);
        String right = dfs(root.right,map,res);
        String data = String.valueOf(root.val)+","+left+right;
        map.put(data,map.getOrDefault(data,0)+1);
        if(map.get(data) == 2)
            res.add(root);  
        
        return data;
    }

}
