package com.java.String;
/**
 * 　　javac编译可以对字符串常量直接相加的表达式进行优化，不必要等到运行期去进行加法运算处理，而是在编译时去掉其中的加号，直接将其编译成一个这些常量相连的结果。
 * 
 *
 */
public class TestString2 {
	static String s1;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String ss1="a";
        String ss2=ss1+"b";
        String ss3="a"+"b";
        
        System.out.println("result1: "+(ss2==ss3));
        System.out.println("result2: "+(ss2.equals(ss3)));
        System.out.println("result3: "+(ss3=="ab"));
        
        final String s="";
        int i=s.length();
        System.out.println(s.length());
        System.out.println(s1);
        
        System.out.println(TestString3.x);
        System.out.println(Th.temp);
        
        /**
         * 去空格
         */
        String s1=" hellow world ";
		String s2=" hello";
		String s3="hello ";
		System.out.println(s1.length()+"   "+s1.trim().length());//去左右空格
		System.out.println(s1.replaceAll("\\s*", ""));//去所有空格
		System.out.println(s1.replaceAll("^\\s*", ""));//去左空格
		System.out.println(s1.replaceAll("\\s*$", ""));//去右空格
	}

}
class TestString3{
	 static int x=10;
}

interface A{
	int temp=101;
	Th t=new Th();
	public void play();
}
class Th implements A{
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println(temp);
	}
	
}
