package com.data.linkedList;

public class ReverseLinkedListInGroupsK {
	
public ListNode reverseKGroup(ListNode head, int k) {
	 int n =0;
     ListNode curr = head;
     while(curr!=null){
         n++;
         curr = curr.next;
     }
    return reverseInGroups(head,k,n);
 }
 
 private ListNode reverseInGroups(ListNode head,int k, int n){
     if(k>n)
         return head;
     ListNode curr = head;
     ListNode prev = null;
     for(int i=0;i<k;i++){
         ListNode ref = curr.next;
         curr.next = prev ;
         prev =curr;
         curr = ref;
     }
     head.next=reverseInGroups(curr,k,n-k);
     return prev;
 }

}
