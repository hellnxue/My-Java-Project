package com.anbo.test.testAbstract;

public class ExtendsTe extends Te{

	public int j=200;
	private int ty=90;
	@Override
	public void hehes() {
		System.out.println("继承抽象类之后的hehe");
		
	}

	@Override
	public void tests() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void xx() {
		System.out.println("子类具体实现方法");
		
	}
	
	public void test(){
		//super.test();
		this.test1();
		super.test1();
		}
	public static void main(String[] args) {
		Te t=new ExtendsTe();
		t.test();
		t.xz();
		System.out.println(t.j);
		t.template();
		
	}

}
