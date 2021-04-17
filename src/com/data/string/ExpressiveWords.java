package com.data.string;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
	

    
    class RLE{
        String key;
        List<Integer> counts = new ArrayList<>();
        
        public RLE(String s){
            int l = 0;
            int r = 0;
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            while(r<n){
                l=r;
                while(r<n-1 && s.charAt(r)==s.charAt(r+1)){
                    r++;
                }
                counts.add(r-l+1);
                sb.append(s.charAt(r));
                r++;
            }
            key = sb.toString();
        }
    }
    public int expressiveWords(String S, String[] words) {
        int ans = 0;
        RLE strechy = new RLE(S);
        for(String word:words){
            boolean isValid = true;
            RLE wordRLE = new RLE(word);
            if(strechy.key.equals(wordRLE.key)){
                for(int i = 0;i<strechy.counts.size();i++){
                    int c1 = strechy.counts.get(i);
                    int c2 = wordRLE.counts.get(i);
                    if((c1!=c2 && c1<3) || c1<c2){//heello hello | helo hello
                        isValid = false;
                        break;
                    }
                    
                }
            }else{
                isValid = false;
            }
            
            if(isValid){
                ans++;
            }
            
        }
        return ans;
        
    }

}

/******
 * 
 * Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 * 
 * 
 * *******/
///"aaa"
//["aaaa"]