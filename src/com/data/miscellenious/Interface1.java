package com.data.miscellenious;

public interface Interface1 {

	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
}
