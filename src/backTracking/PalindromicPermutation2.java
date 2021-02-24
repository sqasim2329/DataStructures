package backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
O(n/2)! O(n) space
public class PalindromicPermutation2 {
	
	class Solution {
	    public List<String> generatePalindromes(String s) {
	        
	        List<String> ls = new ArrayList<>();
	        if(canPermutatePalindrome(s))
	        backTrack(s,ls,0);
	        return ls;
	    }
	    
	    private boolean canPermutatePalindrome(String s){
	        Set<Character> set = new HashSet<>();
	        for(char c:s.toCharArray()){
	            if(set.contains(c)){
	                set.remove(c);
	            }
	            else
	                set.add(c);
	                
	        }
	        return set.size()<=1;
	    }
	    
	    private void backTrack(String s, List<String> ls,int indx){
	        if(indx >= s.length() && isPalindromic(s)){
	            ls.add(s);
	            return;
	        }
	        Set<Character> seen = new HashSet<>();
	        for(int i=indx;i<s.length();i++){
	            if(seen.add(s.charAt(i))){
	            s = swap(s,i,indx);
	            backTrack(s,ls,indx+1);
	            s = swap(s,i,indx);
	            }
	        }
	        
	    }
	    
	    private String swap(String s,int i,int j){
	        char[] a = s.toCharArray();
	        char tmp = a[i];
	        a[i] = a[j];
	        a[j] = tmp;
	        return new String(a);
	    }
	    
	    private boolean isPalindromic(String s){
	        int i = 0;
	        int j = s.length()-1;
	        while(i <= j){
	            if(s.charAt(i)!=s.charAt(j))
	                return false;
	            else{
	                i++;
	                j--;
	            }
	        }
	        
	        return true;
	    }

}
