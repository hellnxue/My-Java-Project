package com.java.Exception;

import java.util.HashMap;

public class UsuallyException {
   public static void main(String[] args) {
	   HashMap<String, Object> hash = new HashMap<String, Object>();
	   System.out.println(hash.get("hello").toString());//��NullPointerException��ָ���쳣��because��hash.get("hello")�Ľ��Ϊnull
   }
}
