package com.data.binaryTree;

public class FenwickTree {
	int BIT[];
	public FenwickTree(int n) {
		this.BIT=new int[n+1];
	}
	public void createTree(int input[]) {
		for(int i=1;i<=input.length;i++) {
			updateBIT(input[i-1],i);	
		}
	}
	private void updateBIT(int val, int index) {
		while(index < BIT.length) {
			BIT[index]+=val;
			index=getNext(index);
		}
	}
	private int getNext(int index) {
		return index +(index & -index);
		
	}
	
	private int getSum(int index) {
		index=index+1;
		int sum=0;
		while(index > 0) {
			sum+=BIT[index];
			index=getParent(index);
		}
		return sum;
	}
	
	private int getParent(int index) {
		return index -(index & -index);
	}
	
	private  void update(int index, int value) {
		index = index+1;
		int incre = Math.abs(BIT[index]-value);
		updateBIT(incre,index);
	}
	
	public static void main(String args[]) {
		int input[]= {1,2,3,4,5,6,7};
		FenwickTree ft=new FenwickTree(input.length);
		ft.createTree(input);
		System.out.println(ft.getSum(6));
		ft.update(2,4);
		System.out.println(ft.rangeSum(1,2));
	}
	
	
	private int rangeSum(int l, int r) {
		return getSum(r)-getSum(l-1);
	}
	

}
