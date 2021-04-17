package com.data.binaryTree;

public class BinaryTreesWithCamera {
	
	class Pair{
        int code;
        int res;
        public Pair(int code, int res){
            this.code =code;
            this.res = res;
        }
    }
    public int minCameraCover(TreeNode root) {
        Pair p =  dfs(root);
        return (p.code < 1?1:0)+p.res;
    }
    
    
    private Pair dfs(TreeNode root){
        if(root == null)
            return new Pair(2,0);
        
        Pair left = dfs(root.left); 
        Pair right = dfs(root.right);
        int res = 0;
        if(left.code == 0 || right.code == 0){
            res = left.res+right.res+1;
            return new Pair(1,res);
        }
        
        res = left.res+right.res;
        if(left.code ==1 || right.code == 1)
            return new Pair(2,res);
        
          return new Pair(0,res);
            
    }

}

//0 --> not covered ,1 --> parent of leaf and we will place the camera at parent rather rhan leaf since it will cover parent and leaf
//  2 --> already covered.
//1. leaf will be denoted as 0;
//2. null will be denoted as 2;
//3. parent of leaf will be 1
//4. if node's immediate child is parent of leaf , this node is also covered
