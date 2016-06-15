package com.java;

public class Father {
	public int money;
	private String name;
	protected String xueli;
	final String think="老辈思想";
	
	public Father(){
		money=1000;
		name="爸爸的名字";
		xueli="教授";
		System.out.println("构造方法+++++父类的钱 "+money);
	}
	
	public Father(int money,String name){
		this.money=money;
		this.name=name;
	}
    public void All(){
    	
    	System.out.println("父辈all方法"+money+xueli);
    }
    public final void thinks(){
    	
    	System.out.println("老一代的思想");
    }
    public void hehe(){
    	
    	System.out.println("dhdjd");
    }
}
