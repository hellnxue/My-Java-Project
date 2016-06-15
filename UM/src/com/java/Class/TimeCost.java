package com.java.Class;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class TimeCost implements InvocationHandler{
	
	    private Object proxyer;
	
	    public TimeCost(Object o) {
	
	        proxyer = o;
	
	    }
	
	    @Override
	
	    public Object invoke(Object proxy, Method method, Object[] args)
	
	            throws Throwable {
	
	
	        long startTime = System.currentTimeMillis();
	
	        Object returnObj = method.invoke(proxyer, args);
	
	        long endTime = System.currentTimeMillis();
	
	        System.out.println(endTime - startTime + "ms");
	
	        return returnObj;
	
	    }
	    
	}

