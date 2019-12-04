package com.data.miscellenious;

public interface Movable {
	
	default void move() {
		System.out.println("I am moving");
	}
	
	static void run() {
		System.out.println("run");
	}

}
