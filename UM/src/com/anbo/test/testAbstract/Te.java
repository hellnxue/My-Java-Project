package com.anbo.test.testAbstract;
/**
 * 抽象类中不一定有抽象方法，但是，包含抽象方法的类一定要声明为抽象类
 * 抽象类不能被实例化，因为抽象类里的方法是抽象的，没有具体实现，实例化后没有意义
 * 用extends这个关键字来实现抽象类里的方法
 * @author wm
 *
 */
public abstract  class Te {
   private String aa;
   final int i=0;//允许有常量
   int x;//允许有变量
   static int y=0;
   public int j=100;
   
   public  abstract void hehes();
   
   public void test() {
	   
    }
   public void test1() {
	   System.out.println("hahhaha");
   }
   
   public abstract void tests();
   
   //声明为抽象方法的类修饰符是public或者protected
   //private abstract void testsss();
   
   //具体实现类
   public void hehe(){
	   
	   System.out.println("具体实现类");
   }
    protected abstract void xx();
    private void xy(){
    	System.out.println("父类的私有方法");
    }
    public final void xz(){
    	System.out.println("父类的final修饰过的方法");
    }
    /**
     * 模板方法
     */
    public void template(){
    	System.out.println("模板");
    	xx();
    	xy();
    }

}
