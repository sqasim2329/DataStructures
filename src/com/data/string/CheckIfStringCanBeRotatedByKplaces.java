package com.data.string;

public class CheckIfStringCanBeRotatedByKplaces {
	
	public static void main(String[] args) {
		String b= "abcdefg";
		String a = "cdfdawb";
		
		int k =6;
		
		System.out.println(check(a,b));
	}

	private static boolean check(String a, String b) {
		
		String b1 =  b.substring(b.length()-2,b.length());
		String b2 =  b.substring(0,b.length()-2);
		String b3 = b1+b2;
		
		if(b3.equals(a))
			return true;
		
		b1 = b.substring(0,2);
		b2 = b.substring(2,b.length());
		b3 = b2+b1;
		
		if(b3.equals(a))
			return true;
		
		return false;
		
	}

}
//check if string are rottions of each other: ABACD CDABA--> ABACDABACD  index of CDABA 
//https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/--use set or array to store elem
