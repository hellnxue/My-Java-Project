package com.java.String;

/**
 * class Demo在构造器中对一个名叫s的String引用变量进行初始化
 * 对于字符串常量，如果内容相同，Java认为它们代表同一个String对象。而用关键字new构造器调用对象，总是会创建一个新的对象，不管内容是否相同。
 *
 */
class Demo{
	private String s;
	Demo(){
		s="hello olaf";
	}
	public String rt(){
		return s;
	}
}
public class TestString {
	static int h(int h){
		return h+1;
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
		sb.append("abc"+"def"+47);
		System.out.println(sb);
		
		String a="hello world";
		System.out.println(a.indexOf("o"));//从前向后搜
		System.out.println(a.lastIndexOf("o"));//从后向前搜
        
        String aa="ok";
        String bb="ok";
        System.out.println(aa.equals(bb));
        System.out.println(aa==bb);
        String c=new String("cc");
        String d=new String("cc");
        System.out.println("cd===df=== "+c.equals(d));
        System.out.println("khkhk "+c==d);
        
        System.out.println("---------------");
        
        Demo s1=new Demo();
        Demo s2=new Demo();
        System.out.println(s1.rt().equals(s2.rt()));
        System.out.println(s1.rt()==(s2.rt()));
        
        String s3=new String("hello helln");
        String s4=new String("hello helln");
        System.out.println(s3.equals(s4));
        System.out.println(s3==s4);
        
        System.out.println("分割线-------------------------------------------------");
        /**
         javac编译可以对字符串常量直接相加的表达式进行优化，不必要等到运行期去进行加法运算处理，而是在编译时去掉其中的加号，直接将其编译成一个这些常量相连的结果。
         * 
         *
         */
        
        String ss1="a";
        String ss2=ss1+"b";
        String ss3="a"+"b";
        
        System.out.println("result1: "+(ss2==ss3));
        System.out.println("result2: "+(ss2.equals(ss3)));
        System.out.println("result3: "+(ss3=="ab"));
        
        /**
         *  String s6=new String("hello hh")创建了几个对象，此处s6只创建了一个对象
         * 两个或一个，”hello hh”对应一个对象，这个对象放在字符串常量缓冲区，常量”hello hh”不管出现多少遍，都是缓冲区中的那一个。
         * New String每写一遍，就创建一个新的对象，它依据那个常量”hello hh”对象的内容来创建出一个新String对象。如果以前就用过’hello hh’，
         * 这句代表就不会创建”xyz”自己了，直接从缓冲区拿。
         */
        String s5="hello hh";
        String s6=new String("hello hh");
        System.out.println(s5.equals(s6));
        System.out.println(s5==s6);
        
        /**
         * String与StringBuffer的区别
                        * 　　JAVA平台提供了两个类：String和StringBuffer，它们可以储存和操作字符串，即包含多个字符的字符数据。这个String类提供了数值不可改变的字符串。
         * 而这个StringBuffer类提供的字符串进行修改。当你知道字符数据要改变的时候你就可以使用StringBuffer。典型地，你可以使用StringBuffers来动态构造字符数据。
         * 另外，String实现了equals方法，new String(“abc”).equals(new String(“abc”)的结果为true,而StringBuffer没有实现equals方法，
         * 所以，new StringBuffer(“abc”).equals(new StringBuffer(“abc”)的结果为false。
         */
        long start=System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();  
        for(int i=0;i<10000;i++)
        {
        	sbf.append(i);
        }
        long end=System.currentTimeMillis();
        System.out.println("StringBuffer: "+(end-start)+"ms");
        //上面的代码效率很高，因为只创建了一个StringBuffer对象，而下面的代码效率很低，因为创建了10001个对象。
        long start1=System.currentTimeMillis();
        String str = new String();  
        for(int i=0;i<10000;i++)
        {
        	str = str + i;
        }
        long end1=System.currentTimeMillis();
        System.out.println("String: "+(end1-start1)+"ms");
        
	}

}
