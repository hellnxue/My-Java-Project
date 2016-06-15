package com.java.Exception;
/**
 * 不管try中是否捕获异常，finally中的代码都会输出
 * 
 *
 */
class ThreeException extends Exception{}
public class FinallyWork {

	static int i=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		while(true){
			try{
				if(i++==0){
					throw new ThreeException();
				}
				System.out.println("No exception");
			}catch(ThreeException t){
				System.out.println("Three exception");
			}finally{
				System.out.println("in finally clause");
				if(i==2) break;
			}
		}

	}

}
