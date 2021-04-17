package com.data.google;

public class ShoppingOffers {
	
	class Solution {
	    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
	        
	        //calculate without offer
	        int costWOOffer = calculateWithOutOffer(price,needs);
	        //calculate based on special offer
	        
	        for(int i=0;i<special.size();i++){
	            List<Integer> specialOffer = special.get(i);
	            List<Integer> tmpNeeds = new ArrayList<>(needs);
	            for(int j=0;j<tmpNeeds.size();j++){
	                int diff = tmpNeeds.get(j) - specialOffer.get(j);
	                if(diff < 0){
	                    tmpNeeds = null;
	                    break;
	                }else{
	                    tmpNeeds.set(j,diff);
	                }
	            }
	            if(tmpNeeds!=null){
	                costWOOffer = Math.min(costWOOffer,specialOffer.get(specialOffer.size()-1)+shoppingOffers(price,special,tmpNeeds));
	            }
	        }
	        
	        return costWOOffer;
	        
	        
	    }
	    
	    private int calculateWithOutOffer(List<Integer> price,List<Integer> needs){
	        int sum =0;
	        for(int i=0;i<needs.size();i++){
	            sum+=needs.get(i)*price.get(i);
	        }
	        return sum;
	    }
	}


	// [3,4]
	// [[1,2,3],[1,2,5]]


	// [2,2]


	// 14

	// 3+3


	    
	    

}
