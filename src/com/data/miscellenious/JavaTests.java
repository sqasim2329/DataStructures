package com.data.miscellenious;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


class SuperClass{
	public void method()  {
		
	}
}

class SubClass extends SuperClass{
@Override	
public void method() {
		
	}
}
public class JavaTests {
	
	
	
	
	abstract  class myClass{
		abstract int add(int a, int b);
		int a;
	}
	static class X
	{
//	    void method(int a)
//	    {
//	        System.out.println("ONE");
//	    }
	     
	    void method(double d)
	    {
	        System.out.println("TWO");
	    }
	}
	 
	static class Y extends X
	{
	    @Override
	    void method(double d)
	    {
	        System.out.println("THREE");
	    }
	}
	
	enum Directions {
		NORTH(10){
			int i;
			void printMe(int i) {
				System.out.println(i);
			}
		},SOUTH(20),EAST(30),WEST(40);
		int i;
		Directions(int i) {
			this.i = i;
		}
		
		private int  getVal() {
			return this.i;
		}
	}
	 
	 
	    public static void my(String[] args)
	    {
	      System.out.println(Arrays.asList(Directions.values()).stream().toString());
	     System.out.println(Directions.NORTH.ordinal());
	     List<Integer> ls = new ArrayList<>();
	     HashMap<String,String> map= new HashMap<>();
	     map.put("a", "a");
	     map.put("b", "a");
	     for(Entry<String,String> e:map.entrySet()) {
	    	 if(e.getKey().equals("b"))
	    	 map.remove(e.getKey());
	     }
	     
	     map.entrySet().stream().forEach(System.out::println);
	     Integer i= new Integer(5);
	    }
	    
	    public static void main(String[] args) 
		{ 

			// Creating an empty array list 
//			ArrayList<Integer> list1 = new ArrayList<Integer>(); 
//
//			/// Creating another empty array list 
//			ArrayList<Integer> list2 = new ArrayList<Integer>(); 
//
//			// Add values in the list2 list. 
//			list2.add(1); 
//			list2.add(2); 
//			list2.add(3); 
//			list2.add(4); 
//	      	list1.add(1);
//
//			// Before Applying method print both lists 
//			System.out.println("list1 Contains :" + list1); 
//			System.out.println("list2 Contains :" + list2); 
//
//			// Apply retainAll() method to list2 passing list1 as parameter 
//			list2.retainAll(list1); 
//
//			// Displaying both the lists after operation 
//			System.out.println("\nAfter Applying retainAll()"+ 
//			" method to list2\n"); 
//			System.out.println("list1 Contains :" + list1); 
//			System.out.println("list2 Contains :" + list2); 
	    	
	    	double d = 10.25;
	        float f = (float) d;      //double is explicitly narrowed to float
	        byte b = (byte)(long) f;    //float is explicitly narrowed to long and short to byte
	        System.out.println(b);
		} 
	

	
}
