package BitMasking;
//check in MyBook for algo explaination
public class CountToatlSetBits {
	
	
	public static int countSetBits(int n){
        if(n == 0)
        return 0;
        int count = 0;
        
        while(n > 0){
            int largestPowerOfTwoLTn = getLargestPower(n);    
            count +=(1 << (largestPowerOfTwoLTn-1))*largestPowerOfTwoLTn;
            count += (n-(1<<largestPowerOfTwoLTn)+1);
            n = n-(1 << largestPowerOfTwoLTn);
        }
        
        return count;
    }
    
    private static int getLargestPower(int n){
        int x = 0;
        while((1 << x) <= n){
            x++;
        }
        return x-1;
    }

}
