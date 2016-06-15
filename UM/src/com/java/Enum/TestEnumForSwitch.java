package com.java.Enum;
/**
 * enum在swtich中的应用
 * @author liuxueping
 *
 */
public class TestEnumForSwitch {

	EnumType say;
	public TestEnumForSwitch(EnumType say){
		this.say=say;
	}
	
	public void testSwitch(){
		
		switch(say){
		  case HI:
			      System.out.println("hi");break;
		  case HELLO:
		  case HEHE:
			  System.out.println("HEHE");break;
		  case HAHA:
		  case HOT:
	      default:System.out.println("may be too hot"); 
		
		}
	}
	public static void main(String[] args) {
		TestEnumForSwitch p1=new TestEnumForSwitch(EnumType.HAHA),
							p2=new TestEnumForSwitch(EnumType.HI), 
							p3=new TestEnumForSwitch(EnumType.HOT); 
		
		p1.testSwitch();
		p2.testSwitch();
		p3.testSwitch();
	}

}
