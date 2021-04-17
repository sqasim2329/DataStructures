package com.data.google;

public class OnlineElection {
	
	Map<Integer,Integer> map;//can also treemap
    int[] time;

    public TopVotedCandidate(int[] persons, int[] times) {
        map = new HashMap<>();
        int lead =-1;
        time = times;
        Map<Integer,Integer> count = new HashMap<>();
        for(int i=0;i<persons.length;i++){
           count.put(persons[i],count.getOrDefault(persons[i],0)+1);
           if(i == 0 || count.get(persons[i])>=count.get(lead)) 
               lead = persons[i];
         map.put(times[i],lead);   
        }
        
    }
    
    public int q(int t) {
        int i = Arrays.binarySearch(time, t);
        return i < 0 ? map.get(time[-i-2]) : map.get(time[i]);
    }

}
/**
 * 
 *i = -insertion_point - 1, insertion_point is the first number's index that is strictly greater than the key,
thus, i = -insertion_point - 1 => insertion_point - 1 = - i - 1 - 1, just like in c++ upper_bound() - 1
 * 
 * 
 * 
 */