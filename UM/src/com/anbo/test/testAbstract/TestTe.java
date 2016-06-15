package com.anbo.test.testAbstract;

public class TestTe {
  public static void main(String args[]){
	  //Te t=new Te();//抽象方法不能被实例化,因为有些方法没有具体实现，实例化抽象类便没大有意义
	  Te t=new ExtendsTe();
	  t.hehe();
	  t.hehes();
  }
}
