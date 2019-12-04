package com.data.miscellenious;

public class DaimondProblem {
	
	
	
	 interface A{
		default void method() {
			System.out.println("A");
		}
		
		public static void mymethod() {
			
		}
		
		
	}
	
	interface B  extends A{
		default void method() {
			System.out.println("B");
		}
		
		static void mymethod() {
			System.out.println("m");
		}
	}
	
	class C implements B,A{
		
	}
	
	public static void main(String args[]) {
		C c=new DaimondProblem().new C();
		
	} 
}
