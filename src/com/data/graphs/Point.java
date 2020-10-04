package com.data.graphs;


class Point{
    int a;
    int b;
    
    public Point(int a, int b){
        this.a=a;
        this.b=b;
    }
    
    public boolean equals(Object obj) {
        if (obj == this) {
           return true;
        }
        if (!(obj instanceof Point)) {
           return false;
        }
        Point emp = (Point) obj;
        return (Integer.compare(a,emp.a)==0 && Integer.compare(b, emp.b) == 0);
     }
}
