 package com.data.stack;

import java.util.LinkedList;
import java.util.Queue;

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
		findStartingIndexToCompletedCircularTour(p);
		
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
	}
		
