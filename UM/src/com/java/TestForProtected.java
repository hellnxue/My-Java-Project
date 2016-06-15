package com.java;
/**
 * 测试继承修饰符protected的类
 *
 */
public class TestForProtected {
	protected int i=90;
    public TestForProtected(){
    	System.out.println("TestForProtected constructor");
    	
    }
    
//    void bite(){//该方法没有加修饰符，具有包权限（同一个包中的类都可以访问，不同包的类不可以访问）
//    	System.out.println("bite");
//    	
//    }
  protected  void bite(){//若修改为public修饰符也可以在继承该类的子类访问，但是这样会使得所有人都能访问这个方法，而protected可以防止这一点
    	System.out.println("bite");
    	
    }
  
  public final void modifyByFinal(){
	  System.out.println("这是一个用final修饰过的方法");
  }
  
  private void modifyByPrivate(){
	  System.out.println("这是一个用private修饰过的方法");
  }
  
  public void hehe(){
	  
  }
}
