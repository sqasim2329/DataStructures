package com.data.miscellenious;


public class MethodRef {
	static class PredicateEvaluator{
		private boolean isEven(int n) {
			return n%2==0;
		}
	}
	static class PredicateUser{
		public boolean checkValue(IntPredicate ib, int n) {
			return ib.check(n);
		}
	}
	
	public static void main(String args[]) {
		IntPredicate lb = (l)-> (l == 0);
		PredicateUser pu= new PredicateUser();
		System.out.println(pu.checkValue(lb, 1));
		PredicateEvaluator pe= new PredicateEvaluator();
		System.out.println(pu.checkValue(pe::isEven, 1));
		
		
	}
	
	

}
