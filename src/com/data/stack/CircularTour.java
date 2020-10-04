 package com.data.stack;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/gas-station/submissions/
public class CircularTour {

	
	public static class PetrolPump{
		private int petrol;
		private int distToNext;
		
		PetrolPump(int petrol, int distToNext){
			this.petrol = petrol;
			this.distToNext = distToNext;
		}
	}
	
	public static void main(String args[]) {
		 PetrolPump a = new PetrolPump(87,27);
		 PetrolPump b = new PetrolPump(40, 95);
		 PetrolPump c = new PetrolPump(71 ,96);
		 PetrolPump d = new PetrolPump(79, 35);
		 PetrolPump e = new PetrolPump(2, 68);
		 PetrolPump f = new PetrolPump(3, 98);
		 PetrolPump g = new PetrolPump(93, 18);
		 PetrolPump h = new PetrolPump(57, 53);
		 PetrolPump i = new PetrolPump(81, 2);
		 PetrolPump j = new PetrolPump(42, 87);
		 PetrolPump k = new PetrolPump(90, 66);
		 PetrolPump l = new PetrolPump(20, 45);
		 PetrolPump m = new PetrolPump(30, 41);PetrolPump[] p = {a,b,c,d,e,f,g,h,i,j,k,l,m};
//		findStartingIndexToCompletedCircularTour(p);
//		 int petrol[]= {96,46,68,65,51,9,79,85};
//		 int distance[]= {25,83,15,35,44,88,77,89};
		 int []petrol = {4,6,7,4};
		 int []distance = {6,5,3,5};
		 System.out.println(canCompleteCircuit(petrol,distance));
		
	}

	private static void findStartingIndexToCompletedCircularTour(PetrolPump[] p) {
		int start =0;
		int end =0;
		int currentPetrol = 0; 
		for(int i = 0; i < p.length; i++) {
			start = i;
			end  = i+1;
			currentPetrol = p[i].petrol-p[i].distToNext;
			while(currentPetrol >= 0 && end!=start) {
				currentPetrol += p[end].petrol-p[end].distToNext;
				end = (++end) % p.length;
				
			}
			if(end == start) {
				break;
			}else {
				currentPetrol = 0;
			}
		}
		System.out.println("start:"+start);
	  }
	

	
public static int canCompleteCircuit(int[] gas, int[] cost) {
        
        int sumG = 0;
        int sumC = 0;
        int start = 0;
        int tank =0;
        for(int i=0;i<gas.length;i++){
            sumG += gas[i];
            sumC += cost[i];
            tank +=gas[i]-cost[i];
            if(tank < 0){
                start = i+1;
                tank =0;
            }
        }
        
        if(sumG < sumC)
            return -1;
        else
            return start;
        
    }

}


//At any point if tank is empty then start point will be next;
//if Sum of gas < sum of cost then in no way it is possible to reach

