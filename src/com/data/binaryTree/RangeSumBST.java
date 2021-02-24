package com.data.binaryTree;

public class RangeSumBST {
    
    public int rangeSumBST(TreeNode root, int low, int high) {  
    return dfs(root,low,high)  ;  
        
    }
    
    private int dfs(TreeNode root, int low, int high){
        if(root == null )
            return 0;
        int ans = 0;
        if(root.val >=low && root.val <=high)
            ans+=root.val;
        if(root.val > low)
        	ans+=dfs(root.left,low,high);
        if(root.val < high)
        	ans+=dfs(root.right,low,high);
        return ans;
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
