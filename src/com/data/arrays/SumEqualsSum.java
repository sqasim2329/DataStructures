package com.data.arrays;

import java.util.HashMap;
import java.util.Map;

public class SumEqualsSum {
	
	static class Obj{
		int a;
		int b;
		public Obj(int a, int b) {
			this.a=a;
			this.b=b;
		}
	}
	
	public static void main(String args[]) {
		int []arr= {3,4,7,1,2,9,8};
		int n= arr.length;
		Obj ob1 = null;
		Obj ob2 = null;
		int flag =0;
		Map<Integer,Obj> m= new HashMap<>();
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				int sum = arr[i]+arr[j];
				ob2= new Obj(arr[i],arr[j]);
				if(m.containsKey(sum)) {
					ob1=m.get(sum);
					System.out.println(ob1.a+"--"+ob1.b);
					System.out.println(ob2.a+"--"+ob2.b);
					flag=1;
					break;
				}else {
					m.put(sum,new Obj(arr[i],arr[j]));
				}
			}
			if(flag==1)
				break;
		}
	}

}
