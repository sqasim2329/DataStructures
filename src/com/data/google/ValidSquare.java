package com.data.google;

import java.util.Arrays;

public class ValidSquare {
	
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        int[][] p = {p1,p2,p3,p4};
        Arrays.sort(p,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        for(int[] pi:p)
        System.out.println(pi[0]+"--"+pi[1]);
        return distance(p[0],p[1]) != 0  && distance(p[0],p[1])==distance(p[1],p[3]) && distance(p[1],p[3])==distance(p[3],p[2])
            && distance(p[3],p[2])==distance(p[2],p[0]) && distance(p[0],p[3])==distance(p[1],p[2]);
    }
    
    
    private int distance(int[] p1, int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
       
// // 0,1  1,1    


// // 0,0. 1,0


// first we will have x axis then y axis
/***		b
 * 		----------	
 * 		|		 |	
 * 		a| 		 |	c
 * 		|		 |
 *      ----------	
 * 			d      diaogonal and antidiagonal
 * *******/

}
