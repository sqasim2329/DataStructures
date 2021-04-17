package BitMasking;

public class PowerOfTwo {
	
	public static boolean isPowerofTwo(long n){
        if(n == 0)
            return false;
        return (n & (n-1))==0;
        
    }

}
