package com.data.google;

public class BullsAndCows {
	
public String getHint(String secret, String guess) {
        
        int[] scretFreq = new int[10];
        int[] guessFreq = new int[10];
        int bulls= 0;
        int cows= 0;
        for(int i=0;i<secret.length();i++){
            char sec = secret.charAt(i);
            char gue = guess.charAt(i);
            if(sec == gue){
                bulls++;
            }else{
                scretFreq[sec-'0']++;
                guessFreq[gue-'0']++;
            }
        }
        
        for(int i=0;i<10;i++){
            cows +=Math.min(scretFreq[i],guessFreq[i]);
        }
        
        return bulls+"A"+cows+"B";
    }

}
