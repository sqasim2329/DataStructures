package Algos;

public class StoneDivision {
	 
	public static void main(String args[]) {
		long n=12;
		long s[]= {2,3,4};
		System.out.println(stoneDivision(n,s));
	}
	   
	    // Complete the stoneDivision function below.
	    static long stoneDivision(long n, long[] s) {
	    		long res=0;	
	            for(int i=0;i<s.length-1;i++){
	                if(n%s[i]==0 && n!=s[i])
	                res=Math.max(res,1+stoneDivision(s[i],s)*(n/s[i]));
	            }

	            return res;
	            
	    }


}
