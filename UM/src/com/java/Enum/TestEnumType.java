package com.java.Enum;
/**
 * 测试枚举类型
 * 方法：
 *     ordinal():  表示某个枚举常量的声明顺序
 *     static values():用来按照枚举常量声明顺序，产生由这些常量值构成的数组
 *
 */
public class TestEnumType {

	/**
	 */
	public static void main(String[] args) {
		EnumType et=EnumType.HELLO;//枚举类型实例
		System.out.println("et="+et);
		
		for(EnumType ee:EnumType.values()){
			System.out.println(ee+" "+ee.ordinal());
			
		}
	}
    
}

