package com.data.binaryTree;

import java.util.LinkedList;
import java.util.List;

public class PrintNodePath {
	
	public boolean hasPath(TreeNode root) {
		List<Integer> ls = new LinkedList<>();
		int target = 5;
		return dfs(root,ls,target);
	}
	
	public  boolean  dfs(TreeNode root,List<Integer> ls, int target) {
		if(root ==  null)
			return false;;
		
		ls.add(root.val);
		if(root.val ==  target)
			return true;
		
		if(dfs(root.left,ls,target)|| dfs(root.right,ls,target))
			return true;
		
		ls.remove(ls.size()-1);
		return false;
	}

}
