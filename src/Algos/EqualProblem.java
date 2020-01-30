package Algos;

public class EqualProblem {
	
	class Res{
		int arr[];
	}
	
	public static void main(String args[]) {
		int arr[]= {1,1,3};
		Res res=new EqualProblem().new Res();
		res.arr=arr;
		System.out.println(findMinOperations(res,3,0));
	}

	private static int findMinOperations(Res res,int i,int add) {
		
		if(checkArrEquality(res)) {
			return 1;
		}
		
		if(i < 0)
			return 0;
		
		addValToArray(add,res,i);
		int x=0,y=0,z=0;
		for(int j=res.arr.length-1;j>=0;j--) {
		x=1+findMinOperations(res,j,1);
		y=1+findMinOperations(res,j,2);
		z=1+findMinOperations(res,j,5);
		}
		
		return Math.min(x,Math.min(y,z));
	}

	private static void addValToArray(Integer add, Res res,int j) {
		for(int i=0;i<res.arr.length;i++) {
			if(i!=j)
			res.arr[i]=res.arr[i]+add;
		}
	}

	private static boolean checkArrEquality(Res res) {
		if(res.arr[0]==res.arr[1]) {
			if(res.arr[1]==res.arr[2]) 
			return true;
		}
		return false;
	}

}
