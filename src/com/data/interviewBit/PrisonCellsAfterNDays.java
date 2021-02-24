package com.data.interviewBit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//O(1) actually it 8 cells right - 2 on ends since tehy will always be same so each cell can have 0/1 so 2 ^ 6
//O(2^6)
public class PrisonCellsAfterNDays {
	
public int[] prisonAfterNDays(int[] cells, int N) {
        
        if(cells.length==0 || N==0)
            return cells;
        
        Set<String> seen = new HashSet<>();
        int day=0;
        boolean isCyclic =false;
        for(int i=0; i<N ;i++){
            int[] next = getNextState(cells);
            String cellString = Arrays.toString(next);
            if(!seen.contains(cellString)){
                seen.add(cellString);
                day++;   
            }else{
                isCyclic = true;
                break;
            }
            cells = next;
        }
        
        if(isCyclic){
            N%=day; // after every "x day" it is repeating, hence check only for remaining day
            for(int i=0;i<N;i++){
                cells = getNextState(cells);
            }
        }
        return cells;
    }
    
    private int[] getNextState(int []cells){
        int[] tmp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++)
            if(cells[i-1]==cells[i+1])
                tmp[i]=1;
            else
                tmp[i]=0;
        return tmp;    
    }
}

}
