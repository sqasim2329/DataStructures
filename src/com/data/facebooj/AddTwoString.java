package com.data.facebooj;

public class AddTwoString {
	
	class Solution {
	    public String addStrings(String num1, String num2) {
	        int n=Math.max(num1.length(),num2.length())+1;
	        int[] out = new int[n];
	        int i = num1.length()-1;
	        int j = num2.length()-1;
	        int index = out.length-1;
	        while(i >=0 || j >=0){
	            int v1 = (i >=0 ) ?num1.charAt(i--)-'0':0;
	            int v2 = (j >=0 )? num2.charAt(j--)-'0':0;
	            out[index--] = v1+v2;
	        }
	        
	        int carry = 0;
	        for(int k=out.length-1;k>=0;k--){
	            int tmp = out[k]+carry;
	            out[k]=tmp%10;
	            carry = tmp/10;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(int k=0;k<out.length;k++){
	            sb.append(out[k]);
	        }
	        
	        while(sb.length()>0 && sb.charAt(0)=='0'){
	         sb.deleteCharAt(0);   
	        }
	        
	        return sb.length()==0?"0":sb.toString();
	        
	    }
	}

}
