package com.data.interviewBit;

public class NestedListWeightedSUm {
	

    public int depthSum(List<NestedInteger> nestedList) {
        int sum =0;
        for(NestedInteger ni:nestedList)    
                sum+=getSum(1,ni);    
        return sum;
    }
    
    private int getSum(int depth,NestedInteger ni){
        int sum = 0;
        if(ni.isInteger()){
            sum+=depth*ni.getInteger();
        }else{
            for(NestedInteger ni2:ni.getList())
                sum+=getSum(depth+1,ni2);
        }
        return sum;
    }
    
 

}
