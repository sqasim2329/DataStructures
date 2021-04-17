package com.data.binaryTree;

public class DistributeCoinsInBinaryTree {
	
	class Pair{
        int excessCoins ;
        int moves ;
        public Pair(int excessCoins,int moves){
            this.excessCoins =excessCoins;
            this.moves = moves;
        }
    }
    public int distributeCoins(TreeNode root) {
        Pair p = dfs(root);
        return p.moves;
    }
    
    private Pair dfs(TreeNode root){
        if(root == null)
            return new Pair(0,0);
        
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        int moves = Math.abs(left.excessCoins)+Math.abs(right.excessCoins)+left.moves+right.moves;
        int excessCoins = root.val+left.excessCoins+right.excessCoins-1;//-1 to include for this node also
        return new Pair(excessCoins,moves);
        
    }

}

/******
 * 
 * 
 * if(root == null) it does not require any  coins
 * if(root is leaf) then excess coins at this root = root.val + L+R-1//-1 to include root
 * 
 * 
 */