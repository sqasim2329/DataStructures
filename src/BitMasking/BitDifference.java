package BitMasking;

public class BitDifference {
	
public static int countBitsFlip(int a, int b){
        
        // Your code here
        int count =0;
        for( int i=0;i<32;i++ ) {
            int bitA = ( a & (1 << i) )!=0 ? 1:0;
            int bitB = ( b & (1 << i) )!=0 ? 1:0;
            if(bitA != bitB )
                count++;
        }
        
        return count;
    }

}
