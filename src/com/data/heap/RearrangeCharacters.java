package com.data.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class RearrangeCharacters {
	
	
	
	
	
	public static void main(String args[]) {
		String s = "geeksforgeeks";
		System.out.println(rearrangeCharacters(s));
	}

	private static String rearrangeCharacters(String s) {
		final class CharFreq implements Comparable<CharFreq>{
			char c;
			int freq;
			public CharFreq(char ch, int count){
				c = ch;
				freq = count;
			}
			@Override
			public int compareTo(CharFreq o) {
				int comp = Double.compare(freq, o.freq);
				if(comp == 0) {
					comp = Character.compare(c, o.c);
				}
				return comp;
			}
		}
		
		StringBuffer rearranged = new StringBuffer();
		PriorityQueue<CharFreq> pq = new PriorityQueue<>(256,Collections.reverseOrder());
		int n = s.length();
		int[] freqHistogram = new int[256];
		
		for(char c:s.toCharArray()) {
			freqHistogram[c]++;
			if(freqHistogram[c] > (n+1)/2) {// if a charcter a present in string more than half of the string adjacent less string cannot be fo
				return s;
			}
		}
		
		for(char i= 0; i<256; i++) {
			if(freqHistogram[i] > 0) {
				pq.add(new CharFreq(i,freqHistogram[i] ));
			}
		}
		
		while(!pq.isEmpty()) {
			CharFreq first = pq.poll();
			rearranged.append(first.c);
			first.freq--;
			
			CharFreq second = null;
			if(!pq.isEmpty()) {
				second = pq.poll();
				rearranged.append(second.c);
				second.freq--;
			}
			
			if(first.freq > 0) {
				pq.add(first);
			}
			if(second!=null && second.freq>0) {
				pq.add(second);
			}
			
		}
		return new String(rearranged);
		// TODO Auto-generated method stub
		
	}

}
