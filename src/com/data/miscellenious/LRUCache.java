package com.data.miscellenious;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LRUCache {
	
	class LRUCache {

    Map<Integer, Node> map;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {

        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insertAtHead(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.size() == capacity) {
            remove(tail.prev);
        }

        if(map.containsKey(key)) {
          Node oldNode = map.get(key);
          remove(oldNode); 
        } 
        Node newNode = new Node(key, value);
        insertAtHead(newNode);       
    }

    class Node {
        int val, key;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}
