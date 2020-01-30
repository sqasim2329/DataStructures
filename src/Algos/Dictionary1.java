package Algos;
//largest word in dictionary by deleting some characters of given string
///maximum-difference-between-two-elements/
//middle of a given linked list in C and Java
public class Dictionary1 {
	
	Dictionary1(){
		
	}
	
	public static void main(String args[]) {
		
		String[] dict = {"ale", "apple", "monkey", "plea"};
		String str = "abpcplea"  ;
		
		int maxIndex =-1;
		int index = -1;
		for(int i=0; i<dict.length;i++) {
		int max= findLargestString(dict[i],str,0,0);
		if(maxIndex < max) {
			maxIndex = max;
			index = i;
			
		}
		}
		System.out.println(dict[index]);
		
	}

	private static int findLargestString(String str1, String str, int i,int j) {
		if(i >= str1.length() || j >= str.length())
			return 0;
		if(str1.charAt(i)==str.charAt(j)) {
			 return 1+findLargestString(str1,str,i+1,j+1);
		}
		
		return findLargestString(str1,str,i,j+1);
	}



}
