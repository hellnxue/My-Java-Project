package com.Thread;
/**
 * 应用继承类Thread的方法实现多线程的程序。本程序创建了三个单独的线程，它们分别打印自己的“Hello World!”。
 * @author Administrator
 *
 */
public class ThreadDemo1 extends Thread{
	 private String whoami;
     private int delay;
     public ThreadDemo1(String s,int d){
         whoami=s;
         delay=d;
     }
    public void run(){
	try{
	     sleep(delay); 
	   }catch(InterruptedException e){ }
	    System.out.println("Hello World!" + whoami+ " " +delay);
	 }
}
