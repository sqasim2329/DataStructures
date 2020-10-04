package com.data.hashing;

public class MultiplyStrings {
	
	public String multiply(String num1, String num2) {
        int n1  = num1.length();
        int n2  = num2.length();
        int arr[]= new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int v1 = num1.charAt(i)-'0';
                int v2 = num2.charAt(j)-'0';
                arr[i+j+1] += v1*v2;
            }
        }
        
        int carry = 0;
        for(int i=arr.length-1;i>=0;i--){
            int tmp = (arr[i]+carry)%10;
            carry = (arr[i]+carry)/10;
            arr[i] = tmp;
        }
        
        StringBuilder sb= new StringBuilder();
        for(int nums:arr) sb.append(nums);
        while(sb.length()!=0 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        return sb.length()==0?"0":sb.toString();
        
        
        
    }

}


/*******
 * res arr size cannot exceed n1+n2 size lets consider 100 * 100 so product is 10000 which is 5 length
 * hence we keep the res arr size as n1+n2; 
 *  01   01
 *  12 * 25
 *   | 2|4+5 | 10| so array has value as shown
 *  
 *  i+j+1 is basically the position of the value , we are storing from last position
 *  just find carry and print result
 *  
 * 
 * 
 * */
 */