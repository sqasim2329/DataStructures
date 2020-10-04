package com.data.linkedList;
class Node{
	public int val;
    public Node prev;
    public Node next;
    public Node child;
}
public class FlattenMultiuValuedLinkedList {
	
	public Node flatten(Node head) {
        if(head == null)
            return head;
        
        Node curr = head;
        while(curr!= null){
            if(curr.child!=null){
                Node next = curr.next;
                next.prev=null;
                Node child = flatten(curr.child);
                curr.next = child;
                child.prev=curr;
                while(child.next != null)
                    child = child.next;
                child.next = next;
                next.prev= child;
                curr = next;
            }
            curr = curr.next;
        }
        return head;

    }

}
