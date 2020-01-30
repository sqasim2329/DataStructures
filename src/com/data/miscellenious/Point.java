package com.data.miscellenious;

abstract class myClass{
	abstract void method() ;
	}

interface interf{
	
}

class MyClass<T extends interf & myClass>{
	
}

public class Point {
	int x;
	int y;
	public Point(int i, int j) {
		this.x = i;
		this.y = j;
	}
	

	
}
