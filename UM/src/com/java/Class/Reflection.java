package com.java.Class;

import java.lang.reflect.Proxy;

interface doSomething{
	
	    public void doSomething();
	
	}
	
class TestClass1 implements doSomething{
	
	    public void doSomething(){
	
	        int count = 0 ;
	
	        for(int i = 0; i<1000; i++){
	
	            count += i;
	            System.out.println("hehe");
		        System.out.println("hehe");
	        }
	        
	
	    }
	
	}
	
	 
	
	public class Reflection {
	
	    public static void main(String[] args) {
	
	        TestClass1 tc = new TestClass1();
	
	        doSomething someThing = (doSomething)Proxy.newProxyInstance(tc.getClass().getClassLoader(),
	
	                new Class[]{doSomething.class},
	
	                new TimeCost(tc));
	
	        someThing.doSomething();
	
	    }
	
	}