package com.java;

public class Sun extends Father{
   public Sun(){
	   
	   money=200;
	  
	   System.out.println("构造方法+++++子类的钱"+money+xueli);
	   //super();//如果调用父类的构造方法，父类的构造方法必须在最前面
   }
   public Sun(int money,String name){
	  
	   //super(money,name);
	   this();//调用当前具有相同形参的构造函数即Sun()
   }
   
   //子类重写父类的方法
   public void All(){
	   super.All();//使用父类的方法
	   System.out.println("儿子的all方法");
	   money=100;
	   //super.name;父类的属性经过private的修饰后，变为私有的，不能被继承
	   xueli="大学";
	   System.out.println(super.money+super.xueli);
	   System.out.println(money+xueli);
	   super.All();//使用父类的方法
	   //super.think="新辈思想";//被final修饰过的属性不能被子类使用
   }
   //public final void thinks(){}//被final修饰的方法不能被重写
}
