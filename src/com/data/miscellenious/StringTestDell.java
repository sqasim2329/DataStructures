package com.data.miscellenious;

public class StringTestDell {
	
	public static void main(String args[]) {
	
		Q[]
        char[] out = new char[Q.length];
        for(int j=0; j < Q.length; j++){
            int L = Q[j][0];
            int R = Q[j][1];
            int K = Q[j][2];
            
                if(L==R){
                    out[j] =  arr[L-1].charAt(K-1);
                }
                else{
                int previousElementsCount=0;
                int count=1;
                for(int i=L-1;i<R;i++){
                    System.out.println(arr[i].length());
                    if(null!=arr[i] && !arr[i].isEmpty() && K <= arr[i].length()*count && K > previousElementsCount){
                        out[j] = arr[i].charAt(K-previousElementsCount-1);
                    }
                    previousElementsCount = count*arr[i].length();
                    count++;
                    }
                }
        }

        
    }

}

