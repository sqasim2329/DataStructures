package com.data.heap;

public class PowerXN {
	
public double myPow(double x, int n) {
        
        if(n== -2147483648)
            n = -2147483648 +1;//java vauses overflow and becomes positiuve
        double ans = 1.0;
        int m=n;
        double y =x;
        if(n<0) m=n*-1;
        while(m>0){
            if(m%2==1){
                ans =ans*x;
                m=m-1;
            }else{
                x =x*x;
                m=m/2;
            }
        }
        
        if(n < 0) return (1.0/ans)*(y<0?-1:1);
        else return ans;
        
    }

}
