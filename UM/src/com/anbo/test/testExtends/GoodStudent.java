package com.anbo.test.testExtends;


public class GoodStudent extends Student{
    
	private String name=super.getName()+"2";
	/*public GoodStudent(String name, int sex) {
		super(name, sex);

	}*/
	
	//私有方法
	private void testPrivate(){
		  System.out.println("GoodStudent private function");
	  }
	//方法重写
    public void sayHello(){
    	//super.sayHello();//调用父类的方法
    	System.out.println("hello GoodStudent");
    }
    Student stu=new Student();
    //父类中被final修饰的方法不允许被子类继承
    /*public void sayGood(){
    	
    	
    }*/
    
   public static void main(String[] args) {
	
	/**
	 * 子类调用父类的方法，若父类方法里有子类重写了的方法，则运行的是被子类重写的方法
	 */
	Student stu1=new Student();
	stu1.call();
	GoodStudent stu2=new GoodStudent();
	System.out.println(stu2.getName());//此处得到的是父类的私有属性值
	stu2.call();
	Student stu3=stu2;
	stu3.call();
	
	
}
}
