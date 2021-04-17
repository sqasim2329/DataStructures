package com.data.google;

public class StudentAttendanceRecord {
	
	public boolean checkRecord(String s) {
        int countAbsent=0;
        int countLate=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                countAbsent++; if(countAbsent>1)return false;
                countLate = 0;
            }
            else if(s.charAt(i) == 'L'){
                countLate++; if(countLate > 2) return false;
            }else{
                countLate=0;
            }
        }
        
        return true;
        
    }

}
