package com.data.google;

public class CarFleet {
	
	class Car implements Comparable<Car>{
        int pos;
        double time;
        
        public Car(int pos, double time){
            this.pos = pos;
            this.time = time;
        }
        @Override
        public int compareTo(Car other){
           return this.pos - other.pos;
        }
    }
    //assumption is time taken by car on right if less than car on left then it cannot form a fleet, since it is sorted as per position
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for(int i=0;i<position.length;i++){
            cars[i]=new Car(position[i],((double)(target-position[i]))/speed[i]);
        }
        
        Arrays.sort(cars,(a,b)-> Integer.compare(a.pos,b.pos));
        int t = position.length;
        int ans =0;
        while(--t > 0){
            if(cars[t].time< cars[t-1].time)ans++;
            else
                cars[t-1]=cars[t];
        }
        
        return ans+(t == 0?1:0);
        
       
    }

}
