package com.data.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

//https://www.techiedelight.com/probability-alive-after-taking-n-steps-island/
public class ProbabilityOfPersonAliveAfterNSteps {
	
	public static void main(String args[]) {
		int n =3;//steps;
		int N =3;//N*N matrix
		Map<String,Double> dp=new HashMap<>();
		System.out.println(solve(N,n,0,0,dp));
	}
	
	
	private static double solve(int N,int steps, int x, int y,Map<String,Double> dp) {
		if(steps == 0)
			return 1.0;
		String key = x +"|"+y+"|"+steps;
		if(dp.containsKey(key))
			return dp.get(key);
		double probability = 0.0;
		if( x > 0)
			probability+=0.25 * solve(N,steps-1,x-1,y,dp);
		if( y > 0)
			probability+=0.25 * solve(N,steps-1,x,y-1,dp);
		if( x < N-1)
			probability+=0.25 * solve(N,steps-1,x+1,y,dp);
		if( y < N-1)
			probability+=0.25 * solve(N,steps-1,1,y+1,dp);
		dp.put(key, probability);
		return dp.get(key);
	}

}
