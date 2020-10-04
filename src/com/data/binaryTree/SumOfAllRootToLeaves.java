package com.data.binaryTree;

public class SumOfAllRootToLeaves {
	
	class Sum{
        int s;
    }
    public int sumNumbers(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        Sum s = new Sum();
        s.s=0;
        dfs(root,sb,s);
        return s.s;
    }
    
    
    private void dfs(TreeNode root,StringBuilder sb,Sum sum){
        if(root == null)
            return;
        
        sb.append(root.val);
        if(root.left==null && root.right == null)
        {
            sum.s+=Integer.parseInt(sb.toString());
        }else{
            dfs(root.left,sb,sum);
            dfs(root.right,sb,sum);
        }
        sb.deleteCharAt(sb.toString().length()-1);       
    }

}
