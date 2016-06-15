package com.java.Final;
/**
 * 空白final
 *必须在域的定义处或者每个构造器中用表达式对final进行赋值
 */
class Peopet{
	private int i;
	Peopet(int ii){
		this.i=ii;
	}
	
}
public class BlankFinal {
	private final int i=0;//在定义处赋值
	private final int j;
	private final  Peopet p;
	public BlankFinal(){
		j=1;              //在构造器中赋值
		p=new Peopet(1);  //在构造器中赋值
	}
	public BlankFinal(int x){
		j=x;
		p=new Peopet(x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BlankFinal();
		new BlankFinal(47);
	}

}
