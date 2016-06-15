package com.java.Exception;
/**
 * 异常没有被当前异常处理程序捕获时，异常处理机制会在跳到更高一层的异常处理程序之前，执行finally子句
 * 
 *
 */
class OneException extends Exception{}
public class AlwaysFinally {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Entring first try");
		try{
			System.out.println("Entring second try");
			try{
				throw new OneException();
				
			}finally{
				System.out.println("second try finally");
			}
		}catch(OneException z){
			System.out.println("Caught first try");
		}finally{
			System.out.println("finally first try");
		}
	}

}
