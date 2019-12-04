package com.data.miscellenious;

import java.util.Arrays;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestJava8Interface implements Movable{
	static final int[] a;
	int []b;
	 
    static
    {
        a = new int[] {1, 2, 3};
    }
	
	public static void main(String args[]) {
		TestJava8Interface t = new TestJava8Interface();
		t.move();
		Stream<Integer> stream= Stream.of(1);
		int[] i = {24, 13, 45, 37, 84, 13, 28};
		System.out.println(Arrays.binarySearch(i,13));
		
//		int[] a = new int[10];
//		 
//        int[] b = new int[100];
//        a = new int[5];
        
        String s= new String("me");
        String x=s;
        s +="me";
        System.out.println(x==s);
        
//        b=a;
//        System.out.println(a[01]);
		
	}
	
	
 
    
	
	static void run() {
		
	}
	
	static class A
	{
	    int i = 10;
	    
	}
	 
	static class B extends A
	{
	    int j = 20;
	}
	 
	static class C extends B
	{
	    int k = 30;
	}
	 
	static class D extends C
	{
	    int m = 40;
	}
//
//	@Override
//	public void move() {
//		// TODO Auto-generated method stub
//		
//		Walkable.super.move();
//		Movable.super.move();
//		Optional<Integer> pos = Optional.ofNullable(null);
//		pos = pos.of(5);
//		System.out.println(pos.get());
//		StringJoiner sj = new StringJoiner(":", "[", "]");
//		sj.add("a");
//		System.out.println(sj);
//		 
//		/*
//		 * D d = new D(); d.m = 10; C c=d; c.m = 11;
//		 */
//		;
//		
//	}

	

	

}
