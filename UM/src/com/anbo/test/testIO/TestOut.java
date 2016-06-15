package com.anbo.test.testIO;

import java.io.*;
//写文件-输出流
public class TestOut {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f=new File("D://hi.txt");
		try {
			String s="hello,! world";
			FileOutputStream fs=new FileOutputStream(f);
			
			byte[] b=s.getBytes();
			
			fs.write(b);
			fs.close();
			
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		readFile();

	}
	
	public static void readFile(){
		File f=new File("d://hi.txt");
		try {
			FileInputStream fs=new FileInputStream(f);
			byte[] b=new byte[1024];
			int length=fs.read(b);
			String s=new String(b, 0, length);
			System.out.println(s);
			fs.close();
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}

}
