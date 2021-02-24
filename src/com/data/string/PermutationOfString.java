package com.data.string;

public class PermutationOfString {
	
	public static void main(String args[]) {
		String s = "ABC";
		System.out.println(findpermuation(s));
		
	}

	private static int findpermuation(String s) {
		int l=0;
		int r=s.length()-1;
		
		 return permutate2(s,0);
		
	}

	private static int permutate(String s, int l, int r,int cnt) {
		if(l==r) {
			 System.out.println(s);
			 return cnt+1;
		}
		else {
			for(int i=l;i<=r;i++) {
				s=swap(s,l,i);
				cnt=permutate(s,l+1,r,cnt);
				s=swap(s,l,i);
			}
		}
		return cnt;
	}

	private static String swap(String s, int l, int i) {
		char temp; 
        char[] charArray = s.toCharArray(); 
        temp = charArray[l] ; 
        charArray[l] = charArray[i]; 
        charArray[i] = temp; 
        return String.valueOf(charArray);
		
	}
	
	
	private static int permutate2(String s, int ind) {
		if(ind == s.length()) {
			System.out.println(s);
			return 1;
		}
		int cnt =0;
		for(int i=ind;i<s.length();i++) {
			s=swap(s,i,ind);
			cnt+=permutate2(s,ind+1);
			s=swap(s,i,ind);
		}
		return cnt;
	}

}
