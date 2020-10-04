package com.data.binaryTree;

public class SegmentTree {
	
	int segSize = 10000;
	int tree[]=new int[segSize];
	int lazy[]= new int[segSize];
	
	
	private void buildTree(int ind, int low, int high, int inp[]) {
		
		if(low == high) {
			tree[ind]=inp[low];
			return;
		}
		
		int mid = low+(high-low)/2;
		buildTree(2*ind+1,low,mid,inp);
		buildTree(2*ind+2,mid+1,high,inp);
		tree[ind] = tree[2*ind+1]+tree[2*ind+2];
	}
	
	
	private int queryRange(int ind, int low,int high, int l, int r) {
		if(low > r || high < l) return 0;
		
		if(low >=l && high <= r) {
			return tree[ind];
		}
		
		int mid = low+ (high-low)/2;
		int left  =  queryRange(2*ind+1, low, mid, l, r);
		int right  =  queryRange(2*ind+2, mid+1, high, l, r);
		return left + right;
	}
	
	
	private void pointUpdate(int ind, int low,int high,int node, int val) {
		
		if(low ==  high) {
			tree[ind]+=val;
		}
		
		
		int mid = low+(high-low)/2;
		if(node >= low && node <=mid)  pointUpdate(2*ind+1,low,mid,node,val);
		else pointUpdate(2*ind+2,mid+1,high,node,val);
		tree[ind] = tree[2*ind+1] + tree[2*ind+2];
	}
	
	private void rangeUpdate(int ind, int low, int high, int l, int r,int val) {
		if(lazy[ind]!=0) {
			tree[ind] += (high-low+1)*lazy[ind];
			if(low!=high) {
				lazy[2*ind+1]+=lazy[ind];
				lazy[2*ind+2]+=lazy[ind];
			}
			
			lazy[ind]=0;
		}
		
		if(low > r || high < l) return ;
		
		if(low >= l && high <= r) {
			tree[ind] = (high-low+1)*val;
			if(low!=high) {
				lazy[2*ind+1] += val;
				lazy[2*ind+2] += val;
			}
			return;
		}
		
		int mid = low + (high-low)/2;
		rangeUpdate(2*ind+1, low,mid,l,r,val);
		rangeUpdate(2*ind+2, low,mid,l,r,val);
		tree[ind] = tree[2*ind+1]+tree[2*ind+2];
	}
	
	
	private int queryRangeLazy(int ind, int low, int high, int l, int r) {
		if(lazy[ind]!=0) {
			tree[ind]+=(high-low+1)*lazy[ind];
			if(low!=high) {
				lazy[2*ind+1] += lazy[ind];
				lazy[2*ind+2] += lazy[ind];
			}
			lazy[ind]=0;
		}
		
		if(low > r || high < l) return 0;
		
		if(low >= l && high <= r) {
			return tree[ind];
		}
		
		int mid = low+(high-low)/2;
		int left = queryRangeLazy(2*ind+1, low,mid,l,r);
		int right = queryRangeLazy(2*ind+2, mid+1,high,l,r);
		return left+right;
		
	}

}
