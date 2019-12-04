package com.data.miscellenious;

public interface Interface2 {

	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}
}
