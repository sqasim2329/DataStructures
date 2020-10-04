package com.data.string;

public class CountAndSay {
	
	public static void main(String args[]) {
		int n =6;
		System.out.println(countAndSay(n));
	}

	private static String countAndSay(int n) {
		if(n==1)
			return "1";
		if(n==2)
			return "11";
		String sb="11";
		for(int i=3;i<=n;i++) {
			sb = generateNextSeq(sb);
		}
		return sb;
	}

	private static String generateNextSeq(String s) {
		int count =1;
		char c = s.charAt(0);
		StringBuffer sb = new StringBuffer("");
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)==c) {
				count++;
			}else {
				sb.append(count).append(c);
				c=s.charAt(i);
				count =1;
			}
		}
		sb.append(count).append(c);
		return sb.toString();
	}

}
