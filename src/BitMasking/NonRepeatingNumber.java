package BitMasking;

public class NonRepeatingNumber {
	
	public int[] singleNumber(int[] nums)
    {
        //1. XOR of all elements remove the duplicats
        //2. Find the right most set bit number of the result.
        //3. use the set bit number to find divide the numbers into two groups
        //4. xor of elemntes that fit in these 2 groups
        int result = 0;
        for(int num:nums)
            result = result ^ num;
        
        int set_bit_no = result & -(result-1);
        int sum1 = 0;
        int sum2 = 0;
        for(int num:nums){
            if((num & set_bit_no) > 0)
                sum1 = sum1 ^ num;
            else
                sum2 = sum2 ^ num;
        }
        return new int[]{sum1,sum2};
        
    }

}
