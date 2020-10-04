package com.data.hashing;

public class CommonEelementsinSortedArrays {
	
	public static void main(String []args) {
//		int a[]={1, 5, 10, 20, 40, 80}; 
//		int b[]= {6, 7, 20, 80, 100}; 
//		int c[]={3, 4, 15, 20, 30, 70, 80, 120};
		int a[]= {3,4,5,6};
		int b[]= {4,5,6,7,8};
		int c[]= {1,4,5,6};
		int n1=a.length;
		int n2=b.length;
		int n3=c.length;
		int i=0;int j=0;int k=0;
		while(i < n1  && j <n2 && k < n3) {
			if(a[i]==b[j] && b[j]==c[k]) {
				System.out.println(a[i]);
				i++;
				j++;
				k++;
			}
			else if(a[i] < b[j])
				i++;
			else if(b[j] < a[i])
				j++;
			else
			k++;
		}
	}

}
