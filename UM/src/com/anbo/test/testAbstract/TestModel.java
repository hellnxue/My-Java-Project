package com.anbo.test.testAbstract;

 abstract class TestModel1 {
  public final void service(){
	  System.out.println("ҵ��һstart---------------");
	  doService();
	  System.out.println("ҵ��һend---------------");
  }
  
  protected abstract void doService();
}
 
 class TestModel2 extends TestModel1{

	@Override
	protected void doService() {
		System.out.println("����ʵ�ֵľ���ҵ���߼���������������");
		
	}
 }
 public class TestModel{

		public static void main(String args[]){
			TestModel1 t=new TestModel2();
			t.service();
		}
		  
	 }