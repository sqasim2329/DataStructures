package Algos;

public class PowerSum {
	
	public static void main(String args[]) {
		int x=13;
		int n=2;
		System.out.println(powerSumWays(x,n,0));
		
	}
	
	 static int powerSumWays(int x, int n, int i){
	        if((int)Math.pow(i,n)>x)
	        return 0;
	        else if((int)Math.pow(i,n)==x)
	        return 1;

	        int z=powerSumWays(x,n,i+1);
	        int y=powerSumWays(x-(int)Math.pow(i,n),n,i+1);
	        return z+y;
	    }

}
