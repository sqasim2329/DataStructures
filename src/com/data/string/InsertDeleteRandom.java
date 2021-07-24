package com.data.string;

import java.util.Random;

public class InsertDeleteRandom {
	
	class RandomizedSet {
	    
	    Map<Integer,Integer> dict;
	    List<Integer> ls;
	    Random rand = new Random();

	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        dict = new HashMap<>();
	        ls = new ArrayList<>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        
	        if(dict.containsKey(val))
	            return false;
	        
	        dict.put(val,ls.size());
	        ls.add(ls.size(),val);
	        return true;
	        
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!dict.containsKey(val))
	            return false;
	        
	        int lastElement = ls.get(ls.size()-1);
	        int index = dict.get(val);
	        ls.set(index,lastElement);
	        dict.put(lastElement,index);
	        ls.remove(ls.size()-1);
	        dict.remove(val);
	        return true;
	        
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        return ls.get(rand.nextInt(ls.size()));
	    }
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet();
	 * boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val);
	 * int param_3 = obj.getRandom();
	 */

}


class RandomizedCollection {
    
    List<Integer> dict;
    Map<Integer,Set<Integer>> valToIndicesMap;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        dict = new ArrayList<>();
        valToIndicesMap = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        valToIndicesMap.putIfAbsent(val,new LinkedHashSet<>());
        valToIndicesMap.get(val).add(dict.size());
        dict.add(val);
        return valToIndicesMap.get(val).size()==1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!valToIndicesMap.containsKey(val) || valToIndicesMap.get(val).size()==0)
            return false;
        
        Iterator<Integer> itr = valToIndicesMap.get(val).iterator();
        int index = itr.next(); 
        valToIndicesMap.get(val).remove(index);
        int ele = dict.get(dict.size()-1);
        valToIndicesMap.get(ele).add(index);
        valToIndicesMap.get(ele).remove(dict.size()-1);
        dict.set(index,ele);
        dict.remove(dict.size()-1);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return dict.get(rand.nextInt(dict.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
