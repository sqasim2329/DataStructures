package com.data.miscellenious;

class A{
	static int i=0;
}

public class MyClass implements Interface1, Interface2{
	
	private final A a= new A();
	
	private final int b=10;
	

	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		System.out.println("class logging::"+str);
//		a.i=10;
//		b=20;
	}

}
