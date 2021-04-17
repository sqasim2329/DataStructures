package com.data.google.microsoft;

public class DesignHashMap {
	
	class MyHashMap {
	    
		   static class ListNode{
		        int key;
		        int val;
		        ListNode next;
		        public ListNode(int key, int val){
		            this.key = key;
		            this.val = val;
		        }
		    }
		    
		    ListNode[] nodes; 

		    /** Initialize your data structure here. */
		    public MyHashMap() {
		       nodes = new ListNode[10000];
		    }
		    
		    /** value will always be non-negative. */
		    public void put(int key, int value) {
		        int hash = hash(key);
		        ListNode bucket = nodes[hash];
		        if(bucket == null){
		            bucket =  new ListNode(-1,-1);
		        }
		        ListNode prev = find(bucket,key);
		        if(prev.next == null){
		            prev.next = new ListNode(key,value);
		        }else{
		            prev.next.val = value;
		        }
		            
		        
		    }
		    
		    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
		    public int get(int key) {
		        int hash = hash(key);
		        ListNode bucket = nodes[hash];
		        if(bucket == null)
		            return -1;
		        ListNode prev = find(bucket,key);
		        if(prev.next!=null){
		            return prev.next.key == key?prev.next.val:-1;
		        }
		        return -1;
		    }
		    
		    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
		    public void remove(int key) {
		        int hash = hash(key);
		        ListNode bucket = nodes[hash];
		        if(bucket == null)
		            return ;
		        ListNode prev = find(bucket,key);
		        if(prev.next!=null)
		            prev.next = prev.next.next;
		    }
		    
		    private int hash(int key){
		        return Integer.hashCode(key)%nodes.length;
		    }
		    
		    private ListNode find(ListNode bucket, int key){
		        ListNode prev = null;
		        ListNode node = bucket;
		        while(node!=null && node.key!=key){
		            prev = node;
		            node = node.next;
		        }
		        return prev;
		    }
		}

		/**
		 * Your MyHashMap object will be instantiated and called as such:
		 * MyHashMap obj = new MyHashMap();
		 * obj.put(key,value);
		 * int param_2 = obj.get(key);
		 * obj.remove(key);
		 */

}
