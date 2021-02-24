package com.data.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//O(n+k)+O(plogp)
public class RelativeSorting {
	
	public static void main(String args[]) {
		int []a = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8,4};
		int []b = {2, 1, 8, 3};
		Map<Integer,Integer> freqMap = new HashMap<>();
		for(int i=0;i<a.length;i++) {
			freqMap.put(a[i],freqMap.getOrDefault(a[i],0)+1);
		}
		List<Integer> ls = new ArrayList<>();
		for(int i = 0; i< b.length;i++) {
			if(freqMap.containsKey(b[i])) {
				int count  = freqMap.get(b[i]);
				while(count-- > 0)
				ls.add(b[i]);
				freqMap.remove(b[i]);
			}
		}
		Collections.sort(new ArrayList<>(freqMap.keySet()),new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return Integer.compare(o1, o2);
			}
		});
		for(Map.Entry<Integer, Integer> e: freqMap.entrySet()) {
			int count  = e.getValue();
			while(count-- > 0)
			ls.add(e.getKey());
		}
		
		ls.stream().mapToInt(i->i).forEach(System.out::print);;
		}

}
