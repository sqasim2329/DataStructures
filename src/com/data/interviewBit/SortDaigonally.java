package com.data.interviewBit;

public class SortDaigonally {
	

    public int[][] diagonalSort(int[][] mat) {
        if(mat.length == 0 || mat[0].length==0)
            return mat;
       int rows = mat.length;
        int cols = mat[0].length;
        for(int i=0;i<rows;i++) sortNUpdate(i,0,mat);
        for(int i=1;i<cols;i++) sortNUpdate(0,i,mat);
        return mat;
    }
    
    private void sortNUpdate(int row, int col,int[][] mat){
        int r = row; 
        int c = col;
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> a-b);
        while(row < mat.length && col < mat[0].length){
            q.add(mat[row][col]);
            row++;
            col++;
        }
        
        while(r < mat.length && c < mat[0].length){
            mat[r][c] = q.poll();
            r++;
            c++;
        }
    }

}
