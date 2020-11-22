package com.data.string;
// need to make few changes for - if '-' is in between it wil consider as a character rather than sign
public class Atoi {
	
	public static void main(String args[]) {
		String str = "-223";
		System.out.println(atoi(str));
	}

	private static int atoi(String str) {
		int res = 0;
		int sign =1;
		int index  =0;
		if(str.charAt(0)=='-') {
			sign =-1;
			index++;
		}
		
		for(int i=index ; i< str.length();i++) {
			int val = str.charAt(i)-'0'; 
			if(val > 9) {//21a is input
				return -1;
			}
			res =res*10+val;
		}
		
		return res* sign;
		
	}

}
