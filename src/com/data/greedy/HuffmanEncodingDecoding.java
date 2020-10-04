package com.data.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanCode implements Comparable<HuffmanCode>{
	char c;
	int freq;
	HuffmanCode left;
	HuffmanCode right;
	
	public HuffmanCode(char c,int freq) {
		this.c = c;
		this.freq = freq;
		left = null;
		right = null;
	}
	
	public int compareTo(HuffmanCode o) {
		return this.freq - o.freq;
	}
	
}

public class HuffmanEncodingDecoding {
	
	public static void main(String args[]) {
		int n = 6; 
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 9, 12, 13, 16, 45 }; 
        encode(charArray,charfreq);
        
	}

	private static void encode(char[] charArray, int[] charfreq) {
		Map<Character,String> codeMap = new HashMap<>();
		PriorityQueue<HuffmanCode> q = new PriorityQueue<>();
		for(int i=0;i<charArray.length;i++) {
			q.add(new HuffmanCode(charArray[i],charfreq[i]));
		}
		
		while(q.size()>1) {
			HuffmanCode x = q.poll();
			HuffmanCode y = q.poll();
			
			HuffmanCode f = new HuffmanCode('-',x.freq+y.freq);
			f.left = x;
			f.right =y;
			q.add(f);
		}
		
		printHuffMancode(q.peek(),"",codeMap);
		//return getEncodedString(codeMap, "");
		
	}

	private static void printHuffMancode(HuffmanCode peek,String s,Map<Character,String> codeMap) {
		if(peek.left == null && peek.right == null && Character.isLetter(peek.c)) {
			System.out.println(peek.c+":"+s);
			codeMap.put(peek.c, s);
			
		}
		
		printHuffMancode(peek.left,s+"0",codeMap);
		printHuffMancode(peek.right,s+"1",codeMap);
		
	}
	
	
	private static String decode(HuffmanCode root,String s) {
		
		String ans = ""; HuffmanCode curr = root;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='0') {
				curr =curr.left;
			}else {
				curr = curr.right;
			}
			
			if(curr.left == null && curr.right == null) {
				ans+=curr.c;
				curr = root;
			}
		}
		
		return ans;
		
	}

}
