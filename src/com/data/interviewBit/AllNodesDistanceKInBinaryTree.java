package com.data.interviewBit;

public class AllNodesDistanceKInBinaryTree {
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
	        
	        Map<TreeNode,TreeNode> parent = new HashMap<>();
	        dfs(root,parent);
	        Queue<TreeNode> q = new LinkedList<>();// bfs both child and parent nodes
	        Set<TreeNode> seen = new HashSet<>();// used for checking if already visited//parent can have two children
	        int currentDistance = 0;
	        List<Integer> result = new ArrayList<>();
	        q.add(target);
	        seen.add(target);
	        while(!q.isEmpty()){
	            int size =q.size();
	            if(currentDistance == K){
	                while(!q.isEmpty()){
	                    result.add(q.poll().val);
	                }
	                return result;
	            }
	            for(int i=0;i<size;i++){
	                TreeNode node = q.poll();
	                if(node.left!=null && seen.add(node.left)){
	                    q.add(node.left);
	                }
	                
	                if(node.right!=null && seen.add(node.right)){
	                    q.add(node.right);
	                }
	                
	                if(parent.get(node)!=null && seen.add(parent.get(node))){
	                    q.add(parent.get(node));
	                }
	            }
	            currentDistance++;
	        }
	        
	        return result;
	        
	    }
	    
	    private void dfs(TreeNode root,Map<TreeNode,TreeNode> parent){
	        if(root == null)
	            return;
	        if(root.left!=null)
	        parent.put(root.left,root);
	        
	        if(root.right!=null)
	        parent.put(root.right,root);
	        
	        dfs(root.left,parent);
	        dfs(root.right,parent);
	    }
	}

}
