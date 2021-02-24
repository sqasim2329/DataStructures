package com.data.stack;
//https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
import java.util.LinkedList;

public class NonRepeatingCharacter {
	
	public static void main(String args[]) {
		
		String s="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoqhnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcacehchzvfrkmlnozjkpqpxrjxkitzyxacbhhkicqcoendtomfgdwdwfcgpxiqvkuytdlcgdewhtaciohordtqkvwcsgspqoqmsboaguwnnyqxnzlgdgw";
//		s = "aabc";
//		s="geeksforgeeksandgeeksquizfor";
		int freq[] = new int[26];
		LinkedList<Character> ll = new LinkedList<>();
		
		for(char c:s.toCharArray()) {
			freq[c-'a']++;
			if(freq[c-'a']>1) {
				if(ll.contains(c)) {
					ll.remove((Character)c);//remember
				}
			}else {
				ll.add(c);
			}
			
			if(ll.size()>0)
				System.out.print(ll.element());
			else
				System.out.print(-1);
		}
		
		
	}
           	  //spiral order traversal
           	  //Kth missingElement
           	  //https://www.javacodegeeks.com/2016/12/implement-thread-pool-java.html
           	  //spiralrotationofarray
           	  


}
