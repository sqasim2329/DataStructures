package com.data.miscellenious;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LRUCache {
	
	private Deque<Integer> dq;
	private HashSet<Integer> set;
	int csize ;
	public LRUCache() {
		dq =new LinkedList<Integer>();
		set = new HashSet<Integer>();
		csize = 4;
		
	}
	
	public void refer(int val) {
		if(!set.contains(val)) {
			if(dq.size() == csize) {
				set.remove(dq.removeLast());
			 }
			}else {
				int index = 0, i=0;
				Iterator<Integer> itr =dq.iterator();
				while(itr.hasNext()) {
					if(itr.next() == val) {
						index =i;
						break;
					}
					i++;
				}
				dq.remove(index);
			}
			
			dq.push(val);
			set.add(val);
		}
	
	 public void display() 
	    { 
	        Iterator<Integer> itr = dq.iterator(); 
	        while(itr.hasNext()) 
	        { 
	            System.out.print(itr.next()+" "); 
	        } 
	    }
	
	public static void main(String args[]) {
		LRUCache c = new LRUCache();
		c.refer(1);
		c.refer(2);
		c.refer(3);
		c.refer(1);
		c.refer(4);
		c.refer(5);
		
		c.display();
		
		
		
	}

}
