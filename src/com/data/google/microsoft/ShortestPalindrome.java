class Solution {
    public String shortestPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder(s);
        String reverse_s = sb.reverse().toString();
        String comb = s+"#"+reverse_s;// to avoid overlapping between s and reverse and it getting counted in KMP
        int[] lps = new int[comb.length()];
        int i=1;
        int j=0;
        while(i < comb.length()){
            if(comb.charAt(i)==comb.charAt(j)){
                lps[i]=j+1;
                i++;
                j++;
            }else{
                if(j == 0){
                    lps[i]=0;
                    i++;
                }
                else{
                    j = lps[j-1];
                }
            }
        }
        
        return reverse_s.substring(0,s.length()-lps[lps.length-1])+s;
        
        
    }
}

/*******

abab to convert to palindrome we need to reverse and add at front as mentioned in problem;
babaabab, shortest palindrome is babab , but we are getting long palindrome here
to convert this to shortest plaindrome , take first value from reverse of s and add to s, take 2 then take first and sec ... so on but complxity will be O(n^2).
to keep complxity down.
we try KMP-> longest prefix same as suffix, so we can add the reverse_s at the start and determone the prefix same suffix, hecne we remove that matching part from reverse_s and add to start of string S.



**********/




