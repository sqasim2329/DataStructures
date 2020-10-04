package com.data.arrays;
///basically fr and fc are just markers to say if fr and fc have a zero
//but actual logic is whenever there is a zero other than fr and fc we 
//update that row's first column to 0 as indicator and also update that columns first row to 0 
public class SetMatrizZero {
	
	public static void main(String args[]) {
		int [][]arr= {
		           {1,1,1},
		           {1,0,1},
		           {1,1,1}
		};
		int n=arr.length;
		int m=arr[0].length;
		boolean fr=false;boolean fc=false;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==0) {
					arr[i][0]=0;
					arr[0][j]=0;
					if(i==0)
						fr=true;
					if(j==0)
						fc=true;
				}
				
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				if(arr[i][0]==0||arr[0][j]==0) {//then use this as indicator for updating the values
					arr[i][j]=0;
				}
			}
		}
		
		if(fr) {
			for(int i=0;i<m;i++)
				arr[0][i]=0;
		}
		
		if(fc) {
			for(int i=0;i<m;i++)
				arr[i][0]=0;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	

}
