package com.data.binaryTree;

import com.data.linkedList.ListNode;

public class SortedArrayToBST {
	
	 public TreeNode sortedArrayToBST(int[] nums) {
	        
	        int n = nums.length;
	        return dfs(nums,0,n-1);
	        
	    }
	    
	    private TreeNode dfs(int []nums,int low,int high){
	        if(low > high)
	            return null;
	        int mid =low+(high-low)/2;
	        TreeNode root = new TreeNode(nums[mid]);
	        root.left = dfs(nums,low,mid-1);
	        root.right = dfs(nums,mid+1,high);
	        return root;
	    }
	    //sorted linkedList to BST
	    ListNode head = null;
	    public TreeNode sortedListToBST(ListNode head) {
	        
	        int n = 0;
	        ListNode curr =head;
	        while(curr!=null){
	            curr = curr.next;
	            n++;
	        }
	        this.head = head;
	        return dfs(0,n-1);
	        
	    }
	    
	    private TreeNode dfs(int l,int r){
	        if(l>r)
	            return null;
	        
	        int mid = l+(r-l)/2;
	        TreeNode left = dfs(l,mid-1);
	        TreeNode root = new TreeNode(this.head.val);
	        root.left = left;
	        this.head = this.head.next;
	        root.right = dfs(mid+1,r);
	        return root;
	        
	    }

}
