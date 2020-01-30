package com.data.binaryTree;

public class Height {
	
//	https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
//	https://www.geeksforgeeks.org/decode-string-recursively-encoded-count-followed-substring/
//	https://www.geeksforgeeks.org/compute-average-two-numbers-without-overflow/
//	https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
//	https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
//		https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
//	https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
//	https://www.geeksforgeeks.org/find-two-rectangles-overlap/
//	https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
//	https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
	public static void main(String args[]) {
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7);
        System.out.println(getHeightOfTree(root));
	}

	private static int getHeightOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		
		int hl = getHeightOfTree(root.left);
		int hr = getHeightOfTree(root.right);
		
		int height = Math.max(hl, hr)+1;
		root.hd = height; 
		return height;
		
	}

}
