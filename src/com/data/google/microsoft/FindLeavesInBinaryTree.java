package com.data.google.microsoft;

public class FindLeavesInBinaryTree {
	
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while(root!=null){
        List<Integer> ls = new ArrayList<>();
        root = dfs(root,ls);
        res.add(ls);    
        }
        return res;
    }
    
    
    private TreeNode dfs(TreeNode root,List<Integer> ls){
        if(root == null)
            return null;
        
        if(root.left ==null && root.right == null){
            ls.add(root.val);
            return null;
        }
            
        
        root.left = dfs(root.left,ls);
        root.right = dfs(root.right,ls);
        return root;
    }
    
    class Solution {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(root,res);
            return res;
        }
        
        
        private int dfs(TreeNode root,List<List<Integer>> res){
            if(root == null)
                return -1;
            
            int lh =dfs(root.left,res);
            int rh =dfs(root.right,res);
            int h = 1+ Math.max(lh,rh);
            if(res.size() <= h){
                res.add(new LinkedList<>());
            }
            res.get(h).add(root.val);
            return h;
        }

}
