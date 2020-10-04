package com.data.linkedList;

public class ReverseLinkedListInGroupsK {
	
public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode curr = head;
        int n=1;
        while(curr.next!=null){
            n++;
            curr = curr.next;
        }
        if(k>n)
            return head;
         
        return reverse(head,n,k);
        
    }
    
    private ListNode reverse(ListNode head, int n , int k){
        if(n<k)
            return head;
        
        ListNode prev = null;
        ListNode curr = head;
        for(int i=1;i<=k;i++){
            ListNode next = curr.next;
            curr.next = prev ;
            prev= curr;
            curr = next;
        }
        
        head.next = reverse(curr,n-k,k);
        return prev;
    }

}
