package com.data.google;

import java.util.Arrays;

public class KthAncestorOfTreeNode {
	
	int[][]dp;
	int height=0;
	
	public KthAncestorOfTreeNode(int n, int[] parent) {
		this.height = (int)Math.ceil(Math.log(n)/Math.log(2));//gives height of power 2 ^ height is the max height of ancestor
		dp=new int[10][height+1];//in constraints it is 50000
		preprocessing(n,parent);
	}
	
	
	public void preprocessing(int n, int[] parent) {
		Arrays.fill(dp[0], -1);
		for(int i=1;i<n;i++) {
			Arrays.fill(dp[i], -1);
			dp[i][0]=parent[i];
			for(int j=1;j<height;j++) {
				dp[i][j]=dp[dp[i][j-1]][j-1];//dp[i][j-1]=parent[i]so dp[parent[i]][j-1]//parents parent;
				if(dp[i][j]==-1)
					break;//no further processing is required since we have reached the top of ancestors
			}	
		}
		
	}
	
	
	public int getKThAncestor(int node, int k) {
		int val =0;
		for(int i=height-1;i>=0;i--) {
			if((k & (1 << i))>0) {
				node = dp[node][i];
				if(node ==-1)
					break;
				
			}
		}
		
		return node;
	}
	
	public static void main(String args[]) {
		int[] parent = {-1,0,0,1,1,2,2};
		int N=7;
		KthAncestorOfTreeNode k = new KthAncestorOfTreeNode(N,parent);
		System.out.println(k.getKThAncestor(3, 1));
//		[5,2],[6,3]
		
	}
	
	

}
