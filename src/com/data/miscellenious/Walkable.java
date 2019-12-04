package com.data.miscellenious;

public interface Walkable {
	
	default void move() {
		System.out.println("I am walking");
	}

}
