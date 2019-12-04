package com.data.miscellenious;

public class SomeClass {
	public static void main(String[] args)
    {
        System.out.println(methodReturningValue());
    }
 
    static StringBuffer methodReturningValue()
    {
        StringBuffer s = null;
        try
        {
            s = new StringBuffer("return value from try block");
            return s;
        }
        catch (Exception e)
        {
            s = s.append("return value from catch block");
            return s;
        }
        finally
        {
            s = s.append("return value from finally block");
        }
    }
}
