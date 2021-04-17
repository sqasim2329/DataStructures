package BitMasking;
//https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1#
public class FindPositionOfOnlySetBit {
	
	
	static int findPosition(int N) {
        if(!isPowerOfTwo(N)) return -1;
        int i =1;
        int pos =1;
        while((i & N) == 0){
            i = i << 1;
            pos++;
        }
        
        return pos;
    }
    
    private static boolean isPowerOfTwo(int n){
        return n > 0 && (n & (n-1))==0;
    }

}
/**
 * 
 * 
 *		if it is not power of two it will have multiple set bits eg: 3, 5, 7,9.11
 *		2
 *		0010
 *		i = 1  left shit  
 * 			0001 left shift 0010
 *      pos  = 2
 *      4
 *      i=1 left shit 
 *      	0001 left shift 0010
 *  						0100
 *  	pos = 3 
 * 
 * **/
 

//https://www.geeksforgeeks.org/copy-set-bits-in-a-range/