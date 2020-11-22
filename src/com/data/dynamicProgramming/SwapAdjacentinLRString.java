package com.data.dynamicProgramming;

public class SwapAdjacentinLRString {
	
	private static boolean canTransform(String start, String end) {
		if(start == null && end == null)
            return true;
        if(start==null || end ==null)
            return false;
        
        if(start.length() != end.length())
            return false;
        
        if(!start.replaceAll("X","").equals(end.replaceAll("X","")))
            return false;
        
        int i=0;
        int j=0;
        while(i<start.length() && j < end.length()){
            while(i<start.length() && start.charAt(i)=='X')i++;
            while(j<end.length() && end.charAt(j)=='X')j++;
            if(i == start.length() && j == end.length())return true;
            if(i == start.length() || j == end.length())return false;
            
            if(start.charAt(i)=='R' && i>j) return false;
            if(start.charAt(i)=='L' && i<j) return false;
            i++;
            j++;
        }
        
        return true;
            
        
	}
	
	public static void main(String args[]) {
		String start=""; String end="";
		System.out.println(canTransform(start,end));
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
