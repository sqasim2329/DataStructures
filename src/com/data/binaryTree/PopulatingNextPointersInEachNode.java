package com.data.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

//O(n) time O(1) space

//O(n) O(n) use a single queue each time determine the size while (size > 0) keep on assignig values
//this is for perfect binary tree
public class PopulatingNextPointersInEachNode {
	
	class Solution {
	    public TreeNode connect(TreeNode root) {
	        
	        dfs(root,null);
	        return root;
	        
	    }
	    
	    private void dfs(TreeNode root, TreeNode next){
	        if(root == null)
	            return ;
	        
	        root.next = next;
	        dfs(root.left,root.right);
	        dfs(root.right,next!=null?next.left:next);
	        return;
	    }
	}

}
//this is for a normal tree// study 0(1) solution
class Solution {
    public TreeNode connect(TreeNode root) {
        
        if (root == null) {
            return root;
        }
        
        // Initialize a queue data structure which contains
        // just the root of the tree
        Queue<TreeNode> Q = new LinkedList<TreeNode>(); 
        Q.add(root);
        
        // Outer while loop which iterates over 
        // each level
        while (Q.size() > 0) {
            
            // Note the size of the queue
            int size = Q.size();
            
            // Iterate over all the nodes on the current level
            for(int i = 0; i < size; i++) {
                
                // Pop a node from the front of the queue
            	TreeNode node = Q.poll();
                
                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only 
                // don't establish next pointers beyond the end
                // of a level
                if (i+1 < size) {
                    node.next = Q.peek();
                }
                
                // Add the children, if any, to the back of
                // the queue
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }
        
        // Since the tree has now been modified, return the root node
        return root;
    }
}
