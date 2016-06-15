package com.anbo.test.testAbstract;
/**
 * 接口是一种特殊的抽象类，这种抽象类只包含常量值和方法的定义，没有变量和方法的具体实现
一个类可以实现多个接口，从而扩展了JAVA中只允许单继承的特点
所有定义在接口中的常量都默认为public、 static和final。接口中没有变量
所有定义在接口中的方法默认为 public 和 abstract

 * @author Administrator
 *
 */
public interface TestInterface {
   public String a="aa";//必须是常量
   final int x=0;
   static int y=0;
   public void said();
   public abstract void hehe();
   //private void song();//接口中的方法都是抽象方法、都是public的

}
