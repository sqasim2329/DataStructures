package com.data.miscellenious;
@FunctionalInterface
interface myFucntion {
	void add(int a);
}


public class TryCatchTest {
	
	 TryCatchTest(){
		
	}
	 
	 
	 
	 
	 
	 abstract class A{
		 A(){
			 System.out.println(1);
		 }
		 {
			 
		 }
	
		 
	 }
	 
	 class B extends A{
		 B(){
			
		 }
	 }
	
	
	public static int myMethod(int i, double j) throws Exception {
		int res=0;
		try {
			res=18/1;
			return res;
		}catch(Exception e) {
			res=-1;
			return res ;
		}finally {
			res=2;
		}
		
		
	}
	
	public static int myMethod(double j,int i) throws Exception {
		int res=0;
		try {
			res=18/1;
			return res;
		}catch(Exception e) {
			res=-1;
			return res ;
		}finally {
			res=2;
		}
		
		
	}
	
	public static void main(String args[]) {
		try {
			myFucntion func = (a)-> a=a+1;
//			System.out.println(myMethod(1,0));
			B b= new TryCatchTest().new B();
//			int []a=new int[10];
//			int []b=new int[100];
//			a=b;
//			System.out.println(a[11]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
