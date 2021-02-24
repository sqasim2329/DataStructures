package com.data.binaryTree;

public class UniqueBST {
	
	public class Solution {
	    public int numTrees(int n) {
	        int[] dp = new int[n + 1];
	        dp[0] = 1;
	        dp[1] = 1;
	        for (int i = 2; i <= n; i++) {
	            for (int j = 1; j <= i; j++) {
	                dp[i] += dp[j - 1]*dp[i - j];
	            }
	        }
	        return dp[n];
	    }
	}
	//G(3)=F(1,3)+F(2,3)+F(3,3)
	//F(1,3)=G(i-1)*G(n-i)
	class Solution {
	    public List<TreeNode> generateTrees(int n) {
	        if(n==0)
	            return new ArrayList<>();
	        return dfs(1,n);
	    }
	    
	    private List<TreeNode> dfs(int low, int high){
	        List<TreeNode> trees = new ArrayList<>();
	        if(low > high){
	            trees.add(null);
	            return trees;
	        }
	        
	        for(int i=low;i<=high;i++){
	            List<TreeNode> leftSubtrees = dfs(low,i-1);
	            List<TreeNode> rightSubtrees = dfs(i+1,high);
	            for(TreeNode leftNode : leftSubtrees){
	                for(TreeNode rightNode : rightSubtrees){
	                    TreeNode root = new TreeNode(i);
	                    root.left = leftNode;
	                    root.right = rightNode;
	                    trees.add(root);
	                }
	            }
	        }
	        return trees;
	        
	    }
	    
	    
	}

}
