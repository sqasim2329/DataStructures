package com.data.google;

public class RemoveComments {
	
	List<String> result= new ArrayList<>();
    boolean inBlock=false;
    StringBuilder sb = new StringBuilder();
    for(String sub:source){
        int i=0;
        if(!inBlock) sb = new StringBuilder();
        while(i < sub.length()){
            if(!inBlock &&i < sub.length()-1 && sub.charAt(i) == '/' && sub.charAt(i+1)=='*'){
                inBlock = true;
                i=i+1;
            }
            else if(inBlock && i < sub.length()-1 && sub.charAt(i) == '*' && sub.charAt(i+1)=='/')
            {
                inBlock = false;;
                i=i+1;
            }
            else if(!inBlock && i < sub.length()-1 && sub.charAt(i) == '/' && sub.charAt(i+1)=='/')
                break;
            
            else if(!inBlock)
               sb.append(sub.charAt(i)); 
        
             i++;
        }
        if(!inBlock && sb.length()!=0)
        result.add(sb.toString());
    }
    return result;
}

}
