package com.java.Polymorphic.test;

public class ImgMsg extends BaseMsg{

	private int sex;

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public String toXml(){
		StringBuilder stb=new StringBuilder();
		stb.append("hello").append("ImgMsg");
		return stb.toString();
		
	}
}
