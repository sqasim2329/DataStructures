package com.data.binaryTree;

public class TwoDimensionalFenwickTree {
	
	int BIT[][];
	
	public TwoDimensionalFenwickTree(int n) {
		this.BIT=new int[n+1][n+1];
	}
	
	public void createTree(int input[][]) {
		
		for(int i=1;i<=input.length;i++) {
			for(int j=1;j<=input[0].length;j++) {
				updateBIT(i,j,input[i-1][j-1]);
			}
		}
	}

	private void updateBIT(int i, int j, int val) {
		while(i < BIT.length) {
			while(j < BIT.length) {
				BIT[i][j]+=val;
				j=getNext(j);
			}
			i=getNext(i);
		}
		
		
	}

	private int getNext(int index) {
		return index + (index & -index);
	}
	
	private int getSum(int i , int j) {
		i=i+1;
		j=j+1;
		int sum=0;
		while(i > 0) {
			while(j > 0) {
				sum+=BIT[i][j];
				j=getParent(j);
			}
			i=getParent(i);
		}
		return sum;
	}
	
	
	private int getParent(int index) {
		return index - (index & -index);
		
	}

	private int query(int x , int y, int x2, int y2) {
		return getSum(x2,y2)-getSum(x-1,y2)-getSum(x2,y-1)+getSum(x-1,y-1);
	}
	
	public static void main(String args[]) {
	int input[][]={	{1, 1, 2, 2},
    {3, 3, 4, 4},
    {5, 5, 6, 6},
    {7, 7, 8, 8}};
	
	TwoDimensionalFenwickTree ft=new TwoDimensionalFenwickTree(input.length+1);
	ft.createTree(input);
	System.out.println(ft.query(2, 2, 4, 4));
	
	}

}
