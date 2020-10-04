package com.data.linkedList;

public class IsPalindrome {
	
public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = head;
        slow = reverse(slow);
        
        while(slow!=null){
            if(slow.val == fast.val){
                slow = slow.next;
                fast = fast.next;
            }
            else{
                return false;
            }
        }
        
        return true;
        
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode newHead = head;
        while(head!=null){
        ListNode ref = head.next;
        head.next = prev;
        prev= head;
        head = ref;
        }
        return prev;
        
    }

}

//https://www.techiedelight.com/sort-linked-list-containing-0s-1s-2s/
//https://www.geeksforgeeks.org/sort-linked-list-0s-1s-2s-changing-links/
