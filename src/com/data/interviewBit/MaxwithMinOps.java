package com.data.interviewBit;

public class MaxwithMinOps {
	
	// "static void main" must be defined in a public class.
	 class Pair{
	        int first ;
	        int second;
	        public Pair(int first, int second){
	            this.first = first;
	            this.second =second;
	        }
	    }
	public class Main {
	    
	   
	    public static void main(String[] args) {
	        System.out.println("Hello World!");
	        int[] nums ={10, 8, 15, 12, 6, 20, 20, 1};
	        Pair p = getSecmax(nums,0,nums.length-1);
	        System.out.println(p.second);
	    }
	    
	    private static Pair getSecmax(int[] nums, int lo, int hi){
	        Pair p = new Pair(-1,-1);
	        if(lo == hi)
	        {
	            p.first = nums[0];
	            p.second = nums[0];
	            return p;
	        }
	        
	        if(hi==lo+1){
	            if(nums[0]<nums[1]){
	                      p.first = nums[1];  
	                      p.second = nums[0];
	            }else{
	                      p.first = nums[0];  
	                      p.second = nums[1];
	            }
	            
	            return p;
	        }
	        
	        
	        int mid = lo+(hi-lo)/2;
	        Pair p1 = getSecmax(nums,lo,mid);
	        Pair p2 = getSecmax(nums,mid+1,hi);
	        
	        if(p1.first < p2.first){
	            p.first = p2.first;
	            p.second = Math.max(p1.first,Math.max(p2.second,p1.second));
	        }else{
	            p.first = p1.first;
	            p.second = Math.max(p1.second,Math.max(p2.first,p2.second));
	        }
	                                
	                                return p;
	    }
	}


	// 10, 8, 15, 12,     6, 20, 20, 1
	    
	    
//	     10 8  15 12      max = 20 sec = 6 
	      
//	         max = 20
//	        sec =15
	    
	    

}
