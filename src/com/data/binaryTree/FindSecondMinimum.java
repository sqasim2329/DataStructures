package com.data.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    
    public int findSecondMinimumValue(TreeNode root) {
     
    	Queue<TreeNode> q = new LinkedList<>();
        int min = root.val;
        int secMin = root.val;
        q.add(root);
        while(!q.isEmpty()){
            
            TreeNode node = q.poll();
            if((node.val > min && min==secMin)||(node.val < secMin && min!=node.val)){
                secMin = node.val;
            }
            
            if(node.left!=null)
                q.add(node.left);
            
            if(node.right!=null)
                q.add(node.right);
            
        }
        
        return min==secMin?-1:secMin;
    }
    
 
    
}