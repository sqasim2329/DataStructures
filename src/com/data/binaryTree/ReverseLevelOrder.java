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

}
