package com.anbo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QushuTest {
	
//	public static void main(String[] args) {  
//		String str = "love23next234csdn3423javaeye";  
//		str=str.trim();  
//		String str2="";  
//		if(str != null && !"".equals(str)){  
//		for(int i=0;i<str.length();i++){  
//		if(str.charAt(i)>=48 && str.charAt(i)<=57){  
//		str2+=str.charAt(i);  
//		}  
//		}  
//		  
//		}  
//		System.out.println(str2);  
//		}   
	
	/*public static void main(String[] args) {  
	           String a="love23next234csdn3423javaeye";  
		       List<String> ss = new ArrayList<String>(); 
		       String b =a.replaceAll("[^0-9]", ",");
		       //²»Í¨ÓÃ
		       //String c[] =a.replaceAll("[^0-9]", ",").split(",");
//		       for(String sss:a.replaceAll("[^0-9]", ",").split(",")){  
//		         if (sss.length()>0)  
//		               ss.add(sss);  
//		      }  
		       
		       System.out.print("-----b"+b);
//		       System.out.print("-----c"+c);
//		       for(String s:c){
//		    	   System.out.println(s);
//		       }
		  
		 
		}  */
	
	public static void main(String[] args) {  
		String a="love23next234csdn3423javaeye";  
		String regEx="[^0-9]";     
		Pattern p = Pattern.compile(regEx);     
		boolean m1 = regEx.matches(a);
		Matcher m=p.matcher(a);
		System.out.println(m1);
		System.out.println( m.replaceAll("").trim());  
		}   


}  


