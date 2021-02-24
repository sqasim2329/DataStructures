package com.data.binaryTree;

import java.util.Stack;

public class KthSmallestElementInBST {
	
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        while(!stk.isEmpty() || root!=null){
            while(root!=null){
                stk.push(root);
                root = root.left;
            }
            
            root = stk.pop();
            k--;
            if(k == 0)
                return root.val;
            root = root.right;
        }
        
        return -1;
        
    }

}


//https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/--read follow up