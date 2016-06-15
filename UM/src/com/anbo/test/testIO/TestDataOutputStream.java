package com.anbo.test.testIO;


import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.FileNotFoundException;

public class TestDataOutputStream {
      public static void main(String args[]){
    	  File file=new File("d:\\tests.txt");
    	  try {
			FileOutputStream filein=new FileOutputStream(file);
			DataOutputStream datain=new DataOutputStream(filein);
			int i=123;
			String name="abc";
			double money=5000.0;
			
				datain.writeInt(i);
				datain.writeUTF(name);
				datain.writeDouble(money);
				datain.close();
				///filein.close();
			
			
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
      }
}
