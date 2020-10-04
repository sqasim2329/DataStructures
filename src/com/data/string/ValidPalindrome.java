package com.data.string;

public class ValidPalindrome {
	
public static boolean isPalindrome(String s) {
        
        if(s.isEmpty()==true)
            return true;
        
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            char a = s.charAt(i);
            char b = s.charAt(j);
           if(!Character.isLetterOrDigit(a))
               i++;
            else if(!Character.isLetterOrDigit(b))
                j--;
            else{
                if(Character.toLowerCase(a) == Character.toLowerCase(b)){
                    i++;j--;
                }else{
                    return false;
                }
            }
        }
        return true;
        
    }

public static void main(String args[]) {
	String s = "A man, a plan, a canal: Panama";
	System.out.println(isPalindrome(s));
}

}
