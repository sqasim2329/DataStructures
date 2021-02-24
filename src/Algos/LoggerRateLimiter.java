package Algos;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	
	class Logger {

	    /** Initialize your data structure here. */
	    Map<String,Integer> dict;
	    public Logger() {
	        dict = new HashMap<>();
	    }
	    
	    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        
	        if(dict.containsKey(message)){
	            if(timestamp < dict.get(message)){
	                return false;
	            }
	        }
	        dict.put(message,timestamp+10);
	        return true;
	    }
	}

}
