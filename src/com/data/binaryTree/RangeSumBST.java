package com.data.binaryTree;

public class RangeSumBST {
    
    public int rangeSumBST(TreeNode root, int low, int high) {  
    return dfs(root,low,high)  ;  
        
    }
    
    private int dfs(TreeNode root, int low, int high){
    	if(root == null)
            return 0;
        int sum = 0;
        sum+=dfs(root.left,low,high);
        sum+=dfs(root.right,low,high);
        if(root.val>=low && root.val <=high){
            sum+=root.val;
        }
        return sum;
    }
    
    public int rangeSumBST(TreeNode root, int low, int high) {  
        int sum = 0;
        Stack<TreeNode> stk = new Stack<>();
        while(!stk.isEmpty() || root!=null){
            while(root!=null){
                stk.push(root);
                root = root.left;
            }
             root = stk.pop();
            if(root.val >= low && root.val <=high){
                sum+=root.val;
            }
            root = root.right;
        }
            return sum;
            
        }
  }
