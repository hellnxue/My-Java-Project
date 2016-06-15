package com.java.Final;
/**
 * final修饰的变量是定义后的值固定，变量的值固定不变
 * Java允许在参数列表中以声明的方式将参数指明为final，在方法中，参数所引用的对象不能更改
 *
 */
class Gizmo{
	
	public void spin(){}
}
public class FinalArguments {
  void with(final Gizmo g){
	 // g=new Gizmo();//对象的引用不能更改
  }
  void without(Gizmo g){
	  g=new Gizmo();
	  g.spin();
  }
  /**
   * final修饰的变量时不能改变它的值，有点类似定义常量(注意：是类似，不是等同)。i++是变量i自增，即

     i=i+1，也就是在改变i本身的值，此时用final修饰了 所以这样是错误的；return i+1的含义是 int n; n=i+1; return 

     n; 这里并没改变i本身的值，所以这样是正确的。
   * @param i
   * @return
   */
//不能更改i自身的值
//  int f(final int i){
//	  return i++; ?????????????????????????????????
//  }
  int g(final int i){
	 return i+1;  //i+1后i的值还是原来的
  }
  public static void main(String[] args) {
	  FinalArguments f=new FinalArguments();
	  f.with(null);
	  f.without(null);
	  int i=1;
	 System.out.println("i的值没变="+i+" g()方法的值加1="+f.g(i));
}
}
