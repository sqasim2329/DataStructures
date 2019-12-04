package com.data.miscellenious;

public class StaticDynamicBinding {
	
	static class SuperClass{
		static void method() {
			System.out.println("From SuperClass");
		}
	}
	
	static class SubClass extends SuperClass{
		static void method() {
			System.out.println("From SubClass");
		}
	}
	
	public static void main(String args[]) {
		SuperClass a= new SuperClass();
		SuperClass b= new SubClass(); 	
		a.method();
		b.method();
		
	}

}
