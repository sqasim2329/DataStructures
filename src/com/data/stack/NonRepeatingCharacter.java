package com.data.stack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NonRepeatingCharacter {
	
	public static void main(String args[]) {
		Queue<Character> q =  new LinkedList<>();
		char chr[] = { 'a','a','b','c'};
		String s="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoqhnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcacehchzvfrkmlnozjkpqpxrjxkitzyxacbhhkicqcoendtomfgdwdwfcgpxiqvkuytdlcgdewhtaciohordtqkvwcsgspqoqmsboaguwnnyqxnzlgdgw";
		Map<Character,Integer> map = new HashMap<>();
		int charCount[] = new int[26];
		for(char ch: s.toCharArray()) {
		findNonRepeatngChar(ch,q,charCount);
		}
	}

	private static void findNonRepeatngChar(char ch, Queue<Character> q,int charCount[]) {
           	  q.add(ch);
           	  charCount[ch-'a']++;
           	  while(!q.isEmpty()) {
           		  if(charCount[q.peek()-'a']>1) {
           			  q.remove();
           		  }else {
           			  System.out.println(ch+" ");
           			  break;
           		  }
           	  }
           	  if(q.isEmpty())
           	  System.out.println(-1+" ");
           	  
           	  //spiral order traversal
           	  //Kth missingElement
           	  //https://www.javacodegeeks.com/2016/12/implement-thread-pool-java.html
           	  //spiralrotationofarray
           	  
	}

}
