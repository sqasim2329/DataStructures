package com.data.linkedin;

public class FindKSmallestPairinTwoSortedArrays {
	
	class Solution {
	    class Node{
	        int val;
	        int i;
	        int j;
	        public Node(int i, int j, int val){
	            this.i = i;
	            this.j = j;
	            this.val = val;
	        }
	    }
	    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	        List<List<Integer>> ls = new ArrayList<>();
	        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
	        pq.add(new Node(0,0,nums1[0]+nums2[0]));
	        while(!pq.isEmpty() && k > 0){
	            Node node = pq.poll();
	            List<Integer> l = new ArrayList<>();
	            l.add(nums1[node.i]);
	            l.add(nums2[node.j]);
	            ls.add(l);
	            k--;
	            if(node.j < nums2.length-1){
	                pq.add(new Node(node.i,node.j+1,nums1[node.i]+nums2[node.j+1]));
	            }
	            
	            if(node.j == 0 && node.i < nums1.length-1)// why only node.j == 0 becuase smallest elemennt is already in. heap
	                pq.add(new Node(node.i+1,0,nums1[node.i+1]+nums2[0]));
	        }
	        
	        return ls;
	        
	        
	    }
	}   
//	         2  4  6 
//	     1   3. 5  7
//	     7   9. 11 13
//	    11   13 15 17 


	// heap =. 1,2.  1,5.  1,9
//	              1,5 1,7 1,9  1,11--> this can be added but already the smallest element is there in heap which is 1,9 hence not adding
	            
	            
	  

}
