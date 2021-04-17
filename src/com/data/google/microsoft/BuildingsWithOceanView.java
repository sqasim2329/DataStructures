package com.data.google.microsoft;

public class BuildingsWithOceanView {
	
	public int[] findBuildings(int[] heights) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            while(!stk.isEmpty() && heights[stk.peek()] <= heights[i]){
                stk.pop();
            }
            stk.push(i);
        }
        
        while(!stk.isEmpty()){
            ls.add(0,stk.pop());
        }
        
        return ls.stream().mapToInt(i -> i).toArray();
        
    }
	
	public int[] findBuildings(int[] heights) {
        int n = heights.length;
        int max_hieght_right = n-1;
        List<Integer> ls= new ArrayList<>();
        ls.add(max_hieght_right);
        for(int i=n-2;i>=0;i--){
            if(heights[max_hieght_right] >= heights[i])
                continue;
            if(heights[max_hieght_right] < heights[i]){
                max_hieght_right = i;
            }
            ls.add(i);//ls.add(0,i) is very slow
            
        }
        
        Collections.reverse(ls);//hence this is good
        return ls.stream().mapToInt(i->i).toArray();
        
    }

}
