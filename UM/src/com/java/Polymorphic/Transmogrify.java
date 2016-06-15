package com.java.Polymorphic;
/**
 * 用继承进行设计
 * 通用准则：用继承表达行为间的差异，并用字段表达状态上的变化
 *
 */
class Actor{
	public void act(){}
}
class HappyActor extends Actor{
	public void act(){
		System.out.println("HappyActor");
	}
}
class SadActor  extends Actor{
	public void act(){
		System.out.println("SadActor");
	}
}
class Stage{
	private Actor a=new HappyActor();
	
	public void change(){
		a=new SadActor();
	}
	public void performPlay(){
		a.act();
	}
}
public class Transmogrify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stage s=new Stage();
		s.performPlay();
		s.change();
		s.performPlay();

	}

}
