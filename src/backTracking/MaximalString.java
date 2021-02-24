package backTracking;

import java.util.HashSet;
import java.util.Set;

public class MaximalString {
	
	public static void main(String args[]) {
		String A = "7596"; // 524,
		int B =2;
		Set<Integer> set = new HashSet<>();
		 int i = 0;
	        int j = 0;
	        int indx =0;
	        char max = A.charAt(i);
	        while(i < B){
	            j =i+1;
	            max = A.charAt(i);
	            while(j < A.length()){
	                if(A.charAt(j) > max && !set.contains(j)){// talk to interviewer if keeping set is correct or wrong
	                    max = A.charAt(j);
	                    indx =j;
	                    set.add(indx);
	                }
	                j++;
	                
	            }
	            A = swap(A,i,indx);
	            i++;
	        }
	        
	        
		
		System.out.println(A);
	}

	private static String swap(String s, int i, int j) {
		char[] a = s.toCharArray();
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		return new String(a);
		
	}

}
