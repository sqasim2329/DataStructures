package com.data.google;

public class RandomPickWeight {
	
	TreeMap<Integer,Integer> treeMap;
    int sum;
    Random rand;
    public Solution(int[] w) {
        this.sum = 0;
        rand = new Random();
        treeMap = new TreeMap<>();
        for(int i=0;i<w.length;i++){
            treeMap.put(sum,i);
            sum+=w[i];
        }
    }
    
    public int pickIndex() {
        return treeMap.floorEntry(rand.nextInt(sum)).getValue();
    }

}

//say we have the numbers 1, 5, 2 easiest solution is to construct the following array
//arr[] = {0,1,1,1,1,1,2,2}
//then generate a random number between 0 and 7 and return the arr[rnd]. This is solution is not really good though due to the space requirements it has (imagine a number beeing 2billion).
//
//The solution here is similar but instead we construct the following array (accumulated sum)
//{1, 6, 8} generate a number between 1-8 and say all numbers generated up to 1 is index 0. all numbers generated greater than 1 and up to 6 are index 1 and all numbers greater than 6 and up to 8 are index 2. After we generate a random number to find which index to return we use binary search.