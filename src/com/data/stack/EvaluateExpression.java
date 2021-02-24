package com.data.stack;

import java.util.Stack;

public class EvaluateExpression {
	
	    
	    static int prec(char c){
	        
	        switch(c){
	            case '+':
	            case '-': 
	                return 1;
	            case '*':
	            case '/':
	                return 2;
	        }
	        return -1;
	    }
	    //can evaluate String infix expression
	    public int evalRPN(String[] A) {
	        
	        Stack<Integer> valueStack = new Stack<>();
	        Stack<Character> operatorStack = new Stack<>();
	        for(String cstring:A){
	            for(char c:cstring.toCharArray()){
	                if(Character.isDigit(c))
	                    valueStack.push(c-'0');
	                else{
	                    if(!operatorStack.isEmpty() && prec(c)<=prec(operatorStack.peek())){
	                        int second = valueStack.pop();
	                        int first = valueStack.pop();
	                        char op = operatorStack.pop();
	                        int value = applyOperation(first,second,op);
	                        valueStack.push(value);
	                    }
	                    operatorStack.push(c);
	                }
	            }
	        }
	        
	        while(!operatorStack.isEmpty()){
	                        int second = valueStack.pop();
	                        int first = valueStack.pop();
	                        char op = operatorStack.pop();
	                        int value = applyOperation(first,second,op);
	                        valueStack.push(value);
	        }
	        
	        return valueStack.pop();
	    }
	    
	    public int evaluatePostFixExpression(String[] a) {
		    Stack<Integer> stack = new Stack<>();
		    
		    for(String opr : a) {
		        if(opr.equals("+") || opr.equals("-") || opr.equals("*") || opr.equals("/")) {
		            int num1 = stack.pop();
		            int num2 = stack.pop();
		            switch(opr) {
		                case "+" : int sum = num1 + num2;
		                           stack.push(sum);
		                           break;
		                case "-" : int diff = num2 - num1;
		                           stack.push(diff);
		                           break;
		                case "*" : int mult = num1 * num2;
		                           stack.push(mult);
		                           break;
		                case "/" : int div = num2 / num1;
		                           stack.push(div);
		            }
		        }
		        else {
		            stack.push(Integer.parseInt(opr));
		        }
		    }
		    
		    return stack.pop();
		}
	    
	    private int applyOperation(int first, int second,char op){
	        switch(op){
	            case '+':
	                return first+second;
	            case '-':
	                return first-second;
	            case '*':
	                return first*second;
	            case '/':
	                return first/second;
	        }
	        return -1;
	    } 
	    
	    public static void main(String args[]) {
	    	EvaluateExpression e = new EvaluateExpression();
	    	String[] A= {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
	    	System.out.println(e.evaluatePostFixExpression(A));
	    	String[] B= {"10","2","*","6"};
	    	System.out.println(e.evalRPN(B));//need to add brackets
	    }
	}
