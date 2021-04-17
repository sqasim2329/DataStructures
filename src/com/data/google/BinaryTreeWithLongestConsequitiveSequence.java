package com.data.google;

public class BinaryTreeWithLongestConsequitiveSequence {
	
	
	class Response{
        int res=0;
    }
    
    public int longestConsecutive(TreeNode root) {
        Response res = new Response();
        dfs(root,res);
        return res.res;
        
    }
    
    private int dfs(TreeNode root, Response resp){
        if(root == null)
            return 0;
        
        
        
        int left = dfs(root.left,resp);
        int right = dfs(root.right,resp);
        
        if(root.left == null && root.right == null){
            resp.res = Math.max(resp.res,1);
            return 1;
        }
            
        
        int max =0;
        if(root.left!=null && root.val - root.left.val == -1 ){
            max = Math.max(left,max);
        }
        
        if(root.right!=null && root.val - root.right.val == -1 ){
            max = Math.max(right,max);
        }
        resp.res= Math.max(resp.res,max+1);
        return max+1;
        
        
    }
}


class Pair{
    int count;
    int res;
    
    public Pair(int count, int res){
        this.count = count;
        this.res = res;
    }
}

public int longestConsecutive(TreeNode root) {
    Pair result = dfs(root);
    return result.res;
    
}

private Pair dfs(TreeNode root){
    if(root == null)
        return new Pair(0,0);

    Pair left = dfs(root.left);
    Pair right = dfs(root.right);
    
    if(root.left == null && root.right == null){
        return new Pair(1,1);
    }
        
    int res = Math.max(left.res,right.res);
    int max =0;
    if(root.left!=null && root.val - root.left.val == -1 ){
        max = Math.max(left.count,max);
    }
    
    if(root.right!=null && root.val - root.right.val == -1 ){
        max = Math.max(right.count,max);
    }
    res= Math.max(res,max+1);
    return new Pair(max+1,res);
    
}
