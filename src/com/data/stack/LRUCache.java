package com.data.stack;

	
import java.util.Hashtable;

public	class LRUCache {
	    
	        class Node{
	        int key;
	        int val;
	        Node next;
	        Node prev;
	            
	            public Node(){}
	            public Node(int key,int val){
	                this.key=key;
	                this.val=val;
	            }
	        }
	    Node head,tail;
	    int count,capacity;
	    Hashtable<Integer,Node> cache;
	    private void addToHead(Node node){
	        node.next = head.next;
	        node.next.prev = node;
	        head.next = node;
	        node.prev =head;
	    }
	    
	    private void remove(Node node){
	        node.prev.next = node.next;
	        node.next.prev = node.prev;
	    }
	    
	    private Node removeFromTail(){
	        Node poped = tail.prev;
	        this.remove(poped);
	        return poped;
	    }
	    
	    private void moveToHead(Node node){
	        this.remove(node);
	        this.addToHead(node);
	    }
	        
	    

	    public LRUCache(int capacity) {
	        Node head = new Node();
	        Node tail = new Node();
	        this.capacity = capacity;
	        this.count = 0;
	        this.cache = new Hashtable<Integer,Node>();
	        head.next = tail;
	        head.prev = null;
	        tail.prev=head;
	        tail.next = null;
	    }
	    
	    public int get(int key) {
	        Node node = this.cache.get(key);
	        if(node== null)
	            return -1;
	        else{
	            this.moveToHead(node);
	            return node.val;
	        }
	        
	    }
	    
	    public void put(int key, int value) {
	        Node node=this.cache.get(key);
	        if(node == null){
	            node = new Node(key,value);
	            this.cache.put(key,node);
	            this.addToHead(node);
	            count++;
	            if(count > capacity){
	                Node poped = this.removeFromTail();
	                this.cache.remove(poped.key);
	                count--;
	            }
	        }else{
	            node.val = value;
	            this.moveToHead(node);
	        }
	        }
	        
	    }


	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
