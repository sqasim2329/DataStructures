package com.data.string;

public class ZigZagString {
	
	public static void main(String args[]) {
		String s = "PAYPALISHIRING";
		int row = 4;
		if(row <=1)
			System.out.println(s);
		System.out.println(convert(s,row));
	}

	private static String convert(String s, int row) {
		
		StringBuilder[] sb = new StringBuilder[row];
		for(int i=0;i<sb.length;i++) {
			sb[i]=new StringBuilder("");
		}
		
		int direction = 1;// down will 1 diagonally up will -1
		int index =0;
		for(char c:s.toCharArray()) {
			sb[index].append(c);
			if(index ==0 ) direction =1;//we will have to go down
			if(index == row-1) direction =-1;// we will have to diagonally up
			index+=direction;
		}
		String res="";
		for(StringBuilder sbuilder : sb ) {
			res+=sbuilder;
		}
		
		return res;
	}

}
