package com.Thread;
/**
 *  Java语言里，线程表现为线程类。Thread线程类封装了所有需要的线程操作控制。在设计程序时，必须很清晰地区分开线程对象和运行线程

，可以将线程对象看作是运行线程的控制面板。在线程对象里有很多方法来控制一个线程是否运行，睡眠，挂起或停止。线程类是控制线程行为的唯

一的手段。一旦一个Java程序启动后，就已经有一个线程在运行。可通过调用Thread.currentThread方法来查看当前运行的是哪一个线程。 
 * @author Administrator
 * 此例为单线程
 *
 */
public class TestThread {
	public static void main(String args[]){
		  Thread t = Thread.currentThread();//返回对当前线程对象的引用
		  t.setName("单线程"); //对线程取名为"单线程"
		  t.setPriority(8);
		  //设置线程优先级为8，最高为10，最低为1，默认为5
		  System.out.println("The running thread: " + t);// 显示线程信息
		  try{
		    for(int i=0;i<3;i++){
		      System.out.println("Sleep time " + i);
		      Thread.sleep(1000);   // 睡眠100毫秒
		      Thread.interrupted();
		      System.out.println(Thread.interrupted());
		    }
		  }catch(InterruptedException e){// 捕获异常
		   System.out.println("thread has wrong");
		  }
		 }
}
