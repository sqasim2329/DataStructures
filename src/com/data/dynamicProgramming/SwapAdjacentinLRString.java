package com.data.dynamicProgramming;

public class SwapAdjacentinLRString {
	
	private static boolean canTransform() {
		String s = "RXXLRXRXL";
		String e = "XRLXXRRLX";
		if(s.length()!=e.length()) return false;
		if(!s.replaceAll("X", "").equals(e.replaceAll("X", ""))) return false;
		
		char[] sa = s.toCharArray();
		char[] ea = e.toCharArray();
		int i=0,j=0;
		while(i<s.length()) {
			while(i<sa.length &&  sa[i]=='X')i++;
			while(j<ea.length &&  ea[j]=='X')j++;
			if(i==sa.length && j==ea.length) return true;
			if(i==sa.length || j==ea.length) return false;
			
			if(sa[i]=='L' && j > i)return false;
			if(ea[i]=='R' && i > i)return false;
			i++;
			j++;
		}
		return true;
	}
	
	public static void main(String args[]) {
		System.out.println(canTransform());
	}

}

/*********
 * 			
 * 			RXXLRXRXL
 * 
 * 			XRLXXRRLX
 * 
 *   			from above R from s should be on right side of e because rx-xr// means j should be > i
 *   			because in e string R should be o right side.
 *   			L from s should be on left side of e becuase xl-lx // means i should be > j
 *   			because in e string L should be on left side.
 *   
 *   	if X is replcaed with emptystring then we will get equal strings 
 *   so if R's position is on left side in s string then R's position in e string should be on right side
 *   	if L's position is on right side in s string then L's position in e string should be on left side 
 * ******/
