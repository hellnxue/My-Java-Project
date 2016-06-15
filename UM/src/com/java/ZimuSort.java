package com.java;

import java.util.*;


public class ZimuSort {
	public static void main(String[] args) {  
		ZimuSort obj1 = new ZimuSort();  
        System.out.println("======================");  
        ArrayList list=new ArrayList();  
        list.add("adisen");  
        list.add("bulsi");  
        list.add("Kobe");  
        list.add("����");  
        list.add("�Ÿ�");  
        list.add("Ԫ��");
        list.add("���»�");
        list.add("�����");
        Map map=obj1.sort(list);  
        System.out.println(map);  
        System.out.println("-------���������-----------");  
        System.out.println(map.get("A"));  
        System.out.println(map.get("B"));  
        System.out.println(map.get("C"));  
        System.out.println(map.get("D"));  
        System.out.println(map.get("Y"));
        System.out.println(map.get("L"));  
        
      }   
        public ZimuSort() {  
       
        }  
         //��ĸZʹ����������ǩ�������У�����ֵ  
         //i, u, v��������ĸ, ����ǰ�����ĸ  
        private  char[] chartable =  
           {  
             '��', '��', '��', '��', '��', '��', '��', '��', '��',  
             '��', '��', '��', '��', '��', 'Ŷ', 'ž', '��', 'Ȼ',  
             '��', '��', '��', '��', '��', '��', 'ѹ', '��', '��'  
            };  
        private  char[] alphatableb =  
          {  
             'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',  
             'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'  
           };  
        private  char[] alphatables =  
          {  
             'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',  
             'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'  
           };  
        private  int[] table = new int[27];  //��ʼ��  
          {  
                 for (int i = 0; i < 27; ++i) {  
                     table[i] =gbValue(chartable[i]);  
                 }  
           }  
        //������,�����ַ�,�õ�������ĸ,  
        //Ӣ����ĸ���ض�Ӧ�Ĵ�Сд��ĸ  
        //�����Ǽ��庺�ַ��� '0'  ������  
         private  char Char2Alpha(char ch,String type) {  
              if (ch >= 'a' && ch <= 'z')  
                  return (char) (ch - 'a' + 'A');//Ϊ�˰���ĸ�����ȷ��ش�д��ĸ  
               // return ch;  
              if (ch >= 'A' && ch <= 'Z')  
                  return ch;  
  
                 int gb = gbValue(ch);  
                 if (gb < table[0])  
                  return '0';  
        
              int i;  
                 for (i = 0; i < 26; ++i) {  
                  if (match(i, gb))  
                         break;  
              }  
           
                 if (i >= 26){  
                  return '0';}  
                 else{  
                     if("b".equals(type)){//��д  
                         return alphatableb[i];  
                     }else{//Сд  
                         return alphatables[i];  
                     }  
                 }  
          }  
     //����һ���������ֵ��ַ�������һ������ƴ������ĸ���ַ���  
     private  String String2Alpha(String SourceStr,String type) {  
         String Result = "";  
         int StrLength = SourceStr.length();  
         int i;  
      try {  
          for (i = 0; i < StrLength; i++) {  
                 Result += Char2Alpha(SourceStr.charAt(i),type);  
             }  
         } catch (Exception e) {  
          Result = "";  
         }  
      return Result;  
    }  
   //����һ���������ֵ��ַ������ص�һ������ƴ������ĸ���ַ���  
     private  String String2AlphaFirst(String SourceStr,String type) {  
           String Result = "";  
         try {  
           Result += Char2Alpha(SourceStr.charAt(0),type);  
         } catch (Exception e) {  
           Result = "";  
         }  
      return Result;  
    }  
     private  boolean match(int i, int gb) {  
            if (gb < table[i])  
               return false;  
             int j = i + 1;  
       
             //��ĸZʹ����������ǩ  
             while (j < 26 && (table[j] == table[i]))  
                 ++j;  
             if (j == 26)  
                 return gb <= table[j];  
            else  
                 return gb < table[j];  
          }  
               
     //ȡ�����ֵı���  
     private  int gbValue(char ch) {  
         String str = new String();  
         str += ch;  
         try {  
             byte[] bytes = str.getBytes("GBK");  
                 if (bytes.length < 2)  
                     return 0;  
                 return (bytes[0] << 8 & 0xff00) + (bytes[1] &  
                         0xff);  
             } catch (Exception e) {  
               return 0;  
             }  
         }  
     public  Map sort(List list){  
         Map map=new HashMap();  
         ArrayList arraylist=new ArrayList();  
         String[] alphatableb =  
             {  
                "A", "B", "C", "D", "E", "F", "G", "H", "I",  
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"  
               };  
             for(String a:alphatableb){  
                 for(int i=0;i<list.size();i++){//Ϊ�����򶼷��ش�д��ĸ  
                     if(a.equals(String2AlphaFirst(list.get(i).toString(),"b"))){  
                         arraylist.add(list.get(i).toString());  
                     }  
                 }  
                 map.put(a,arraylist);  
                 arraylist=new ArrayList();  
         }  
         return map;  
     }  
}
