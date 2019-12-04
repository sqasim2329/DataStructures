package com.data.heap;

public class MergeSortAlgo {
	
	public static void main(String args[]) {
		int arr[]= {30,20,40,10,80,50,15};
		MergeSort(arr,0,arr.length-1);
		for(int i =0; i < arr.length-1;i++) {
			System.out.println(arr[i]);
		}
	}

	private static void MergeSort(int[] arr, int p, int q) {
		// TODO Auto-generated method stub
		if(p < q) {
			int mid =  (p+q)/2;
			MergeSort(arr,p,mid);
			MergeSort(arr,mid+1,q);
			Merge(arr,p,q,mid);
		}
		
	}

	private static void Merge(int[] arr, int l, int r, int mid) {
		// TODO Auto-generated method stub
		
		int n1 = mid-l+1;
		int n2 = r-mid;
		int L[] = new int[n1];
		int R[] = new int[n2];
		for(int i = 0; i <n1 ;i++) {
			L[i] = arr[l+i];
		}
		
		for(int i = 0; i <n2 ;i++) {
			R[i] = arr[mid+i+1];
		}
		
		int i =0,j=0,k=l;
		while(i < n1 && j < n2) {
			if(L[i] < R[j])
				arr[k++] = L[i++];
			else 
				arr[k++] = R[j++];
			
		}
		
		while(i < n1) {
			arr[k++] = L[i++];
		}
		
		
		while(j < n2) {
			arr[k++] = R[j++];
		}
				
	}

}
