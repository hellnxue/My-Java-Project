package com.anbo.test.testIO;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;

public class TestDataInputStream {
	 public static void main(String args[]){
   	  File file=new File("d:\\tests.txt");
   	  try {
			FileInputStream filein=new FileInputStream(file);
			DataInputStream datain=new DataInputStream(filein);
			String name="";
			try {
				datain.readInt();
				int i = datain.readInt();//读取整型数据
	            name = datain.readUTF();//读取字符串数据  
	            double money = datain.readDouble();//读取双精度数据
	            System.out.println("帐户信息为：" + i);
	            datain.close();//关闭流

				///filein.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
     }
}
