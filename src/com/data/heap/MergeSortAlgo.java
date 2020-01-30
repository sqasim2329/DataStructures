package com.data.heap;

public class MergeSortAlgo {
	
	public static void main(String args[]) {
		int arr[]= {1, 20, 6, 4, 5};
		System.out.println(MergeSort(arr,0,arr.length-1));
		for(int i =0; i < arr.length-1;i++) {
			System.out.println(arr[i]);
		}
	}

	private static int MergeSort(int[] arr, int p, int q) {
		// TODO Auto-generated method stub
		int count=0;
		if(p < q) {
			int mid =  (p+q)/2;
			count +=MergeSort(arr,p,mid);
			count +=MergeSort(arr,mid+1,q);
			count+=Merge(arr,p,q,mid);
		}
		return count;
		
	}

	private static int Merge(int[] arr, int l, int r, int mid) {
		// TODO Auto-generated method stub
		
		int n1 = mid-l+1;
		int n2 = r-mid;
		int L[] = new int[n1];
		int R[] = new int[n2];
		int count=0;
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
			else {
				arr[k++] = R[j++];
				count+=mid-i+1;
			}
			
		}
		
		while(i < n1) {
			arr[k++] = L[i++];
		}
		
		
		while(j < n2) {
			arr[k++] = R[j++];
		}
		return count;
				
	}

}
