package com.data.linkedList;

public class SplitIntoEqualParts {
	

	public ListNode[] splitListToParts(ListNode head, int k) {
        int N=1;
        ListNode ls[] = new ListNode[k];
        ListNode tail = head;
        while(tail!=null && tail.next!=null){
            tail= tail.next;
            N++;
        }
        
        int size = N/k;// give the min size that each index in array should have
        int extra = N%k;// extra size that arrays must have from index=0
        tail = head;
        
        for(int i=0; i<k && head!=null;i++){// head!= null becuase we dont want to go further than what the list is
            ls[i]=head;
            tail = head;
            int incre = extra >0?1:0;
            for(int j=0;j<(size+incre)-1;j++){
                tail = tail.next;
            }
            head = tail.next;
            tail.next = null;
            extra--;
        }
        
        return ls;
        
    }

}
