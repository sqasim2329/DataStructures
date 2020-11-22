package com.data.arrays;

public class IntegerToROman {
	
	public String intToRoman(int num) {
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String romans[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<values.length && num>=0;i++){
            while(num >= values[i]){
                num = num-values[i];
                sb.append(romans[i]);
            }
        }
        
        return sb.toString();
        
    }

}

/*****
 * 
 * 			Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 we need to dedcue the other values 900,400,90,40,9,4
 CM,CD,XC,XL,IX,IV
 
 
 * 
 * *****/
 