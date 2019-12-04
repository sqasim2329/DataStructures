package com.data.avlTree;

import java.util.LinkedList;
import java.util.Queue;

public class AvlTree {
	
	BinaryNode root ;
	
	public AvlTree(){
		root = null;
	}
	
	public void insert(int val) {
		
		root = insert(root,val); 
		
	}

	private BinaryNode insert(BinaryNode currentNode, int val) {
		// TODO Auto-generated method stub
		if(currentNode == null) {
			currentNode = createNewNode(val);
			return currentNode;
		}
		
		else if(val <= currentNode.getValue()) {
			currentNode.setLeft(insert(currentNode.getLeft(),val));
		}
		else {
			currentNode.setRight(insert(currentNode.getRight(),val));
		}
		
		return performAvlSpecificOperations(currentNode);
		
	}

	private BinaryNode performAvlSpecificOperations(BinaryNode currentNode) {
		int balance = checkBalance(currentNode.getLeft(),currentNode.getRight());
		if(balance > 1) {
			if(checkBalance(currentNode.getLeft().getLeft(),currentNode.getLeft().getRight()) >= 1) {
				currentNode = rightRotation(currentNode);// LL Condition
			}
			else {
				currentNode.setLeft(leftRotation(currentNode.getLeft()));
				currentNode = rightRotation(currentNode);// LR Condition
			}
		}else if(balance < -1) {
			if(checkBalance(currentNode.getRight().getRight(),currentNode.getRight().getLeft()) >= 1) {
				currentNode = leftRotation(currentNode);// RR Condition
			}
			else {
				currentNode.setRight(rightRotation(currentNode.getRight()));
				currentNode = leftRotation(currentNode);// RL Condition
			}
		}
		
		if(currentNode.getLeft()!=null) {
			currentNode.getLeft().setHeight(CalculateHieght(currentNode.getLeft()));
		}
		if(currentNode.getRight()!=null) {
			currentNode.getRight().setHeight(CalculateHieght(currentNode.getRight()));
		}
		
		currentNode.setHeight(CalculateHieght(currentNode));
		return currentNode;
	}
	
	public void delete(int val) {
		root = delete(root,val);
	}

	private BinaryNode delete(BinaryNode currentNode, int val) {
		// TODO Auto-generated method stub
		if(currentNode == null) {
			return null;
		}
		if(val < currentNode.getValue()) {
			currentNode.setLeft(delete(currentNode.getLeft(),val));
		}
		else if(val > currentNode.getValue()) {
			currentNode.setRight(delete(currentNode.getRight(),val));
		}else {
			if(currentNode.getLeft()!=null && currentNode.getRight()!=null) {
				//BinaryNode tmp = currentNode;
				BinaryNode minNode = minimumNode(currentNode.getRight());
				currentNode.setValue(minNode.getValue());
				delete(currentNode.getRight(),minNode.getValue());
			}else if(currentNode.getLeft()!=null) {
				currentNode =currentNode.getLeft();
			}else if(currentNode.getRight()!=null) {
				currentNode= currentNode.getRight();
			}else {
				currentNode = null;
			}
			return currentNode;
		}
		return performAvlSpecificOperations(currentNode);
		
	}

	private BinaryNode minimumNode(BinaryNode right) {
		// TODO Auto-generated method stub
		if(right.getLeft()==null)
			return right;
		else
		 return minimumNode(right.getLeft());
	}

	private BinaryNode leftRotation(BinaryNode currentNode) {
		// TODO Auto-generated method stub
		BinaryNode newRoot = currentNode.getRight();
		currentNode.setRight(currentNode.getRight().getLeft());
		newRoot.setLeft(currentNode);
		currentNode.setHeight(CalculateHieght(currentNode));
		newRoot.setHeight(CalculateHieght(newRoot));
		return newRoot;
	}

	private BinaryNode rightRotation(BinaryNode currentNode) {
		// TODO Auto-generated method stub
		BinaryNode newRoot = currentNode.getLeft();
		currentNode.setLeft(currentNode.getLeft().getRight());
		newRoot.setRight(currentNode);
		currentNode.setHeight(CalculateHieght(currentNode));
		newRoot.setHeight(CalculateHieght(newRoot));
		return newRoot;
		
	}

	private int CalculateHieght(BinaryNode node) {
		// TODO Auto-generated method stub
		if(node == null)
			return 0;
		else 
			return 1 + Math.max(node.getLeft()!=null?node.getLeft().getHeight():-1,
					node.getRight()!=null?node.getRight().getHeight():-1);
		
	}

	private int checkBalance(BinaryNode left, BinaryNode right) {
		// TODO Auto-generated method stub
		if(left == null) {
			return -1 * (right.getHeight()+1);
		}
		
		else if(right == null) {
			return   (left.getHeight()+1);
		}else {
			return left.getHeight() - right.getHeight();
		}
	}

	private BinaryNode createNewNode(int val) {
		// TODO Auto-generated method stub
		BinaryNode node = new BinaryNode();
		node.setHeight(0);
		node.setValue(val);
		return node;
	}
	
	

	void printTreeGraphically() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		
		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);
		
		System.out.println("\nPrinting Level order traversal of Tree...");
		if(root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		
		while (!queue.isEmpty()) {
			if(CurrentLevel == level.peek()) { //if we are in the same level
				if(queue.peek()==null) {
					queue.add(null);level.add(CurrentLevel+1);
				}else {
					queue.add(queue.peek().getLeft());level.add(CurrentLevel+1);
					queue.add(queue.peek().getRight());level.add(CurrentLevel+1);
					previousLevelWasAllNull = false;
				}
				System.out.print(queue.remove() + "  ");level.remove();
			}else { //level has changed
				System.out.println("\n");
				CurrentLevel++;
				if(previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}//end of loop
	}
	
	
	void levelOrderTraversal() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		System.out.println("Printing Level order traversal of AVL Tree...");
		if (root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}// end of method

}
