package com.java.Exception;

import java.util.HashMap;

public class UsuallyException {
   public static void main(String[] args) {
	   HashMap<String, Object> hash = new HashMap<String, Object>();
	   System.out.println(hash.get("hello").toString());//报NullPointerException空指针异常，because：hash.get("hello")的结果为null
   }
}
