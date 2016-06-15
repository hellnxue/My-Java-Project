package com.java.model;
/**
 *  设计模式之 代理模式
 */
 
interface NetWork{
	 public abstract void browser();
}
/**
 * Real 类代表用户上网的实际动作，比如查看网页
 * */
class Real implements NetWork{
    public void browser(){
        System.out.println("上网浏览信息");
    }
}
/**
 * 此处使用代理类来完成中间代理的工作，屏蔽实现代理的细节
 * */
class proxy implements NetWork{
    private NetWork netWork;
 
    proxy(NetWork netWork){
        this.netWork = netWork;
    }
 
    public void browser(){
        checkName();
        this.netWork.browser();
    }
 
    private void checkName(){
        // Other codes
    	System.out.println("上网之前先喝杯水");
    }
}
public class TestProxModel {

	public static void main(String[] args) {
		new proxy(new Real()).browser();

	}

}
