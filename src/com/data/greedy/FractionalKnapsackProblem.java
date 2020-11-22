package com.data.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FractionalKnapsackProblem {
	
	static class Node{
		double weight;
		double val;
		double ratio;
		public Node(double weight, double val, double ratio) {
			super();
			this.weight = weight;
			this.val = val;
			this.ratio = ratio;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public double getVal() {
			return val;
		}
		public void setVal(double val) {
			this.val = val;
		}
		public double getRatio() {
			return ratio;
		}
		public void setRatio(double ratio) {
			this.ratio = ratio;
		}
		
		
	}
	
	public static void main(String args[]) {
		double knapsackCapacity = 50;
		double arr[][] = {{60, 10}, {100, 20}, {120, 30}};
		
		fixKnapSackProblem(arr,knapsackCapacity);
	}

	private static void fixKnapSackProblem(double[][] arr, double knapsackCapacity) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->{if((a.ratio-b.ratio) < 1) return 1 ; else return -1;});
//		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.ratio-b.ratio);
		List<Node> fractionList = new ArrayList<Node>(); 
		for(int i=0; i <= arr.length-1; i++) {
			pq.add(new Node(arr[i][1],arr[i][0],(arr[i][0]/arr[i][1])));
		}
		while(!pq.isEmpty() || knapsackCapacity > 0) {
			if(knapsackCapacity > pq.peek().weight) {
				knapsackCapacity = knapsackCapacity-pq.peek().weight;
				fractionList.add(pq.poll());
			}
			else {
				
				Node node = pq.poll();
				node.weight = (knapsackCapacity/node.weight)*node.weight;
				node.val = node.ratio*node.weight;
				fractionList.add(node);
				knapsackCapacity = knapsackCapacity-node.weight;
				
				
			}
			
			
		}
		for(Node a:fractionList) {
		System.out.println(a.getVal());
		}
		
	}

}
