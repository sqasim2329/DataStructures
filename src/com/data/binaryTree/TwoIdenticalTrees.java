package com.data.binaryTree;

public class TwoIdenticalTrees {
	
	public static void main(String args[]) {
		Node root1 = new Node(1); 
        root1.left = new Node(2); 
        root1.right = new Node(3); 
        root1.left.left = new Node(4); 
        root1.left.right = new Node(5); 
        root1.right.left = new Node(6);
       
        Node root2 = new Node(1); 
        root2.left = new Node(2); 
        root2.right = new Node(3); 
        root2.left.left = new Node(4); 
        root2.left.right = new Node(5); 
        root2.right.left = new Node(6);
        
        Boolean flag = isIdentical(root1,root2);
        System.out.println(flag);
        
        
        
	}

	private static Boolean isIdentical(Node root1, Node root2) {
		if(root1==null && root2==null)
			return true;
		if(root1!=null && root2!=null && root1.data == root2.data)
			return isIdentical(root1.left,root2.left) && isIdentical(root1.right, root2.right);
		return false;
	}

}
