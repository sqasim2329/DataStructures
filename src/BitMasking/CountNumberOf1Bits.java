package BitMasking;

public class CountNumberOf1Bits {
	
	static int setBits(int N) {
        int count = 0;
        for(int i=0;i<32;i++){
            
            if((N & (1 << i))!=0)count++;
        }
        return count;
    }

}
