package com.anbo.test.testIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读文件
 * @author wm
 *
 */
public class TestFileInputStream {
    public static void main(String args[]){
    	File file=new File("D:\\hehe.txt");
    	try {
			FileInputStream fileIn=new FileInputStream(file);
			
			try {
				//创建字节数组，用于存储从文件中读取字节
				byte[] by=new byte[1024];
				String instr="";//接收从文件中读取的字符串
				int length = fileIn.read(by);

				 instr = new String(by,0,length);//将字节转化成字符串
				 System.out.println(instr);
		            fileIn.close();  //关闭输入流

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
    }
}
