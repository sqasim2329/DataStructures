package com.data.binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PairsInBST {
	
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
	    public boolean findTarget(TreeNode root, int k) {
	        Set<Integer> set= new HashSet<>();
	        return checkIfPairExists(root,k,set)>0;
	        
	        
	    }
	    
	    
	    public int checkIfPairExists(TreeNode root, int k, Set<Integer> set){
	        if(root==null) return 0;
	        
	        if(set.contains(root.val))
	            return 1;
	        set.add(k-root.val);
	        return checkIfPairExists(root.left,k,set) + checkIfPairExists(root.right,k,set); 
	    }
	}
	
	
	private int countpairGreaterThanK(TreeNode root, int k) {
		List<Integer> ls = new ArrayList<>();
		inorder(root,ls);
		int pairs =0;
		int i=0, j=ls.size()-1;
		while(i < j) {
			if(ls.get(i)+ls.get(j)>k) {
				pairs+=j-i;
				for(int m=i;m<j;m++)
				System.out.println(ls.get(m)+"---"+ls.get(j));//if need to print
				j--;
			}else {
				i++   ;
			}
		}
		
		return pairs;
	
	}


	private void inorder(TreeNode root, List<Integer> ls) {
		if(root == null)
			return ;
		
		inorder(root.left,ls);
		ls.add(root.val);
		inorder(root.right,ls);
	}

}



class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        dfs(root1,set);
        return dfsHelper(root2,set,target);
        
    }
    
    private void dfs(TreeNode root,Set<Integer> set){
        if(root == null)
            return ;
        set.add(root.val);
        dfs(root.left,set);
        dfs(root.right,set);
    }
    
    private boolean dfsHelper(TreeNode root,Set<Integer> set,int target){
        if(root == null)
            return false;
        
        if(set.contains(target-root.val))
            return true;
        
        return dfsHelper(root.left,set,target) || dfsHelper(root.right,set,target);
    }
