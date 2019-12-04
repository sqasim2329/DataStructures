package com.data.linkedList;
public class GFG 
{ 
  private static  int size = 0;
  protected static int i=10;
  static int j=20;
// Structure for a node  
static class Node  
{  
    int data;  
    Node next;
};  
  
// Function to insert a node at the begining  
// of a Circular linked list  
static Node push(Node head_ref, int data)  
{  
    Node ptr1 = new Node();  
    Node temp = head_ref;  
    ptr1.data = data;  
    ptr1.next = head_ref;  
  
    // If linked list is not null then  
    // set the next of last node  
    if (head_ref != null)  
    {  
        while (temp.next != head_ref)  
            temp = temp.next;  
        temp.next = ptr1;  
        size ++;
        return head_ref; 
    }  
    else
        ptr1.next = ptr1; // For the first node  
  
    head_ref = ptr1;
    
    size ++;
return head_ref; 
}  
  
// Delete the node if it is even  
static Node deleteNode(Node head_ref, Node del)  
{  
    Node temp = head_ref;  
    // If node to be deleted is head node  
  
    if (head_ref.data == del.data  )  {
    	head_ref = del.next;
    	if(head_ref.next.data == del.data && size > 1) {
    		head_ref.next = null;
    		head_ref.next = head_ref;
    		size --;
    	    return head_ref; 
    	}else if(head_ref.next == del && size == 1) {
    		head_ref = null;
    		size--;
    		return head_ref;
    	}
    	return head_ref;
    	
    }
    
    // travers list till not found  
    // delete node  
    while (temp.next != del && size>1) 
    {  
        temp = temp.next;  
    }  
  
    // copy address of node  
    temp.next = del.next;  
    size --;
    return head_ref;  
}  
  
// Function to delete all even nodes  
// from the singly circular linked list  
static Node deleteEvenNodes(Node head)  
{  
    Node ptr = head;  
  
    Node next;  
  
    // traverse list till the end  
    // if the node is even then delete it  
    while(ptr!=null ) 
    {  
        // if node is even  
        if (ptr.data % 2 == 0)  
        	head = deleteNode(head, ptr);  
        else head = head.next;
        // point to next node
        ptr = head;
        next = ptr!=null?ptr:null;  
        ptr = next;  
    }  
    return head; 
}  
  
// Function to print nodes  
static void printList(Node head)  
{  
    Node temp = head;  
    if (head != null) 
    {  
        do 
        {  
            System.out.printf("%d ", temp.data);  
            temp = temp.next;  
        }  
        while (temp != head);  
    } else {
    	System.out.println("Empty list");
    }
}  
  
// Driver code  
public static void main(String args[]) 
{  
    // Initialize lists as empty  
    Node head = null;  
  
    // Created linked list will be 57.11.2.56.12.61
    head=push(head, 612);  
    head=push(head, 12);  
    head=push(head, 56);  
    head=push(head, 2);  
    head=push(head, 11);  
    head=push(head, 57);  
  
    System.out.println( "\nList after deletion : ");  
    head=deleteEvenNodes(head);  
    printList(head);  
}  
} 
  