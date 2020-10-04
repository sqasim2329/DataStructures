package com.data.binaryTree;

public class LCAofBST {
	
	public static void main(String args[]) {
		Node root = new Node(5); 
        root.left = new Node(4); 
        root.right = new Node(6); 
        root.left.left = new Node(3); 
        root.right.right = new Node(7); 
        root.right.right.right = new Node(8);
        int n1=3;
        int n2=8;
        Node node = findLCA(root,n1,n2);
        System.out.println(node!=null?node.data:-1);
	}
//O(N) TC and O(N)SC --> recursive stack
	private static Node findLCA(Node root,int n1, int n2) {
		if(root == null)
		return null;
		if(root.data < n1 && root.data < n2) {
			return findLCA(root.right,n1,n2);
		}
		else if(root.data > n1 && root.data > n2){
			return findLCA(root.left,n1,n2);
		}
		else
			return root;
	}
	
	//O(N)TC and O(1)SC
	private static Node findLCAItr(Node root,int n1, int n2) {
		while(root!=null) {
			if(root.data < n1 && root.data < n2) {
				root = root.right;
			}
			else if(root.data > n1 && root.data > n2) {
				root = root.left;
			}else {
				return root;
			}
		}
		
		return null;
	}

	
	
	

}
