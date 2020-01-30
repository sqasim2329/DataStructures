package com.data.miscellenious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

//@FunctionalInterface
//interface myIntereface{
//	void myMethod();
//	void myM();
//}
public class Test<T> {
//	static T t;
	
	static <V> void method1(V v) {
		System.out.println(v);
	}
	
	
	class A 
	{
	    int i = 10;
	    int j=10;
	    
	    
	    
	    
	    void method() {
	    	System.out.println(j);
	    }
	    
	    
	}
	
	interface D{
		
	}
	
	
	
	static abstract class C{
		static {
			System.out.println(1);
		}
		{
			System.out.println(2);
		}
		
		C(){
			System.out.println(3);
		}
		 void method() {
			System.out.println("C");
		}
	}
	 
	static class B extends C
	{
	    int i = 20;
	    int j=20;
	    
//	    void method() {
//	    	System.out.println(j);
//	    }
	}
	
	static void method(List<? extends C> ls) {
		System.out.println(ls);
	}
	
	public static<T> void myMethod(Map<String,T> map) {
//		System.out.println("1");
//		List<B> ls=new ArrayList<>();
//		method(ls);
		
		List<String> names = new ArrayList<>();
        
		names.add("David");
		         
		names.add("Johnson");
		         
		names.add("Samontika");
		         
		names.add("Brijesh");
		         
		names.add("John");
		
		names.stream().filter((String name)->name.startsWith("D")).collect(collector)
		final Integer a=10;
		final Integer b=20;
		Comparator<Integer> comp=(A,B)->A.compareTo(B)*a;
		
		
		
	}
	
	
	 
	
//	    public static void main(String[] args)
//	    {
////	        A a = new B();
//	 B b = new B();
//	        b.method();
////	        a.method();
////	        System.out.println(new B().j);
//	        Map<String,D> map=new HashMap<>();
//	        myMethod(map);
//	        
//	        
//	    }
	
	public static void tricky(Point arg1, Point arg2)
	{
	  arg1.x = 100;
	  arg1.y = 100;
	  Point temp = arg1;
	  arg1 = arg2;
	  arg2 = temp;
	}
	
	static int method(){
		try
	      {
	          int i = 123/0;
	          return 10;
	          
	      }
	      finally
	      {
	         return 50;
	      }
	}
	
	public static int mymethod() {
		try {
			  throw new Exception();
		  }catch(Exception e) {
			  throw new Exception("Exception");
		  }finally {
			  return 10;
		  }
	}
//	public static void main(String [] args)
//	{
//	  Point pnt1 = new Point(0,0);
//	  Point pnt2 = new Point(0,0);
//	  int arr[]= {0,1,2,0,1,2};
//	  System.out.println("X: " + pnt1.x + " Y: " +pnt1.y); 
//	  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
//	  System.out.println(" ");
//	  tricky(pnt1,pnt2);
//	  System.out.println("X: " + pnt1.x + " Y:" + pnt1.y); 
//	  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);  
//	 
//	  Comparator<Integer> c=(a,b)-> a.compareTo(b);
//	  Arrays.sort(arr);
//	  IntStream intStream=Arrays.stream(arr);
//	  intStream.forEach(System.out::println);
//	  int n=mymethod();
//	  System.out.println(n);
//	  System.out.println(method());
//	  
//	  
//	}
	
}
