package com.data.string;
//dtermine the shortest and then compare character by character
public class LongestCommonPrefix {
	
public String longestCommonPrefix(String[] strs) {
        
        if(strs.length==0)
            return "";
        int length =strs[0].length();
        int index =0;
        for(int i =0; i< strs.length;i++){
            if(length > strs[i].length())
                index =i;
        }
        
        
        for(int i=0; i<strs.length;i++){
            if(i!=index && !strs[index].equals("")){
                int j =0 ; int k =0;
                for(;j<strs[index].length();j++){
                    if(strs[index].charAt(j)==strs[i].charAt(k)){
                        k++;
                    }else{
                        break;
                    }
                }
             strs[index] = strs[index].substring(0,j);
            }
        }
        
        return strs[index];
    }

}
