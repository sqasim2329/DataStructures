package com.data.linkedList;

public class InsertIntoSortedCircularLinkedList {
	
	public Node insert(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal,null);
            node.next = node;
            return node;
        }
        
        Node curr = head;
        while(true){
            //case 1. if curr.val < curr.next.val;
            if(curr.val < curr.next.val){
                if(curr.val <= insertVal && insertVal <= curr.next.val){
                    insertAfter(curr,insertVal);
                    break;
                }
            }
            //case 2 , if we are the point of rotation
            if(curr.val > curr.next.val){
                if(curr.val <= insertVal || insertVal <= curr.next.val ){ // insertVal is new max || insertVal is new min
                    insertAfter(curr,insertVal);
                    break;
                }
            }
            
            //case 3, if all are same 
            if(curr.next == head){
                insertAfter(curr,insertVal);
                break;
            }
            curr = curr.next;
        }
        return head;
    }
    
    private void insertAfter(Node curr, int insertVal){
        curr.next = new Node(insertVal,curr.next);
    }

}
