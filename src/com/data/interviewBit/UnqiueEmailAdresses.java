package com.data.interviewBit;

public class UnqiueEmailAdresses {
	
	Set<String> seen = new HashSet<>();
    for(String email:emails){
        StringBuilder sb = new StringBuilder();
        int i=0;
        int index = email.indexOf("@");
        String left = email.substring(0,index+1);
        String right = email.substring(index);
        while(i < left.length()){
            if(Character.isLetterOrDigit(email.charAt(i))){
                sb.append(email.charAt(i));
            }
            else if(email.charAt(i) == '+'){
                break;
            }
            i++;
        }
        seen.add(sb.append(right).toString());
    }
    return seen.size();

}

}
