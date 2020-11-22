package com.data.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrder {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        
        
        Queue<TreeNode> stk = new LinkedList<>();
        stk.add(root);
        while(!stk.isEmpty()){
            int size = stk.size();
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = stk.poll();
                if(curr.left!=null)
                    stk.add(curr.left);
                
                if(curr.right!=null)
                    stk.add(curr.right);
                ls.add(curr.val);
            }
            res.add(0,ls);
        }
        
        return res;
        
        
    }
    
    private void dfs(TreeNode root,List<List<Integer>> res,int level){
        if(root == null)
            return ;
        
        if(res.size()<=level)
        {
            res.add(0,new LinkedList<Integer>());
        }
        
        List<Integer> ls = res.get(res.size()-1-level);
        ls.add(root.val);
        dfs(root.left,res,level+1);
        dfs(root.right,res,level+1);
    }

}
