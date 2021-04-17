package BitMasking;

public class DivideTwoNumbers {
	
	public static void main(String args[]) {
		long a = 10;
		long b = 3;
		int sign = (a < 0 || b<0)?-1:1;
		long quotient = 0;
		long tmp =0;// if not tmp might go to Integer.min val
		for(int i=31;i>=0;i--) {
			while((tmp+(b << i)) <= a) {
				tmp+=b<<i;
				quotient |= 1L << i; 
			}	
		}
		
		System.out.println(sign * quotient);
		
	}

}



/*******
 * 
 * 
 * 
 * 			3 * 2^1 = 6 <=10
 * 			tmp = 6;
 * 			quotient = 2;
 * 
 * 
 * 			6+ 3*1 <=10
 * 			tmp=9;
 * 			quotient = 3
 * 			remoainder =  a-tmp; 
 * 
 * 
 */