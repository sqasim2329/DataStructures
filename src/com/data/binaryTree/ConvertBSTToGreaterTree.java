package com.data.binaryTree;

import java.util.Stack;
// iterative methods works only on BST
public class ConvertBSTToGreaterTree {
	

	public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root;
        while(!stk.isEmpty() || node!=null){
            while(node!=null){
                stk.push(node);
                node = node.right;
            }
            node = stk.pop();
            node.val = sum + node.val;
            sum = node.val;
            node = node.left;
        }
        return root;
    }

}
