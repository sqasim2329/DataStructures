package com.data.greedy;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
	
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Integer me1 = null;
        Integer me2 = null;
        int cnt1=0;
        int cnt2=0;
        
        for(int i:nums){
            if(me1!=null && me1 == i){
                cnt1++;
            }else if(me2!=null && me2 == i){
                cnt2++;
            }else if(cnt1 == 0){
                me1 = i;
                cnt1++;
            }else if(cnt2 == 0){
                me2 = i;
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int i:nums){
            if(me1!=null && me1 == i) cnt1++;
            if(me2!=null && me2 == i) cnt2++;
        }
        
        if(cnt1 > nums.length/3) res.add(me1);
        if(cnt2 > nums.length/3) res.add(me2);
        return res;

}
}
//To figure out a O(1)O(1) space requirement, we would need to get this simple intuition first. For an array of length n:
//
//There can be at most one majority element which is more than ⌊n/2⌋ times.
//There can be at most two majority elements which are more than ⌊n/3⌋ times.
//There can be at most three majority elements which are more than ⌊n/4⌋ times.