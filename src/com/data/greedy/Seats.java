package com.data.greedy;
///https://www.youtube.com/watch?v=SK2ypa7poKg
import java.util.ArrayList;

public class Seats {
	
	public int seats(String A) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i<A.length();i++){
            if(A.charAt(i)=='x'){
                arr.add(i);
            }
        }
        int ans = 0 ;
        int mid = arr.size()/2;
        int start = 0;
        int end = 0;
        for(int i = 0 ; i<arr.size();i++){
            start = arr.get(i);
            end =  arr.get(mid)-mid + i;
            ans= (ans+Math.abs(end-start))%10000003;
        }
        return ans%10000003;
}
//xxx...x...xxx
}
