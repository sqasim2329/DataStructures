package com.data.miscellenious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamOp {
	
	public boolean isEquals(Predicate<String> p,String str) {
		return p.test(str);
		
	}
	
	public static void main(String args[]) {
		List<String> names = new ArrayList<>();
        
		names.add("David");
		         
		names.add("Johnson");
		         
		names.add("Samontika");
		         
		names.add("Brijesh");
		         
		names.add("John");
		names.add("John");
		
		StreamOp op=new StreamOp();
		
		Predicate<String> p=(n)->n.equals("David");
		
		
		int arr[]= {1,2,3,4,5,6,7};
		
//		names.stream().filter(op.isEquals(p, "David")).forEach(System.out::println);
		names.stream().distinct().forEach(System.out::println);
		names.stream().limit(1).forEach(System.out::println);
		System.out.println(Arrays.stream(arr).reduce(0, (a,b)->a+b));
	}

}
