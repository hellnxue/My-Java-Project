package com.java.Polymorphic.test;

public class MsgBase {
	public static void main(String[] args) {
		BaseMsg tm=new TextMsg();
		BaseMsg im=new ImgMsg();
		System.out.println(tm.toXml());
		System.out.println(im.toXml());
	}

}
