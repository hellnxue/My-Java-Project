package com.anbo.test.testAbstract;

 abstract class TestModel1 {
  public final void service(){
	  System.out.println("业务一start---------------");
	  doService();
	  System.out.println("业务一end---------------");
  }
  
  protected abstract void doService();
}
 
 class TestModel2 extends TestModel1{

	@Override
	protected void doService() {
		System.out.println("子类实现的具体业务逻辑。。。。。。。");
		
	}
 }
 public class TestModel{

		public static void main(String args[]){
			TestModel1 t=new TestModel2();
			t.service();
		}
		  
	 }