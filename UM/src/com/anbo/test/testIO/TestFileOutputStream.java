package com.anbo.test.testIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 写文件
 * @author wm
 *
 */
public class TestFileOutputStream {
	
	public static void main(String args[]){
		File file=new File("d:\\hehe.txt");//创建文件对象
		
		
		//通过文件对象创建文件输出流
		try {
			FileOutputStream fileout=new FileOutputStream(file);
			String outstr = "我叫小猪，Nice to meet you";
            byte by[]=outstr.getBytes();//将字符串转换成字节
			try {
				fileout.write(by);//将字节写入文件
				fileout.close();//关闭输出流
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

}
