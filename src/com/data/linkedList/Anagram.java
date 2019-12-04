package com.data.linkedList;

import java.util.Arrays;
import java.util.Comparator;

public class Anagram {
	
	static class Aangram{
		int index;
		String str;
		Aangram(int index,String str){
			this.index=index;
			this.str = str;
		}
	}
	
	static class StrComp implements Comparator<Aangram>{
		public int compare(Aangram a, Aangram b) {
			return a.str.compareTo(b.str);
		}
	}
	
	public static void main(String args[]) {
		String[] strArr = {"cat", "dog", "tac", "god", "act"};
		Aangram[] arr= new Aangram[strArr.length];
		for(int i=0; i< strArr.length; i++) {
			char[] char_arr = strArr[i].toCharArray();
			Arrays.sort(char_arr);
			arr[i] = new Aangram(i,new String(char_arr));
		}
		
		Arrays.sort(arr,new StrComp());
		for(int i=0; i< strArr.length; i++ ) {
			System.out.println(arr[i].index+" "+strArr[arr[i].index]);
		}
		
	}

}
