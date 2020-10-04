package com.data.greedy;

import java.util.Arrays;

public class AssignMiceToHoles {
	
	public static void main(String args[]) {
		int mice[]= {-10, -79, -79, 67, 93, -85, -28, -94};
		int holes[]= {-2, 9, 69, 25, -31, 23, 50, 78};
		
		Arrays.sort(mice);
		Arrays.sort(holes);
		
		int time = 0;
		for(int i=0;i<mice.length;i++) {
			time = Math.max(time, Math.abs(mice[i]-holes[i]));
		}
		System.out.print(time);
		
	}

}
