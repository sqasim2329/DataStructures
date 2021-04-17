class Solution {
    
    private final String[] belowTen = new String[] {"","One","Two","Three", "Four","Five","Six","Seven","Eight","Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return numberToWordss(num);
    }
    
    private String numberToWordss(int num){
        String result = "";
        if(num < 10) result= belowTen[num];
        else if(num < 20 ) result= belowTwenty[num-10];
        else if(num < 100) result= belowHundred[num/10] + " " + belowTen[num%10];
        else if(num < 1000) result= numberToWordss(num/100)+" Hundred " + numberToWordss(num%100);
        else if(num < 1000000) result= numberToWordss(num/1000) + " Thousand " + numberToWordss(num%1000);
        else if(num < 1000000000) result= numberToWordss(num/1000000) + " Million " + numberToWordss(num%1000000);
        else result= numberToWordss(num/1000000000) + " Billion " + numberToWordss(num%1000000000);
        return result.trim();
    }
}



// 123
    
// 1 hundred +(23)
//             twenty + (3)    
//                         three
//                         one hundred Twenty three
// 12345 
// twelve thousand  +(345)   
//                     three hundred + (45)
//                                       forty five;  
    
    
    
    
    