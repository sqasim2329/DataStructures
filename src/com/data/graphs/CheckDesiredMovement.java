package com.data.graphs;
//You are on an infinite graph and starting from (1, 1), you can move either (x+y, y) or (x, x+y) and you need to find out whether you can reach the given point or not.
//BFS or DFS is not advised since assumption is infinite graph 
//euclliidean theorem
public class c {
	
	public static void main(String args[]) {
		int x=35;
		int y=15;
		int  a=20;
		int b=25;
		System.out.println(isPossible(x,y,a,b));
		System.out.println(gcd(1701,3768));
	}

	private static boolean isPossible(int x, int y, int a , int b) {
		 x= Math.abs(x);
		 y= Math.abs(y);
		 a= Math.abs(a);
		 b= Math.abs(b);
		 
		 return gcdItr(x,y)==gcdItr(a,b);	
	}

	private static int gcd(int x, int y) {
		if(x==y)
			return x;
		if(x>y)
			return gcd(x-y,y);
		else
			return gcd(x,y-x);
	}
	
	private static int gcdItr(int x,int y) {
		while(x!=y) {
			if(x>y)
				x =x-y;
			else
				y =y-x;
		}
		return x;
	}

}
