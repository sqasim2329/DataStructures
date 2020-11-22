package com.data.string;

public class MaxDistanceToClosestPerson {
	
public int maxDistToClosest(int[] seats) {
        
        int k=0;
        int maxdistanceSeat = 0;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){//find empty group between people
                k=0;
            }else{
                k++;
                maxdistanceSeat = Math.max(maxdistanceSeat,(k+1)/2);
            }
        }
        
        for(int i=0;i<seats.length;i++){//find max distnace from 0001
            if(seats[i]==1){
                maxdistanceSeat = Math.max(maxdistanceSeat,i);
                break;
            }
        }
        
        for(int i=0;i<seats.length;i++){//find max distnace from 1000
            if(seats[seats.length-1-i]==1){
                maxdistanceSeat = Math.max(maxdistanceSeat,i);
                break;
            }
        }
        
        return maxdistanceSeat;
        
    }

}
