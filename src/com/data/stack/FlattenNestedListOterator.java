package com.data.stack;

public class FlattenNestedListOterator {
	
	public class NestedIterator implements Iterator<Integer> {
	    
	    Stack<NestedInteger> stk;

	    public NestedIterator(List<NestedInteger> nestedList) {
	        stk = new Stack<>();
	        prepareStack(nestedList);
	    }

	    @Override
	    public Integer next() {
	        if(!hasNext())
	            return null;
	        
	       return stk.pop().getInteger();
	    }

	    @Override
	    public boolean hasNext() {
	        while(!stk.isEmpty() && !stk.peek().isInteger()){
	            prepareStack(stk.pop().getList());
	        }
	       return !stk.isEmpty();
	    }
	    
	    private void prepareStack(List<NestedInteger> nestedList){
	        for(int i=nestedList.size()-1 ; i>=0;i--){
	            stk.push(nestedList.get(i));
	        }
	    }
	}

}
