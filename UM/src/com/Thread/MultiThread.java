package com.Thread;
/**
 * 多线程
 * @author Administrator
 *
 */
public class MultiThread {
	 public static void  main(String args[]){
	       ThreadDemo1 t1,t2,t3;
	       t1 =  new ThreadDemo1("Thread1",(int)(Math.random()*2000));
	       t2 =  new ThreadDemo1("Thread2",(int)(Math.random()*2000));
	       t3 =  new ThreadDemo1("Thread3",(int)(Math.random()*2000)); 
	       t1.start();//启动线程
	       t2.start();
	       t3.start();
	  }
}
