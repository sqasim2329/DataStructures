package com.data.google.microsoft;

public class MaxStack {
	
	class MaxStack {

	    /** initialize your data structure here. */
	   class Node{
	       int key;
	       Node prev;
	       Node next;
	       public Node(int key){
	           this.key = key;
	       }
	   }
	   Node head;
	   Node tail;
	   TreeMap<Integer,LinkedList<Node>> map;
	    public MaxStack() {
	       head = new Node(-1);
	       tail = new Node(-1);
	       head.next = tail;
	       tail.prev = head;
	        map = new TreeMap<>();
	    }
	    
	    public void push(int x) {
	        Node node = new Node(x);
	        Node tmp = tail.prev;
	        node.next = tmp.next;
	        node.next.prev = node;
	        tmp.next = node;
	        node.prev = tmp;
	        map.putIfAbsent(x,new LinkedList());
	        map.get(x).add(node);
	    }
	    
	    public int pop() {
	       
	        Node pop = tail.prev;
	        pop.prev.next = pop.next;
	        pop.next.prev = pop.prev;
	        LinkedList<Node> ls = map.get(pop.key);
	        ls.remove(ls.size()-1);
	        if(ls.size()==0)
	            map.remove(pop.key);
	        else
	            map.put(pop.key,ls);
	        return pop.key;
	       
	    }
	    
	    public int top() {
	        return tail.prev.key;
	    }
	    
	    public int peekMax() {
	        return map.lastKey();
	    }
	    
	    public int popMax() {
	        int key = map.lastKey();
	        LinkedList<Node> ls = map.get(key);
	        Node pop = ls.remove(ls.size()-1);
	        pop.prev.next = pop.next;
	        pop.next.prev = pop.prev;
	        if(ls.size()==0)
	            map.remove(key);
	        else
	            map.put(key,ls);
	        return pop.key;
	    }
	}

	/**
	 * Your MaxStack object will be instantiated and called as such:
	 * MaxStack obj = new MaxStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.peekMax();
	 * int param_5 = obj.popMax();
	 */

}
