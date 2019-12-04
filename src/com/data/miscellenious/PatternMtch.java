package com.data.miscellenious;

import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMtch {
	
	String s;
	public static void print() {
		System.out.println("this");
	}
	
	public PatternMtch() {
	}
	
	

	public static void main(String args[]){  
//	System.out.println(Pattern.matches("[amn]", "abcd"));//false (not a or m or n)  
//	System.out.println(Pattern.matches("[amn]", "a"));//true (among a or m or n)  
//	System.out.println(Pattern.matches("[a-p[amn][amn]]", "amn"));//false (m and a comes more than once) 
		
		
		
		Supplier<PatternMtch> s= PatternMtch::new;
		PatternMtch pat=s.get() ;
	
	Pattern p = Pattern.compile("SA\\W*");
	Matcher m= p.matcher("SA^");
	System.out.println(m.matches());
	System.out.println(m.start()+" "+m.end());
	System.out.println(Pattern.matches("[amn]+[c]{2,3}", "amcc"));
	System.out.println(Pattern.matches("(\\w\\s)\\1", "a a "));
	System.out.println(Pattern.matches("(AB)(\\w\\d)\\2", "ABB2B2"));
	
	Pattern pattern = Pattern.compile("\\W");
	String[] words = pattern.split("one@two#three:four$five");
	for (String s : words) {
		System.out.println("Split using Pattern.split(): " + s);
	}
	System.out.println();
	
	Runnable t=()->{print();};
	Thread t1=new Thread(t);
	t1.start();

	
	

	
	}
}
