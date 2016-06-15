package com.extendsInterface;
/**
 * 接口的实现类
 * @author Administrator
 *
 */
public  class HashiqiDog implements Dogs{

	@Override
	public void run() {
		System.out.println("哈士奇类狗狗跑的方式---跳着跑");
		
	}

	@Override
	public String teChang() {
		   
		   return "会旺旺的叫，并且会看门";
	   }

}
