package com.anbo.myInterceptor;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.org.mozilla.javascript.internal.ContextAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 自定义拦截器
 * @author Administrator
 *
 */
public class MyInterceptor1 implements Interceptor{

	@Override
	public void destroy() {
		System.out.println("拦截器结束拦截。。。。。。。。");
		
	}

	@Override
	public void init() {
		System.out.println("拦截器开始拦截了===================");
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// Action前置拦截
		System.out.println("在Action执行前的拦截信息");
		//在被全局异常拦截之前，加入一个错误标示
        HttpServletRequest request=ServletActionContext.getRequest();
        request.setAttribute("result", "ahahahah");//在正常的访问中都会走这一步，如果访问地址有问题，不走此拦截器，而是走global全局拦截，此设置用来判断项目访问地址的
		System.out.println("~~~~~~~~~~~~~~~~~~~~~  "+request.getAttribute("result"));
		
		String result = invocation.invoke();	//获得对应逻辑视图的字符串
		// Action后置拦截
		System.out.println("在Action执行后的拦截信息"+result);
		
		
		return "errorsss";
	}

}
