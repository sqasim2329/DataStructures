package com.data.google.microsoft;

public class PairsSum {
	
	 Map<Integer,Set<Integer>> map = new HashMap<>();
     for(int i=0;i<n;i++){
         map.putIfAbsent(a[i]%k,new HashSet<>());
         map.get(a[i]%k).add(i);
     }
     int count = 0;
     if(map.containsKey(0)){
         Set<Integer> pairs = map.get(0);
         for(int i:pairs){
             for(int j:pairs){
                 if(i < j)
                 count++;
             }
         }
     }
     for(Map.Entry<Integer,Set<Integer>> entry:map.entrySet()){
         int key = entry.getKey();
         Set<Integer> ind1 = entry.getValue();
         if(map.containsKey(k-key)){
             Set<Integer> ind2 = map.get(k-key);
             for(int i:ind1){
                 for(int j:ind2){
                     if(i < j)
                         count++;
                 }
             }
         }
     }
     System.out.println(count);

}
