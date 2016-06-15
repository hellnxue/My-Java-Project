package com.java.Polymorphic;
/**
 * 域（即类的字段属性）和静态方法没有多态的特性
 * 
 * 域没有多态性，即类的字段field属性不具有多态特性
 * 静态方法没有多态性
 * 
 *
 */
class Super{
	public int field=0;
	public  String t="基类成员";
	public int i=11;
	public int getField(){
		return field;
	}
	/**
	 * static function
	 */
	public static void ff(){
		System.out.println("This a Super.ff()");
	}
	private void xy(){
    	System.out.println("父类的私有方法");
    }
	public final void ModifierByFinal(){
		System.out.println("父类的final修饰的方法");
	}
	
}

class Sup extends Super{
	public int field=1;
	public  String dt="导出类成员";
	public int getField(){
		return field;
	}
	public int getSupField(){
		return super.field;//super.field是父类的属性
	}
	/**
	 * static function
	 */
	public static void ff(){
		System.out.println("This a Sup.ff()");
	}
	
	public void olaf(){
		System.out.println("hello,I'm olaf,and i love warm hugs.i come from Sup");
	}
	
	private void xy(){
    	System.out.println("父类的私有方法");
    }
	
	//final修饰的方法不能被重写
//	public final void ModifierByFinal(){
//		System.out.println("父类的final修饰的方法");
//	}
}
public class FiledAccess {
	
	
	public static void main(String[] args) {

		Super sup=new Sup();
		System.out.println("sup.field="+sup.field+" sup.getField="+sup.getField());
		System.out.println(sup.i);
		
		String s1=sup.t;
		//String s2=sup.dt; No
		
		sup.ff();       //此ff()方法是父类（基类）Super的
		
		Sup sub=new Sup();
		System.out.println("sub.field="+sub.field+" sub.getField="+sub.getField()+" sub.getSupField()="+sub.getSupField());
		sub.ff();       //此ff()方法才是Sup的
		sub.olaf();
		String s=sub.dt;
		hh();
		
	}
	
	//private修饰过的方法只能在自身类中使用
	private static void hh(){
		System.out.println("This is a private function");
	}
}
