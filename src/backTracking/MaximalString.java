package backTracking;

import java.util.Arrays;
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
	
	//can be done using binary: sort and search for the number and go to the right most from the number
	private void binarySearchMethod() {
		String A = "7596";
		int[] arr = new int[A.length()];
		int index = 0;
		for(char c:A.toCharArray()) {
			arr[index++]=c-'0';
		}
		Arrays.sort(arr);
		Set<Integer> set = new HashSet<>();
		int i = 0;
		int B=2;
		while(i < A.length() && B > 0) {
			int max = A.charAt(i);
			int j = i+1;
			int[] val = binarySearchForLargeValue(A.charAt(i)-'0',arr);
			if(val[0]  != A.charAt(i)-'0' && set.add(val[0])) {
				swap(s,)
			}
			
		}
			
	}
	
	

}
