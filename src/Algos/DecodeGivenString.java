package Algos;

public class DecodeGivenString {
	
	
	
	public static void main(String args[]) {
		String s="10";
		System.out.println(decode(s,0));
	}

	private static int decode(String s, int i) {
		
		if(s.substring(i).equals(""))	
			return 1;
		
		if(s.charAt(i)=='0')
			return 0;
		
		int x=decode(s,i+1);
		int y=0;
		 if(i <= s.length()-2 && Integer.parseInt(s.substring(i,i+2)) < 27)
			 x+=decode(s,i+2);
		 
		 return x;
		
		
		
		
	}

}
