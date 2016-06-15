package com.anbo.util;

import java.util.*;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
/**
 
/**
 * �Ѻ��ִ����ƴ����Ĵ���
 * @author zhiyanguser
 *
 */
public class ZimuSort{

	//private ArrayList<HashMap> arrh = new ArrayList<HashMap>();

	public ZimuSort() {

	}

	// ��ĸZʹ����������ǩ�������У�����ֵ
	// i, u, v��������ĸ, ����ǰ�����ĸ
	private char[] chartable = { '��', '��', '��', '��', '��', '��', '��', '��', '��',
			'��', '��', '��', '��', '��', 'Ŷ', 'ž', '��', 'Ȼ', '��', '��', '��', '��',
			'��', '��', 'ѹ', '��', '��' };
	private char[] alphatableb = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z' };
	private char[] alphatables = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z' };
	private int[] table = new int[27]; // ��ʼ��
	{
		for (int i = 0; i < 27; ++i) {
			table[i] = gbValue(chartable[i]);
		}
	}

	// ������,�����ַ�,�õ�������ĸ,
	// Ӣ����ĸ���ض�Ӧ�Ĵ�Сд��ĸ
	// �����Ǽ��庺�ַ��� '0' ������
	private char Char2Alpha(char ch, String type) {
		if (ch >= 'a' && ch <= 'z')
			return (char) (ch - 'a' + 'A');// Ϊ�˰���ĸ�����ȷ��ش�д��ĸ
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

		if (i >= 26) {
			return '0';
		} else {
			if ("b".equals(type)) {// ��д
				return alphatableb[i];
			} else {// Сд
				return alphatables[i];
			}
		}
	}

	// ����һ���������ֵ��ַ�������һ������ƴ������ĸ���ַ���
	private String String2Alpha(String SourceStr, String type) {
		String Result = "";
		int StrLength = SourceStr.length();
		int i;
		try {
			for (i = 0; i < StrLength; i++) {
				Result += Char2Alpha(SourceStr.charAt(i), type);
			}
		} catch (Exception e) {
			Result = "";
		}
		return Result;
	}

	// ����һ���������ֵ��ַ������ص�һ������ƴ������ĸ���ַ���
	private String String2AlphaFirst(String SourceStr, String type) {
		String Result = "";
		try {
			Result += Char2Alpha(SourceStr.charAt(0), type);
		} catch (Exception e) {
			Result = "";
		}
		return Result;
	}

	private boolean match(int i, int gb) {
		if (gb < table[i])
			return false;
		int j = i + 1;

		// ��ĸZʹ����������ǩ
		while (j < 26 && (table[j] == table[i]))
			++j;
		if (j == 26)
			return gb <= table[j];
		else
			return gb < table[j];
	}

	// ȡ�����ֵı���
	private int gbValue(char ch) {
		String str = new String();
		str += ch;
		try {
			byte[] bytes = str.getBytes("GBK");
			if (bytes.length < 2)
				return 0;
			return (bytes[0] << 8 & 0xff00) + (bytes[1] & 0xff);
		} catch (Exception e) {
			return 0;
		}
	}

	// ������ĸ��list�е���������
	// ��ʽ{rec:[{"key":"A","value":[{"CNAME":"adisen","age":10},{"CNAME":"advice","age":20}]},{"key":"H","value":[{"CNAME":"hello"}]},{"key":"W","value":[{"CNAME":"���ෲ"},{"CNAME":"���"}]},]}
	public String sort(List<HashMap<String, Object>> list, String pcName) {
		System.out.println("list=============================" + list);
		StringBuilder sb = new StringBuilder();
		sb.append("{rec:[");
		List arraylist = new ArrayList();
		String[] alphatableb = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
				"V", "W", "X", "Y", "Z" };
		int x = list.size();
		for (String a : alphatableb) {
			// System.out.println("zimu=="+a+"  "+list.size());
			for (int i = 0; i < list.size(); i++) {// Ϊ�����򶼷��ش�д��ĸ
				// System.out.println("list.get(i)=="+list.get(i));
				if (a.equals(String2AlphaFirst(list.get(i).get(pcName).toString(), "b"))) {
					HashMap<String, Object> map1 = list.get(i);
					arraylist.add(map1);
					// System.out.println("finded=="+list.get(i));
					list.remove(i);
					i--;
					// System.out.println("size+list=="+list.size()+"  list="+list);
				}
			}
			if (arraylist.size() > 0) {
				sb.append("{\"key\"").append(":\"").append(a).append("\",");
				sb.append("\"value\"").append(":").append(
						JSONArray.toJSON(arraylist).toString()).append("},");
			}
			arraylist.clear();
		}

		sb.append("]}");
		// System.out.println("zimu----toString==="+sb.toString());
		return sb.toString();

	}

	/**
	 * �����ݰ���ĸ��Χ����
	 * @param list ����������
	 * @param pcName Map��key
	 * @return
	 */
	public String sort12(List<HashMap<String, Object>> list,String pcName) {
		String[][] sheng = { 
					{"A", "B", "C", "D" , "E", "F", "G"}, 
					{"H","I", "J", "K" },
					{"L","M", "N", "O", "P", "Q", "R", "S" },
					{"T","U", "V", "W", "X","Y", "Z"}, 
				 };
		List<HashMap<String, Object>> arraylist1 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> hash2 = new HashMap<String, Object>();
		for (int j = 0; j < sheng.length; j++) {
			List<HashMap<String, Object>> arraylist = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> hash = new HashMap<String, Object>();
			for (String a : sheng[j]) {
				//System.out.println("sheng[j] ++" +a);
				for (int i = 0; i < list.size(); i++) {// Ϊ�����򶼷��ش�д��ĸ
						
					if (a.equals(String2AlphaFirst(list.get(i).get(pcName).toString(), "b"))) {
						HashMap<String, Object> map1 = list.get(i);
						arraylist.add(map1);
						list.remove(i);
						i--;
					}
				}
			}
			if(arraylist!=null&&arraylist.size()>0){
				hash.put("key",sheng[j][0]+"-"+sheng[j][sheng[j].length-1]);
				hash.put("value",arraylist);
				arraylist1.add(hash);
			}
		}
		hash2.put("reg", arraylist1);
		
		String abc =JSON.toJSON(hash2).toString();
		//System.out.println("���ǽ��" +abc);
		return abc;
	}
	
	/**
	 * �����ݰ���ĸ��Χ����
	 * @param list ����������
	 * @param pcName Map��key
	 * @return
	 */
	public String sort13(List<HashMap<String, Object>> list,String pcName) {
		
		String[][] sheng = { 
					{"A", "B", "C", "D" }, 
					{"E", "F", "G", "H"},
					{"I","J", "K", "L" },
					{"M", "N", "O", "P"}, 
					{"Q", "R", "S", "T" },
					{"U","V", "W", "X"}, 
					{ "Y", "Z" }, 
				 };
		List<HashMap<String, Object>> arraylist1 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> hash2 = new HashMap<String, Object>();
		for (int j = 0; j < sheng.length; j++) {
			List<HashMap<String, Object>> arraylist = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> hash = new HashMap<String, Object>();
			for (String a : sheng[j]) {
				for (int i = 0; i < list.size(); i++) { 
						
					if (a.equals(String2AlphaFirst(list.get(i).get(pcName).toString(), "b"))) {
						HashMap<String, Object> map1 = list.get(i);
						arraylist.add(map1);
						list.remove(i);
						i--;
					}
				}
			}
			if(arraylist!=null&&arraylist.size()>0){
				hash.put("key",sheng[j][0]+"-"+sheng[j][sheng[j].length-1]);
				hash.put("value",arraylist);
				arraylist1.add(hash);
			}
		}
		hash2.put("reg", arraylist1);
		
		String abc =JSON.toJSON(hash2).toString();
		return abc;
	}
	public static void main(String[] args) {

		System.out.println("======================");
		HashMap<String, Object> m1 = new HashMap<String, Object>();
		HashMap<String, Object> m11 = new HashMap<String, Object>();
		HashMap<String, Object> m12 = new HashMap<String, Object>();
		HashMap<String, Object> m2 = new HashMap<String, Object>();
		HashMap<String, Object> m3 = new HashMap<String, Object>();
		HashMap<String, Object> m4 = new HashMap<String, Object>();
		HashMap<String, Object> m5 = new HashMap<String, Object>();
		HashMap<String, Object> m6 = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		m1.put("age", 10);
		m1.put("CNAME", "����");
		list.add(m1);

		m12.put("age", 20);
		m12.put("CNAME", "����ʡ");
		list.add(m12);

		m11.put("age", 20);
		m11.put("CNAME", "���");
		list.add(m11);

		m2.put("CNAME", "�ӱ�ʡ");

		list.add(m2);
		m3.put("CNAME", "ɽ��ʡ");

		list.add(m3);
		m4.put("CNAME", "���ɹ�������");

		list.add(m4);
		m5.put("CNAME", "ɽ��ʡ");
		
		m6.put("CNAME", "����");
		list.add(m6);

		ZimuSort zimusort = new ZimuSort();
		//String resultStr = zimusort.sort(list, "CNAME");
		//System.out.println(list);

		//System.out.println("okokkkkkkkkkkkkk=" + list);
		System.out.println("++++++++++++"+list);
		//String resultStr1 = zimusort.sort12(list, "CNAME").toString();
		
		System.out.println("heheheh="+zimusort.sort(list, "CNAME"));
		 
		//System.out.println(resultStr1);
		// list.add("Kobe");
		// list.add("����");
		// list.add("�Ÿ�");
		// list.add("Ԫ��");
		// list.add("���»�");
		// list.add("�����");
		// Map map=obj1.sort(list);
		// System.out.println(map);
		// System.out.println("-------���������-----------");
		// System.out.println(map.get("A"));
		// System.out.println(map.get("B"));
		// System.out.println(map.get("C"));
		// System.out.println(map.get("D"));
		// System.out.println(map.get("Y"));
		// System.out.println(map.get("L"));

	}

	 
}
