package com.data.google.microsoft;

public class InorderSuccessorBST2 {
	
	class Solution {
	    public Node inorderSuccessor(Node node) {
	        Node min = new Node(Integer.MAX_VALUE);
	        min.val = Integer.MAX_VALUE;
	        if(node.right!=null)
	          min = leftMost(node.right);
	        
	        if(node.parent!=null){
	            Node other = findBetterThanThisNode(node.parent,node.val);
	            min = min.val < other.val?min:other;
	        }
	        return min.val==Integer.MAX_VALUE?null:min;
	    }
	    
	    private Node leftMost(Node node){
	        while(node.left!=null){
	            node = node.left;
	        }
	        return node;
	    }
	    
	    private Node findBetterThanThisNode(Node node, int curr){
	        if(node.val > curr)
	            return node;
	        if(node.parent == null)
	            return new Node(Integer.MAX_VALUE);
	       return findBetterThanThisNode(node.parent,curr);
	    }
	}
	
	
public Node inorderSuccessor(Node node) {
        
        if(node!=null){
            if(node.right!=null){
                node=node.right;
                while(node.left!=null){
                    node = node.left;
                }
                return node;
            }
        }
        
        
        while(node!=null){
            if(node.parent!=null && node.parent.left == node)
                    return node.parent;    
                node = node.parent;
            
        }
        
        return null;
      
    }

}
