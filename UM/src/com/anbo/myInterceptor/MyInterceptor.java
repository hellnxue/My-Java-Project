package com.anbo.myInterceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 自定义拦截器，继承AbstractInterceptorl类
 * @author Administrator
 *
 */
public class MyInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		// Action前置拦截
		System.out.println("在Action执行前的拦截信息");
		String result = invocation.invoke();  //获得对应逻辑视图的字符串
		// Action后置拦截
		System.out.println("在Action执行后的拦截信息");
		return result;

	}

}
