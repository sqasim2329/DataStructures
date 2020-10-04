package com.data.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
	
	 public String serialize(TreeNode root) {
		    StringBuilder sb = new StringBuilder();
		    dfs(root,sb);
		    return sb.toString();
		    }
		    
		    private void dfs(TreeNode root,StringBuilder sb){
		        if(root == null)
		            return;
		        
		        sb.append(root.val).append(",");
		        dfs(root.left,sb);
		        dfs(root.right,sb);
		    }
		    
		    // Decodes your encoded data to tree.
		    public TreeNode deserialize(String data) {
		        
		        String s[]= data.split(",");
		        Queue<String> q = new LinkedList<>(Arrays.asList(s));
		        return dfs(q);
		    }
		    
		    private TreeNode dfs(Queue<String> q){
		        if(q.isEmpty()) return null;
		        int val = Integer.parseInt(q.poll());
		        TreeNode root = new TreeNode(val);
		        Queue<String> smallQueue = new LinkedList<>();
		        while(!q.isEmpty() && root.val > Integer.parseInt(q.peek())){
		            smallQueue.add(q.poll());
		        }
		        root.left = dfs(smallQueue);
		        root.right = dfs(q);
		        return root;
		    }

}
