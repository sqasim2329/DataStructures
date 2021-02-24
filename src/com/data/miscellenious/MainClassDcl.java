package com.data.miscellenious;

 class MainClassDcl {
	
	
	    private static volatile MainClassDcl instance;
	    private MainClassDcl() {
	    	
	    }
	    public static MainClassDcl getInstance() {
	        if (instance == null) {
	            synchronized (MainClassDcl .class) {
	                if (instance == null) {
	                    instance = new MainClassDcl();
	                }
	            }
	        }
	        return instance;
	    }

	    // private constructor and other methods...
	}





