package com.data.avlTree;

public class AvlTreeMain {
	
	public static void main(String[] args) {

		// Constructor
		AvlTree tree = new AvlTree();
		
		// Insert values in AVL Tree
		
		
		tree.insert(30);
		
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(50);
		tree.insert(25);
		
//		tree.levelOrderTraversal();
		tree.printTreeGraphically();
//		
//		tree.delete(5);//LL Condition
//		tree.printTreeGraphically();
//		
//		tree.insert(2);
//		tree.printTreeGraphically();
//		
//		tree.delete(4);//LR Condition
//		tree.printTreeGraphically();
//		
//		tree.insert(20);
//		tree.delete(65);//RR Condition
//		tree.printTreeGraphically();
//		
//		tree.insert(40);
//		tree.delete(20);//RL Condition
//		tree.printTreeGraphically();
	}


}
