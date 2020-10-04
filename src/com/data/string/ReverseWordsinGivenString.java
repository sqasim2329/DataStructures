package com.data.string;
//https://javarevisited.blogspot.com/2016/02/2-ways-to-split-string-with-dot-in-java-using-regular-expression.html
public class ReverseWordsinGivenString {
	public static void main(String args[]) {
	String str="i.like.this.program.very.much";
	String arr[]=str.split("\\.");
	StringBuffer buf=new StringBuffer();
	int i=0;
	int j=arr.length-1;
	while(i<j) {
		String tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		i++;
		j--;
	}
for(String s:arr) {
	buf.append(s).append('.');
}
System.out.println(buf);
	}

}
