package com.anbo.test;

public class ShuzuTest2 {
   public static void main(String[] args) {
	   System.out.println("abc".substring(1, "abc".length()-1));
		String A="0506070811";
		String B="0104060910";
		
      System.out.println(B.length()/2);
      
      String sbs[]=new String[B.length()/2];
      int j=0;
      int num=0;
      
      for(int i=0;i<5;i++){
   	   sbs[i]=B.substring(j, j+2);
   	   System.out.println("hehe1 ="+sbs[i]);
   	   int k=0;
   	   for(int x=0;x<5;x++){
   		   System.out.println("k= "+k);
   		   System.out.println("测试 "+A.substring(k,k+2));
   		   if(sbs[i].equals(A.substring(k,k+2))){
   			   num++;
   		   }
   		   k=k+2;
   	   }
   	   j=j+2;
      }
     System.out.println("两者相同数===== "+num);
}
}
