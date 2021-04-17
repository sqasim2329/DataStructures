package BitMasking;

import com.data.binaryTree.Node;

public class LengthOfLongestPalindromeInLinkedList {
	
	public static int maxPalindrome(Node head)
    {
       Node curr = head;
       int res = 0;
       Node prev = null;
       while(curr!=null){
           Node next = curr.next;
           curr.next = prev;
           
           res = Math.max(res,2*countMatching(prev,next)+1); //prev -> curr -> next// so odd, hence +1
           res = Math.max(res,2*countMatching(curr,next));//curr -> next // so even
           prev = curr;
           curr = next;
       }
       return res;
    }
    
    private static int countMatching(Node a, Node b){
        int count =0;
        for(;a!=null && b!= null ; a = a.next , b = b.next){
            if(a.data == b.data)
                count++;
            else
            break;
        }
        return count;
    }

}
