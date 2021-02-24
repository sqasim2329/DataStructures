package com.data.binaryTree;

class Solution {
    
    boolean areAllSame = true;
    int min = Integer.MAX_VALUE;
    int secMin = Integer.MAX_VALUE;
    
    public int findSecondMinimumValue(TreeNode root) {
     
        dfs(root);    
        return areAllSame?-1:secMin;
    }
    
    private void dfs(TreeNode root){
        if(root == null)
            return ;
        
        if(root.val < min)
            min =root.val;
        else if(min!=root.val && min < root.val && secMin >= root.val){
            areAllSame = false;
            secMin = root.val;
        }
        
        dfs(root.left);
        dfs(root.right);
    }