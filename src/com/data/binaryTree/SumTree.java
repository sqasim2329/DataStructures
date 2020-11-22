package com.data.binaryTree;

public class SumTree {
	
	class Tree
	{
	    class Sum{
	        int s;
	    }
	    
		boolean isSumTree(Node node)
		{   Sum s = new Sum();
		    return dfs(node,s);
		}
		
		
		private boolean dfs(Node node,Sum s){
		    if(node == null)
		    {
		        s.s =0;
		        return true;
		    }
		    Sum lsum = new Sum();
		    Sum rsum = new Sum();
		    boolean left = dfs(node.left,lsum);
		    boolean  right = dfs(node.right,rsum);
		    
		    if(node.left == null && node.right == null)
		    {
		    	s.s = node.data;
		    	return true;
		    }
		    else{
		        int ls = lsum.s;
		        int rs = rsum.s;
		        s.s = node.data + ls+ rs;
		        if(ls+rs != node.data)
		        {
		            return false;
		        }
		    }
		    return left && right;
		    
		}
	}

}
