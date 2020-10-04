package com.data.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
	
	  // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null)
            return "null,";
        
        String left = serialize(root.left);
        String right = serialize(root.right);
        
        return root.val+","+left+right;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String split[] = data.split(",");
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(split));
        return solve(q);
        
    }
    
    private TreeNode solve(Queue<String> q){
        String ele = q.poll();
        if(ele.equals("null"))
            return null;
        
        TreeNode node = new TreeNode(Integer.valueOf(ele));
        node.left = solve(q);
        node.right = solve(q);
        return node;
    }

}
