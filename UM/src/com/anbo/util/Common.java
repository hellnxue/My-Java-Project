package com.anbo.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.w3c.dom.Document;

/**
 * 公共函数包装类
 * 
 * @author peishenglin
 * 
 */
public class Common {

	private Log logger = LogFactory.getLog(getClass());

	// ORACLE数据库DATE默认格式
	public final static String ORACLE_DATE_FORMAT = "YYYY-MM-DD HH24:MI:SS";

	// JAVA中对应ORACLE的日期默认格式
	public final static String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	// 系统时间默认格式
	public final static String DEFAULT_DATE_FORMAT = "yyyyMMddHHmmss";

	public static final String DATE_PATTERN_LONG = "yyyy-MM-dd HH:mm";
	public static final String DATE_PATTERN_SHORT = "yyyy-MM-dd";
	public static final String DATE_PATTERN_SHORT1 = "yyyyMMdd";

	public static final String DEFAULT_MONTH = "yyyyMM";

	//
	public static final SimpleDateFormat SDF_SIMPLE_DATE_FORMAT = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
	public static final SimpleDateFormat SDF_DEFAULT_FORMAT = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	public static final SimpleDateFormat SDF_PATTERN_SHORT = new SimpleDateFormat(DATE_PATTERN_SHORT);
	public static final SimpleDateFormat SDF_PATTERN_SHORT1 = new SimpleDateFormat(DATE_PATTERN_SHORT1);
	public static final SimpleDateFormat SDF_DEFAULT_MONTH = new SimpleDateFormat(DEFAULT_MONTH);

	// 用户无权限访问某个模块时，jsp页面缺省返回此字符串。
	public final static String NO_PERMISSION = "当前用户没有权限访问此模块!";

	public static String emptyString = "";
	
	 /**
     * 判断一个时间是否在另一个时间段内（时分秒判断）
     * 参数格式 yyyy-MM-dd HH:mm:ss
     * @param strDate
     * @param strDateBegin
     * @param strDateEnd
     * @return
     */
    public static boolean isInDates(String strDate,String strDateBegin,String strDateEnd){   
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date myDate = null;  
        Date dateBegin = null;  
        Date dateEnd = null;  
        try {  
            myDate = sd.parse(strDate);  
            dateBegin = sd.parse(strDateBegin);  
            dateEnd = sd.parse(strDateEnd);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        strDate = String.valueOf(myDate);  
        strDateBegin = String.valueOf(dateBegin);  
        strDateEnd = String.valueOf(dateEnd);  
          
        int strDateH = Integer.parseInt(strDate.substring(11,13));  
        int strDateM = Integer.parseInt(strDate.substring(14,16));  
        int strDateS = Integer.parseInt(strDate.substring(17,19));  
          
        int strDateBeginH = Integer.parseInt(strDateBegin.substring(11,13));  
        int strDateBeginM = Integer.parseInt(strDateBegin.substring(14,16));  
        int strDateBeginS = Integer.parseInt(strDateBegin.substring(17,19));  
          
        int strDateEndH = Integer.parseInt(strDateEnd.substring(11,13));  
        int strDateEndM = Integer.parseInt(strDateEnd.substring(14,16));  
        int strDateEndS = Integer.parseInt(strDateEnd.substring(17,19));  
          
        if((strDateH>=strDateBeginH && strDateH<=strDateEndH)){  
            if(strDateH>strDateBeginH && strDateH<strDateEndH){  
                return true;  
            }else if(strDateH==strDateBeginH && strDateM>strDateBeginM && strDateH<strDateEndH){  
                return true;  
            }else if(strDateH==strDateBeginH && strDateM==strDateBeginM && strDateS>strDateBeginS && strDateH<strDateEndH){  
                return true;  
            }else if(strDateH==strDateBeginH && strDateM==strDateBeginM && strDateS==strDateBeginS && strDateH<strDateEndH){  
                return true;  
            }else if(strDateH>strDateBeginH && strDateH==strDateEndH && strDateM<strDateEndM){  
                return true;  
            }else if(strDateH>strDateBeginH && strDateH==strDateEndH && strDateM==strDateEndM && strDateS<strDateEndS){  
                return true;  
            }else if(strDateH>strDateBeginH && strDateH==strDateEndH && strDateM==strDateEndM && strDateS==strDateEndS){  
                return true;  
            }else{  
                return false;  
            }  
        }else{  
            return false;  
        }  
    }  
	
	/**
	 获得上个月的时间（年月）,欠测
	**/
	public static String getLastDate(){
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
   	    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        Date date=new Date();
		gc.setTime(date);
		gc.add(Calendar.MONTH, -1);
		String month=sdf.format(gc.getTime());
		return month;
	}

	/**
	 * 得到格式化的数字，
	 * 
	 * @param num
	 *            要格式化的数字字符串
	 * @param format
	 *            格式,如"000000"
	 * @return
	 */
	public static String getFormatNumber(String num, String format) {
		DecimalFormat nf = new DecimalFormat(format);
		return nf.format(Long.parseLong(num));

	}

	/**
	 * 得到格式化的数字,入口参数为数字 格式"00000000"
	 */
	public static String getFormatNumber(Long num, String format) {
		DecimalFormat nf = new DecimalFormat(format);
		return nf.format(num);
	}

	/**
	 * 得到格式化的数字,入口参数为double num 要格式化的数字 format 格式化描述串
	 * 
	 */
	public static String getFormatNumber(double num, String format) {
		DecimalFormat nf = new DecimalFormat(format);
		return nf.format(num);
	}

	/**
	 * 将一个Date类型转换成一个format格式的字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(String date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	/**
	 * 得到格式化的数字,入口参数为double num 要格式化的数字 format 格式化描述串 #以空格填充
	 * 
	 */
	public static String formatNumber(double num, String format) {
		DecimalFormat nf = new DecimalFormat(format);

		String ret = nf.format(num);
		int fmtLen = format.length();
		int vLen = ret.length();
		for (int i = 0; i < fmtLen - vLen; i++) {
			ret = " " + ret;
		}
		return ret;
	}

	/**
	 * 得到格式化的数字,入口参数为String num 要格式化的数字 format 格式化描述串 #以空格填充
	 * 
	 */
	public static String formatNumber(String num, String format) {
		DecimalFormat nf = new DecimalFormat(format);
		String ret = nf.format(new Double(num));
		int fmtLen = format.length();
		int vLen = ret.length();
		for (int i = 0; i < fmtLen - vLen; i++) {
			ret = " " + ret;
		}
		return ret;
	}

	// / <summary>
	// / 转化成字符串，特别是科学计数法的问题
	// / </summary>
	// / <param name="doubleData"></param>
	// / <returns></returns>
	public static String DoubleParse(String doubleData) {
		if (doubleData != null && doubleData.trim().length() != 0) {
			try {
				DecimalFormat nf = new DecimalFormat("#0.0000");
				doubleData = nf.format(Double.parseDouble(doubleData));

				while (doubleData.endsWith("0")) {
					doubleData = doubleData.substring(0, doubleData.length() - 1);
				}
				if (doubleData.endsWith(".")) {
					doubleData = doubleData.substring(0, doubleData.length() - 1);
				}
			} catch (Exception e) {
			}
		}

		return doubleData;
	}

	public static String DoubleParse(Double dd) {
		String doubleData = "";
		try {
			DecimalFormat nf = new DecimalFormat("#0.0000");
			doubleData = nf.format(dd);

			while (doubleData.endsWith("0")) {
				doubleData = doubleData.substring(0, doubleData.length() - 1);
			}
			if (doubleData.endsWith(".")) {
				doubleData = doubleData.substring(0, doubleData.length() - 1);
			}
		} catch (Exception e) {
		}

		return doubleData;
	}

	public static String DoubleParse(Long dd) {
		String doubleData = "";
		try {
			DecimalFormat nf = new DecimalFormat("#0");
			doubleData = nf.format(dd);
		} catch (Exception e) {
		}

		return doubleData;
	}

	/**
	 * 得到格式化的数字,入口参数为long num 要格式化的数字 format 格式化描述串 #以空格填充
	 * 
	 */
	public static String formatNumber(long num, String format) {
		DecimalFormat nf = new DecimalFormat(format);
		String ret = nf.format(num);
		int fmtLen = format.length();
		int vLen = ret.length();
		for (int i = 0; i < fmtLen - vLen; i++) {
			ret = " " + ret;
		}
		return ret;
	}

	/**
	 * 将String格式化成Long
	 * 
	 * @param str
	 *            String
	 * @return Long
	 */
	public static Long formatString2Long(String str) {
		Long result = new Long(0);
		try {
			result = new Long(str);
		} catch (Exception e) {
			result = new Long(0);
		}
		return result;
	}

	/**
	 * 得到格式化的数字,入口参数为float num 要格式化的数字 format 格式化描述串 #以空格填充
	 * 
	 */
	public static String formatNumber(float num, String format) {
		DecimalFormat nf = new DecimalFormat(format);
		String ret = nf.format(num);
		int fmtLen = format.length();
		int vLen = ret.length();
		for (int i = 0; i < fmtLen - vLen; i++) {
			ret = " " + ret;
		}
		return ret;
	}

	/**
	 * 得到格式化的数字,入口参数为int num 要格式化的数字 format 格式化描述串 #以空格填充
	 * 
	 */
	public static String formatNumber(int num, String format) {
		DecimalFormat nf = new DecimalFormat(format);
		String ret = nf.format(num);
		int fmtLen = format.length();
		int vLen = ret.length();
		for (int i = 0; i < fmtLen - vLen; i++) {
			ret = " " + ret;
		}
		return ret;
	}

	/**
	 * 得到系统时间 格式yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowString() {
		SimpleDateFormat CurTime = new SimpleDateFormat(Common.SIMPLE_DATE_FORMAT);
		Calendar Cal = Calendar.getInstance();

		return CurTime.format(Cal.getTime());
	}

	/**
	 * 得到短格式的系统时间 格式yyyy-MM-dd
	 */
	public static String getNowStringShort() {
		SimpleDateFormat CurTime = new SimpleDateFormat(Common.DATE_PATTERN_SHORT);
		Calendar Cal = Calendar.getInstance();

		return CurTime.format(Cal.getTime());
	}

	public static Date getNowTime() {
		Calendar Cal = Calendar.getInstance();
		return Cal.getTime();
	}

	/**
	 * 得到系统时间 格式自己指定
	 */
	public static String getNowString(String format) {
		SimpleDateFormat CurTime = new SimpleDateFormat(format);
		Calendar Cal = Calendar.getInstance();

		return CurTime.format(Cal.getTime());
	}

	/**
	 * 得到几天前的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static String getDateBefore(Date d, int day, String format) {
		SimpleDateFormat CurTime = new SimpleDateFormat(format);
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return CurTime.format(now.getTime());
	}

	/**
	 * 得到几天后的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static String getDateAfter(Date d, int day, String format) {
		SimpleDateFormat CurTime = new SimpleDateFormat(format);
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return CurTime.format(now.getTime());
	}

	/**
	 * 用于生成报文的文件名中的时间字符串
	 * 
	 * @return String
	 */
	public static String getCurrentTime() {
		SimpleDateFormat CurTime = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar Cal = Calendar.getInstance();

		return CurTime.format(Cal.getTime());
	}

	/**
	 * 用于查询时显示上一个月的时间字符串
	 * 
	 * @return String
	 */
	public static String getLastMonthTime(String DateFormat) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(getNowTime());
		cal.add(Calendar.MONTH, -1);
		return getTime(cal.getTime(), DateFormat);
	}

	/**
	 * 用于查询时显示上一个月的时间字符串
	 * 
	 * @return String
	 */
	public static String getNextMonthTime(String DateFormat) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(getNowTime());
		cal.add(Calendar.MONTH, +1);
		return getTime(cal.getTime(), DateFormat);
	}

	public static Date addTime(Date date, int type, int offset) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(date);
		cal.add(type, offset);
		return cal.getTime();
	}

	/**
	 * 用于生成报文的文件名中的时间字符串
	 * 
	 * @return String
	 */
	public static String getCurrentTime(String DateFormat) {
		SimpleDateFormat CurTime = new SimpleDateFormat(DateFormat);
		Calendar Cal = Calendar.getInstance();

		return CurTime.format(Cal.getTime());
	}

	/**
	 * 写String至磁盘文件
	 */
	public static void str2File(String content, String fullFileName) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(fullFileName);
			os.write(content.getBytes());
		} catch (Exception e) {
		} finally {
			try {
				os.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 写byte[]至磁盘文件
	 */
	public static void bytes2File(byte[] content, String fullFileName) {
		OutputStream os = null;
		try {
			File f = new File(fullFileName);
			if (!f.exists()) {
				f.createNewFile();
			}
			os = new FileOutputStream(fullFileName);
			os.write(content);
		} catch (Exception e) {
		} finally {
			try {
				os.close();
			} catch (Exception e) {
			}
		}

	}

	/**
	 * 在路径的末端加入分隔符delimited 如果已有delimited，则不添加
	 */
	public static String addSep(String orgString, char delimited) {
		if ((orgString == null) || (orgString.equals(""))) {
			return orgString;
		} else if (orgString.charAt(orgString.length() - 1) == delimited) {
			return orgString;
		} else {
			return orgString + String.valueOf(delimited);
		}
	}

	/**
	 * 在路径的末端加入分隔符delimited 如果已有delimited，则不添加 delimited用系统默认的目录分割符
	 */
	public static String addSep(String orgString) {
		char delimited = File.separatorChar;
		if ((orgString == null) || (orgString.equals(""))) {
			return orgString;
		} else if (orgString.charAt(orgString.length() - 1) == delimited) {
			return orgString;
		} else {
			return orgString + String.valueOf(delimited);
		}
	}

	/**
	 * 将题Timestamp转换String
	 */
	public static String ConvertTimestampToStr(Timestamp datetime) {
		if (datetime != null) {
			return datetime.toString();
		}
		return "";
	}

	/**
	 * 将序列化对象存为一个指定的文件
	 */
	public static void writeObjectToFile(String fileName, Object obj) throws Exception {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(obj);
			out.close();
		} catch (Exception e) {
			try {
				out.close();
			} catch (Exception e1) {
			}
			throw e;
		}
	}

	/**
	 * 将对象文件还原成对象
	 */
	public static Object readObjectFromFile(String fileName) throws Exception {
		ObjectInputStream in = null;
		FileInputStream fin = null;
		Object obj;
		try {
			fin = new FileInputStream(fileName);
			in = new ObjectInputStream(fin);
			obj = in.readObject();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				in.close();
			} catch (Exception e1) {
			}
			try {
				fin.close();
			} catch (Exception e2) {
			}
		}
		return obj;
	}

	/**
	 * 读取文件内容
	 * 
	 * @param fileFullName
	 * @return
	 * @throws Exception
	 */
	public static byte[] readFile(String fileFullName) throws Exception {
		FileInputStream fin = null;
		byte[] buffer;
		try {
			File file = new File(fileFullName);
			fin = new FileInputStream(fileFullName);
			buffer = new byte[(int) file.length()];
			fin.read(buffer);
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				fin.close();
			} catch (Exception e1) {
			}
		}
		return buffer;
	}

	/**
	 * DoNull处理
	 */
	public static String doNull(String s) {
		if (s == null) {
			return "";
		} else {
			return s;
		}
	}

	/**
	 * DoNull处理
	 */
	public static String doNull(String i, String j) {
		if (i == null) {
			return j;
		} else {
			return i;
		}
	}

	/**
	 * 字符串转义 将一个单引号变成两个单引号
	 */
	public static String convertMeaning(String str) {
		String rel = "";
		int intcurrent = 0;
		int intlast = 0;
		while (intcurrent != -1) {
			intcurrent = str.indexOf("'", intcurrent);
			if (intcurrent != -1) {
				rel = rel + str.substring(intlast, intcurrent) + "'";
			} else {
				break;
			}
			intlast = intcurrent;
			intcurrent++;
		} // end of while
		return rel + str.substring(intlast);
	}

	/**
	 * 字符串转义
	 */
	public static String convertMeaning(String str, String searchStr) {
		String rel = "";
		int intcurrent = 0;
		int intlast = 0;
		int searLength = searchStr.length();

		while (intcurrent != -1) {
			intcurrent = str.indexOf(searchStr, intcurrent);
			if (intcurrent != -1) {
				rel = rel + str.substring(intlast, intcurrent) + searchStr;
			} else {
				break;
			}
			intlast = intcurrent;
			// intcurrent++;
			intcurrent += searLength;
		} // end of while
		return rel + str.substring(intlast);
	}

	/**
	 * 字符串转义
	 */
	public static String convertMeaning(String str, String searchStr, String addStr) {
		String rel = "";
		int intcurrent = 0;
		int intlast = 0;
		int searLength = searchStr.length();

		while (intcurrent != -1) {
			intcurrent = str.indexOf(searchStr, intcurrent);
			if (intcurrent != -1) {
				rel = rel + str.substring(intlast, intcurrent) + addStr;
			} else {
				break;
			}
			intlast = intcurrent;
			intcurrent += searLength;
		} // end of while
		return rel + str.substring(intlast);
	}

	/**
	 * 字符转义 将needTrans中每一个在src中的字符转义（加上转义符esc）
	 */
	public static String convertMeaning(String src, String needTrans, char esc) {

		StringBuffer buffer = new StringBuffer();
		;
		char tmp;
		int current = 0;
		int srcLength = src.length();
		int needTransCharCount = needTrans.length();
		int i = 0;

		for (current = 0; current < srcLength; current++) {
			tmp = src.charAt(current);
			for (i = 0; i < needTransCharCount; i++) {
				if (tmp == needTrans.charAt(i)) {
					buffer.append(esc);
					break;
				}
			}
			buffer.append(tmp);
		}

		return buffer.toString();
	}

	/**
	 * 性能好一些的replace函数
	 * 
	 * @param strSource
	 * @param strFrom
	 * @param strTo
	 * @return String
	 */
	public static String replace(String str, String pattern, String replace) {
		int s = 0;
		int e = 0;
		StringBuffer result = new StringBuffer();

		while ((e = str.indexOf(pattern, s)) >= 0) {
			result.append(str.substring(s, e));
			result.append(replace);
			s = e + pattern.length();
		}
		result.append(str.substring(s));
		return result.toString();
	}

	/**
	 * '替换成''
	 * 
	 * @param str
	 *            String
	 * @return String
	 */
	public static String replace2Oracle(String str) {
		if (str == null || str.equals("")) {
			return str;
		}

		str = replace(str, "'", "''");
		str = replace(str, ":", "");
		return str;
	}

	/**
	 * 首字母替换成大写
	 * 
	 * @param str
	 *            String
	 * @return String
	 */
	public static String string2UpperCase(String str) {
		if (str == null || str.equals("")) {
			return str;
		}

		// char subStr = str.substring(0,1).charAt(0);
		// str =
		// String.valueOf(Character.toUpperCase(subStr))+str.substring(1,str.length());
		str = str.toUpperCase();
		return str;
	}

	/**
	 * 将一个Date类型转换成一个format格式的字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getTime(Date date, String format) {
		if (date == null)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);

	}

	/**
	 * 将字符串中的空格转换成<BR>
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String changeBlank(String str) {
		if (str == null)
			return null;
		return replace(str, " ", "<br>");

	}

	/**
	 * 将一种格式的时间串变为另一种格式时间串
	 * 
	 * @param sTime
	 *            时间串
	 * @param srcFmt
	 *            转变前格式
	 * @param toFmt
	 *            转变后格式
	 * @return 转变后串
	 */
	public static String getTime(String sTime, String srcFmt, String toFmt) throws java.text.ParseException {

		java.text.DateFormat df = new SimpleDateFormat(srcFmt);
		Date tTime;
		try {
			tTime = df.parse(sTime);
		} catch (java.text.ParseException e) {
			throw e;
		}
		return getTime(tTime, toFmt);
	}

	public static String xml2String(Document xmlDoc) {
		String stylesheet = "";
		String strRel = null;
		OutputStream out = new ByteArrayOutputStream();
		byte b[] = null;
		try {
			Transformer transformer;
			TransformerFactory factory = TransformerFactory.newInstance();
			if (!stylesheet.trim().equals("")) {
				transformer = factory.newTransformer(new StreamSource(stylesheet));
			} else {
				transformer = factory.newTransformer();
			}
			transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
			transformer.transform(new DOMSource(xmlDoc), new StreamResult(out));
			ByteArrayOutputStream tmp = (ByteArrayOutputStream) out;
			b = tmp.toByteArray();
			strRel = new String(b);
		} catch (Exception e) {
			System.out.println(e);
		}
		return strRel;
	}

	/**
	 * * 格式化字符串
	 * 
	 * @param src
	 *            要格式化的字符串
	 * @param align
	 *            对齐方式 L-左对齐 R-右对齐
	 * @param fill
	 *            填充字符
	 * @param width
	 *            格式化后串长度
	 */
	public static String formatString(String src, char align, String fill, int width) {

		String tmp = "";
		int srcLen = src.getBytes().length;
		if (width <= srcLen)
			return new String(src.getBytes(), 0, width);
		else {
			if (align == 'L') { // 左对齐
				tmp = src;
				for (int i = 0; i < width - srcLen; i++)
					tmp += fill;

			} else if (align == 'R') { // 右对齐
				for (int i = 0; i < width - src.getBytes().length; i++)
					tmp += fill;

				tmp += src;
			}
		}

		return tmp;

	}

	/**
	 * 将文件移动到指定目录
	 * 
	 * @param fileName
	 *            要移动的文件
	 * @param toFolder
	 *            目标目录
	 * @return 成功返回true，失败返回false
	 */

	public static boolean moveTo(String fileName, String toFolder) throws Exception {

		File srcFile = new File(fileName);

		// 如果文件大小为0，则删除文件
		if (srcFile.length() == 0) {
			srcFile.delete();
			return true;
		}
		// 取文件名
		String newFile = srcFile.getName();

		File toFd = new File(toFolder, newFile);
		return srcFile.renameTo(toFd);

	}

	/**
	 * * 将文件移动到指定目录下的指定文件
	 * 
	 * @param fileName
	 *            要移动的文件 * @param toFolder 目标目录 * @return 成功返回true，失败返回false
	 */

	public static boolean moveToFile(String fileName, String toFile) throws Exception {

		File srcFile = new File(fileName);

		// 如果文件大小为0，则删除文件
		// if (srcFile.length()==0){
		// srcFile.delete();
		// return true;
		// }
		File toFd = new File(toFile);

		return srcFile.renameTo(toFd);
		// copyFile(fileName,toFile);
		// deleteFile(fileName);
		// return true;

	}

	/**
	 * 根据每一行的前1-21字符得到每一行的类型
	 */
	public static String getLineType(String line) {
		return line.substring(1, 21).trim();
	}

	/**
	 * copy文件
	 */
	public static void copyFile(String sourceFileName, String desFileName) {
		OutputStream os = null;
		try {
			File f = new File(desFileName);
			if (!f.exists()) {
				f.createNewFile();
			}
			os = new FileOutputStream(desFileName);
			os.write(readFile(sourceFileName));
		} catch (Exception e) {
		} finally {
			try {
				os.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 删除文件
	 * 
	 */

	public static void deleteFile(String fileName) {
		try {

			File f = new File(fileName);
			f.delete();
		} catch (Exception e) {

		}
	}

	/**
	 * 解zip文件到指定目录,zip中不能包括目录名，文件名不能包含中文
	 * 
	 * @param zipFile
	 *            要解压的文件 * @param toFolder 解压后存放目录 * @return 解压后文件名（包括路径）向量
	 */

	static public Vector unZipFile(String zipFile, String toFolder) throws Exception {

		Vector fileList = new Vector();
		FileInputStream fi = null;
		ZipInputStream in2 = null;
		OutputStream outfile = null;
		String strOutFile = "";
		int pos = 0;
		try {
			fi = new FileInputStream(zipFile);
			CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
			in2 = new ZipInputStream(new BufferedInputStream(csumi));

			ZipEntry ze;

			while ((ze = in2.getNextEntry()) != null) {
				// System.out.println("Reading file " + ze);
				strOutFile = ze.getName();

				if ((pos = strOutFile.lastIndexOf("/")) > 0)
					strOutFile = strOutFile.substring(0, pos);

				if ((pos = strOutFile.lastIndexOf("\\")) > 0)
					strOutFile = strOutFile.substring(0, pos);

				strOutFile = toFolder + File.separator + strOutFile;

				outfile = new BufferedOutputStream(new FileOutputStream(strOutFile));
				// outfile=new FileOutputStream(strOutFile);
				// 输出解压文件

				int bufsize = 8192;
				int readbytes;
				byte[] readbuf = new byte[bufsize];

				while ((readbytes = in2.read(readbuf)) != -1) {

					outfile.write(readbuf, 0, readbytes);
				}

				// 关闭解压文件
				outfile.flush();

				outfile.close();
				fileList.add(strOutFile);

			}

			in2.close();

		} catch (Exception e) {

			throw e;
		} finally {

			try {
				outfile.close();
				in2.close();

			} catch (Exception ignore) {
			}

		}

		return fileList;
	}

	/**
	 * 将文件压缩到zip文件,zip中不能包括目录名，文件名不能包含中文
	 * 
	 * @param files
	 *            要压缩的文件名数组 * @param zipFile 压缩后文件名
	 */

	static public void zipFile(String[] files, String zipFile) throws Exception {

		FileOutputStream f = null;

		InputStream in = null;
		byte[] buf = new byte[4096];
		String fileName = "";
		String title = "";
		int readBytes = 0;
		try {

			// 压缩后文件
			f = new FileOutputStream(zipFile);
			CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(csum));
			// out.setComment("zip files");

			for (int i = 0; i < files.length; i++) {
				fileName = files[i];

				in = new BufferedInputStream(new FileInputStream(fileName));
				title = fileName.substring(fileName.lastIndexOf("\\") + 1);
				title = fileName.substring(fileName.lastIndexOf("/") + 1);
				out.putNextEntry(new ZipEntry(title));

				// 将数据写到zip文件
				while ((readBytes = in.read(buf)) != -1) {

					out.write(buf, 0, readBytes);

				}

				in.close();

			}
			out.close();
			f.close();

		} catch (Exception e) {

			throw e;
		} finally {
			try {
				in.close();
				f.close();

			} catch (Exception ignore) {
			}

		}

	} // zip end

	/**
	 * 
	 * @param Dictory
	 *            要备份文件所在目录
	 * @param FileName
	 *            文件名，不含路径
	 * 
	 * 
	 */
	/*
	 * public static void backupFile(String Dictory,String FileName) throws
	 * Exception{ //首先获得报文备份的目录 String bkFolder;
	 * bkFolder=Common.addSep(Config.getValue("BackupFolder")); File homedir=new
	 * File(bkFolder); String EMSBackupFileName=null; String EMSFileName=null;
	 * EMSFileName=Common.addSep(Dictory)+FileName;
	 * EMSBackupFileName=bkFolder+Common
	 * .addSep(Common.getCurrentTime("yyyy-MM-dd"),'/')+FileName;
	 * if(homedir.exists() && homedir.isDirectory() && homedir.canWrite()){
	 * //如果目录存在,创建子目录 File savedir=new
	 * File(homedir,Common.getCurrentTime("yyyy-MM-dd")); //备份文件
	 * savedir.mkdir(); Common.copyFile(EMSFileName,EMSBackupFileName); }else{
	 * throw new Exception("备份目录不存在！"); } } public static void
	 * backupReplyFile(String Dictory,String FileName) throws Exception{
	 * //首先获得报文备份的目录 String bkFolder;
	 * bkFolder=Common.addSep(Config.getValue("ReplyBackupFolder")); File
	 * homedir=new File(bkFolder); String EMSBackupFileName=null; String
	 * EMSFileName=null; EMSFileName=Common.addSep(Dictory)+FileName; String
	 * DataTimeStr=Common.getCurrentTime("yyyy-MM-dd");
	 * EMSBackupFileName=bkFolder+Common.addSep(DataTimeStr,'\\')+FileName;
	 * if(homedir.exists() && homedir.isDirectory() && homedir.canWrite()){
	 * //如果目录存在,创建子目录 File savedir=new File(homedir,DataTimeStr); //备份文件
	 * savedir.mkdir(); Common.copyFile(EMSFileName,EMSBackupFileName); }else{
	 * throw new Exception("回执备份目录不存在！"); } }
	 */
	public static String getExtName(String fileName) {
		StringTokenizer fileToken;
		String returnval = "";
		fileToken = new StringTokenizer(fileName, ".");
		while (fileToken.hasMoreTokens()) {
			returnval = fileToken.nextToken();
		}
		return returnval;
	}

	/**
	 * 在当前目录下更改文件名
	 * 
	 * @param sourceName
	 *            原名，带路径
	 * @param destName
	 *            新名,不带路径
	 */

	public static void rename(String sourceName, String destName) {

		File srcFile = new File(sourceName);

		File dstFile = new File(srcFile.getParent(), destName);
		srcFile.renameTo(dstFile);

	}

	// /**
	// * 将字符串分割到字符数组中
	// * @param str 要分割的字符串
	// * @param delim 分割符
	// * @return 分割后字符串数组
	// *
	// */
	// public static String[] split(String str,String delim){
	// XStringTokenizer st = new XStringTokenizer(str,delim);
	// Vector vt=new Vector();
	// while (st.hasMoreTokens()) {
	// vt.add(st.nextToken());
	// }
	//
	// return (String[])vt.toArray(new String[]{""});
	//
	//
	// }

	/**
	 * 将Vector转换为字符串数组
	 * 
	 * @param vect
	 *            需转换的Vector
	 * @return 字符串数组
	 */
	public static String[] vector2StringArray(Vector vect) {
		if (vect == null)
			return null;
		String[] strArray = new String[vect.size()];
		for (int i = 0; i < vect.size(); i++) {
			try {
				strArray[i] = (String) vect.get(i);
			} catch (Exception e) {
				strArray[i] = "";
			}
		}
		return strArray;
	}

	/**
	 * 将字符串以作为日期加减
	 * 
	 * @param day
	 *            （"YYYY-MM-DD"）
	 * @param interval
	 *            加减间隔
	 */

	public static String dateAdd(String strDay, int interval) {
		String dayLocal = strDay.substring(0, 4) + strDay.substring(5, 7) + strDay.substring(8, 10);
		SimpleDateFormat sdt = new SimpleDateFormat("yyyyMMdd");
		String retDate = "";
		try {
			Date day = sdt.parse(dayLocal);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(day);
			calendar.add(Calendar.DATE, interval);
			retDate = sdt.format(calendar.getTime());
			// System.out.println("retDate"+retDate);
		} catch (Exception e) {
		}
		retDate = retDate.substring(0, 4) + "-" + retDate.substring(4, 6) + "-" + retDate.substring(6, 8);
		return retDate;
	}

	/**
	 * 
	 * @return 获取本机IP地址，格式为x.x.x.x字符串
	 * 
	 */
	public static String getLocalIP() {
		String locIP = "";
		try {
			locIP = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException ignore) {
		}

		return locIP;
	}

	public static String list2String(List strList, String seprator) {
		StringBuffer str = new StringBuffer();
		try {
			str.append(strList.get(0));
			for (int i = 1; i < strList.size(); i++) {
				str.append(seprator).append(strList.get(i));

			}
		} catch (Exception e) {
		}
		return str.toString();
	}

	public static String[] split(String str, String delim) {
		if (emptyString.equals(str))
			return new String[] { "" };
		StringTokenizer st = new StringTokenizer(str, delim);
		Vector vt = new Vector();
		while (st.hasMoreTokens()) {
			vt.add(st.nextToken());
		}
		return (String[]) vt.toArray(new String[] { "" });
	}

	public static Vector split2vect(String str, String delim) {
		Vector vect = new Vector();
		if (str == null)
			return vect;
		str = str.trim();
		if (str.length() == 0)
			return vect;
		StringTokenizer st = new StringTokenizer(str, delim);
		while (st.hasMoreTokens()) {
			vect.add(st.nextToken());
		}
		return vect;
	}

	/**
	 * 对double数进行四舍五入
	 * 
	 * @param value
	 *            double 要四舍五入的数
	 * @param pos
	 *            int 要保留的小数位数
	 * @throws Exception
	 * @return double
	 */
	public static double round(double value, int pos) {
		int divisor = 1;
		for (int i = 0; i < pos; i++)
			divisor *= 10;
		Double d = new Double(value * divisor + 0.5);
		double result = (double) d.longValue() / divisor;
		return result;
	}

	/**
	 * 对double截取n位小数
	 * 
	 * @param value
	 *            double 要截取小数的数
	 * @param pos
	 *            int 要保留的小数位数
	 * @throws Exception
	 * @return double
	 */
	public static double floor(double value, int pos) {
		int divisor = 1;
		for (int i = 0; i < pos; i++)
			divisor *= 10;
		Double d = new Double(value * divisor);
		double result = (double) d.longValue() / divisor;
		return result;
	}

	public static double floor(double value) {
		return floor(value, 0);
	}

	public static String filterNullString(String val) {
		if (val == null)
			return emptyString;
		else
			return val;
	}

	/**
	 * 限制显示字符串长度
	 * 
	 * @param val
	 *            String
	 * @return String
	 */
	public static String formatStringLength(String val) {
		int showOrgLength = 8;
		if (val == null || val.length() <= showOrgLength)
			return val;
		else {
			return val.substring(0, showOrgLength) + "...";
		}
	}

	/**
	 * 判断String是否为空
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * 判断一个对象是否为空
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isEmpty(Object o) {
		return (o == null || "".equals(String.valueOf(o).trim())) ? true : false;
	}

	/**
	 * 判断一个对象是否为空
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isNotEmpty(Object o) {
		return (o != null && !"".equals(String.valueOf(o).trim())) ? true : false;
	}

	/**
	 * 将DATE型值转换成指定格式的String
	 * 
	 * @param str
	 *            java.sql.Date
	 * @return String
	 */
	public static String date2String(java.sql.Date dt) {
		if (dt == null) {
			return "''";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
		return "'" + sdf.format(dt) + "'";
	}

	public static String date2Str(String pattern, Date date) {
		if (date == null)
			return "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			return formatter.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 将ORACLE的值进行处理 (1) '=>'' (2) 回车符=>\r\n
	 * 
	 * @param str
	 * @return String
	 */

	public static String replaceOracleValue(String strSource) {
		if (isEmpty(strSource)) {
			return strSource;
		}
		String str = strSource;
		str = replace(str, "'", "''");
		str = replace(str, "\\", "\\\\");
		str = replace(str, "\r\n", "\\r\\n");
		str = replace(str, "\n", "\\r\\n");
		return str;
	}

	/**
	 * 将String处理成ORACLE的值
	 * 
	 * @param str
	 *            String
	 * @return String
	 */
	public static String replace2OracleValue(String str) {
		if (str == null) {
			return "''";
		}
		str = replace(str, "\\r\\n", "\r\n");
		str = replace(str, "\\\\", "\\");
		return str;
	}

	/**
	 * 删除报文头
	 * 
	 * @param oldfile
	 *            报文文件
	 * @param headLength
	 *            报文头长度
	 * @throws Exception
	 */
	public static void deleteMsgHead(String oldfilename, int headLength) throws Exception {

		File oldfile = new File(oldfilename);
		File tmpfile = new File(oldfilename + ".old");
		if (tmpfile.exists()) {
			tmpfile.delete();
		}
		tmpfile.createNewFile();
		FileInputStream fin = new FileInputStream(oldfile);
		FileOutputStream fout = new FileOutputStream(tmpfile);
		try {
			int byteData = 0;
			byte[] headbuffer = new byte[headLength];
			byte[] buffer = new byte[8192];
			fin.read(headbuffer);
			while ((byteData = fin.read(buffer)) != -1) {
				fout.write(buffer, 0, byteData);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				fout.close();
			} catch (Exception ex) {
			}
			try {
				fin.close();
			} catch (Exception ex) {
			}
		}
		oldfile.delete();
		tmpfile.renameTo(oldfile);
		// copyFile(tmpfile.getAbsolutePath(),oldfilename);

	}

	/**
	 * 增加报文头
	 * 
	 * @param oldfile
	 *            报文文件
	 * @param head
	 *            报文头
	 * @throws Exception
	 */
	public static void addMsgHead(String oldfilename, String head) throws Exception {
		File oldfile = new File(oldfilename);
		File tmpfile = new File(oldfilename + ".old");
		if (tmpfile.exists()) {
			tmpfile.delete();
		}
		tmpfile.createNewFile();
		FileInputStream fin = new FileInputStream(oldfile);
		FileOutputStream fout = new FileOutputStream(tmpfile);
		try {
			int byteData = 0;
			byte[] buffer = new byte[8192];
			fout.write(head.getBytes());
			while ((byteData = fin.read(buffer)) != -1) {
				fout.write(buffer, 0, byteData);
			}
		} catch (Exception e) {
			try {
				if (tmpfile.exists()) {
					tmpfile.delete();
				}
			} catch (Exception ex) {
			}
			throw e;
		} finally {
			fout.close();
			fin.close();
		}
		oldfile.delete();
		tmpfile.renameTo(oldfile);
	}

	/**
	 * 将'abcd','1234','ab''cd'字符串分割到Vector中，分别为'abcd'和'1234'以及'ab''cd'
	 * 
	 * @param str
	 *            要分割的字符串
	 * @param delim
	 *            分割符
	 * @return 分割后VECTOR
	 * 
	 */
	public static Vector splitOracleValue(String tmpData) {
		int start = -1;
		String columnData = "";
		Vector tableValues = new Vector();
		int delimIndex = -1;
		while ((delimIndex = tmpData.indexOf("'", start + 1)) > -1) {
			if (start == -1) {
				start = delimIndex;
				columnData = "";
				continue;
			}
			if (tmpData.indexOf("'", delimIndex + 1) == delimIndex + 1) {
				columnData += tmpData.substring(start, delimIndex + 1);
				start = delimIndex + 1;
				continue;
			}
			columnData += tmpData.substring(start, delimIndex + 1);
			start = -1;
			if (tmpData.length() > delimIndex + 1 + 1) {
				tmpData = tmpData.substring(delimIndex + 1 + 1);
			} else {
				tmpData = "";
			}

			tableValues.add(columnData);
		}
		return tableValues;
	}

	/**
	 * 将'abcd','1234','ab''cd'字符串分割到Vector中，分别为'abcd'和'1234'以及'ab''cd'
	 * 
	 * @param str
	 *            要分割的字符串
	 * @param delim
	 *            分割符
	 * @return 分割后VECTOR
	 * 
	 */
	public static Vector splitCVSValue(String tmpData) {
		int start = -1;
		String columnData = "";
		Vector tableValues = new Vector();
		int delimIndex = -1;
		while ((delimIndex = tmpData.indexOf("'", start + 1)) > -1) {
			if (start == -1) {
				start = delimIndex;
				columnData = "";
				continue;
			}
			if (tmpData.indexOf("'", delimIndex + 1) == delimIndex + 1) {
				columnData += tmpData.substring(start + 1, delimIndex);
				start = delimIndex + 1;
				continue;
			}
			columnData += tmpData.substring(start + 1, delimIndex);
			start = -1;
			if (tmpData.length() > delimIndex + 1 + 1) {
				tmpData = tmpData.substring(delimIndex + 1 + 1);
			} else {
				tmpData = "";
			}

			tableValues.add(columnData);
		}
		return tableValues;
	}

	/**
	 * 将String转换成指定格式的Oracle Data格式
	 * 
	 * @param dt
	 *            String
	 * @return String
	 */
	public static String String2Date(String dt) {
		if (dt == null) {
			return "''";
		}
		return "TO_DATE(" + dt + ",'" + ORACLE_DATE_FORMAT + "')";
	}

	/**
	 * 从source字节数组获得从偏移量startIndex开始length长度的字串
	 * 
	 * @param source
	 *            byte[]
	 * @param startIndex
	 *            int
	 * @param length
	 *            int
	 * @return String
	 */
	public static String subString(byte[] source, int startIndex, int length) {
		if (source == null || source.length < startIndex + length) {
			return "";
		}

		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			bytes[i] = source[i + startIndex];
		}
		return new String(bytes);
	}

	/**
	 * 从source字串中取出tagStart与tagEnd之间的字串
	 * 
	 * @param source
	 *            String
	 * @param tagStart
	 *            String
	 * @param tagEnd
	 *            String
	 * @return String
	 */
	public static String subString(String source, String tagStart, String tagEnd) {
		if (isEmpty(source) || isEmpty(tagStart) || isEmpty(tagEnd)) {
			return "";
		}

		int tagStartIndex = source.indexOf(tagStart);
		if (tagStartIndex < 0) {
			return "";
		}
		int tagEndIndex = source.indexOf(tagEnd, tagStartIndex + tagStart.length());
		if (tagEndIndex <= tagStartIndex) {
			return "";
		}
		return source.substring(tagStartIndex + tagStart.length(), tagEndIndex);

	}

	/**
	 * 比较字集
	 * 
	 * @param tag
	 *            byte[]
	 * @param source
	 *            byte[]
	 * @param sourceIndex
	 *            int
	 * @return boolean
	 */
	public static boolean compare(byte[] tag, byte[] source, int sourceIndex) {
		boolean returnvalue = true;

		if (tag == null || tag.length == 0) {
			return false;
		}
		if (source == null || source.length < tag.length + sourceIndex) {
			return false;
		}

		for (int i = 0; i < tag.length; i++) {
			if (tag[i] != source[i + sourceIndex]) {
				returnvalue = false;
				break;
			}
		}
		return returnvalue;
	}

	/**
	 * 将String转换成Date
	 * 
	 * @param strTime
	 *            String
	 * @param dateFormat
	 *            String
	 * @return Date
	 */
	public static Date str2Date(String strTime, String dateFormat) {
		if (strTime == null || strTime.trim().length() == 0)
			return null;
		DateFormat df = new java.text.SimpleDateFormat(dateFormat);
		Date tTime;
		try {
			tTime = df.parse(strTime);
		} catch (Exception e) {
			return null;
		}
		return tTime;
	}

	/**
	 * 从LOG文件中提取一定时间内的行
	 * 
	 * @param srcFile
	 *            String
	 * @param destFile
	 *            String
	 * @param encoding
	 *            String
	 * @param startTime
	 *            String
	 * @param endTime
	 *            String
	 */
	public static void readLogFile(String srcFile, String destFile, String encoding, String startTime, String endTime)
			throws Exception {
		InputStreamReader fr = null;
		BufferedReader br = null;
		OutputStreamWriter fw = null;
		BufferedWriter bw = null;
		String line = "";
		int timelength = 0;
		if (encoding == null || encoding.trim().length() == 0) {
			encoding = "UTF-8";
			// encoding = "GBK";
		}

		java.util.Date startDate = str2Date(startTime, SIMPLE_DATE_FORMAT);
		java.util.Date endDate = str2Date(endTime, SIMPLE_DATE_FORMAT);
		boolean readStartFlag = false;

		if (startTime == null || startTime.length() == 0) {
			if (startDate == null) {
				readStartFlag = true;
			} else {
				throw new Exception("not correct startTime.");
			}
		} else {
			timelength = startTime.length();
		}

		try {
			fr = new InputStreamReader(new FileInputStream(new File(srcFile)), encoding);
			br = new BufferedReader(fr);

			fw = new OutputStreamWriter(new FileOutputStream(new File(destFile)), encoding);
			bw = new BufferedWriter(fw);

			line = br.readLine(); // 从文件读取一行字符串
			// 判断读取到的字符串是否不为空
			while (line != null) {
				java.util.Date lineDate = str2Date(
						line.substring(0, (timelength - line.length()) > 0 ? line.length() : timelength),
						SIMPLE_DATE_FORMAT);
				if (!readStartFlag && lineDate != null && startDate.compareTo(lineDate) <= 0) {
					readStartFlag = true;
				}

				if (readStartFlag && endDate != null && lineDate != null && endDate.compareTo(lineDate) < 0) {
					break;
				}

				if (readStartFlag) {
					bw.write(line);
					bw.newLine(); // 断行
				}

				line = br.readLine(); // 从文件中继续读取一行数据
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// 关闭BufferedWriter对象
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (Exception ex1) {
			}
			// 关闭FileWriter对象
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception ex2) {
			}
			// 关闭BufferedReader对象
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception ex1) {
			}
			// 关闭FileReader对象
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception ex2) {
			}
		}
	}

	/**
	 * 读取文本文件srcFile中从第startLineNo行开始lineCount行的文本到destFile文件中
	 * 
	 * @param srcFile
	 *            String 源文件
	 * @param destFile
	 *            String 目标文件
	 * @param encoding
	 *            String 字码
	 * @param startLineNo
	 *            long 起始行号
	 * @param lineCount
	 *            long 行数
	 */
	public static void readFile(String srcFile, String destFile, String encoding, long startLineNo, long lineCount)
			throws Exception {
		InputStreamReader fr = null;
		BufferedReader br = null;
		OutputStreamWriter fw = null;
		BufferedWriter bw = null;
		long lineCursor = 0;
		if (encoding == null || encoding.trim().length() == 0) {
			encoding = "UTF-8";
			// encoding = "GBK";
		}
		try {
			if (startLineNo < 1) {
				startLineNo = 1;
			}
			fr = new InputStreamReader(new FileInputStream(new File(srcFile)), encoding);
			br = new BufferedReader(fr);

			fw = new OutputStreamWriter(new FileOutputStream(new File(destFile)), encoding);
			bw = new BufferedWriter(fw);

			String line = br.readLine(); // 从文件读取一行字符串
			lineCursor++;
			// 判断读取到的字符串是否不为空
			while (line != null) {
				if (lineCursor >= startLineNo) {
					lineCursor++;
					bw.write(line);
					bw.newLine(); // 断行
				}
				if (lineCount != 0 && lineCursor - startLineNo >= lineCount) {
					break;
				}
				line = br.readLine(); // 从文件中继续读取一行数据
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// 关闭BufferedWriter对象
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (Exception ex1) {
			}
			// 关闭FileWriter对象
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception ex2) {
			}
			// 关闭BufferedReader对象
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception ex1) {
			}
			// 关闭FileReader对象
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception ex2) {
			}
		}
	}

	public static String getStackTraceString(Throwable ex) {
		// StringWriter将包含堆栈信息
		StringWriter stringWriter = new StringWriter();
		// 必须将StringWriter封装成PrintWriter对象，
		// 以满足printStackTrace的要求
		PrintWriter printWriter = new PrintWriter(stringWriter);
		// 获取堆栈信息
		ex.printStackTrace(printWriter);
		// 转换成String，并返回该String
		StringBuffer error = stringWriter.getBuffer();
		return error.toString();
	}

	/**
	 * 判断一个字符串是否为数字
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNumeric(String str) {
		char[] carray = str.toCharArray();
		for (int i = 0; i < carray.length; i++) {
			if (!Character.isDigit(carray[i]))
				return false;
		}

		return true;
	}

	/**
	 * 从两个整数中获取比较大的那个
	 * 
	 * @param a
	 *            int
	 * @param b
	 *            int
	 * @return int
	 */
	public static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	/**
	 * 从两个整数中获取比较小的那个
	 * 
	 * @param a
	 *            int
	 * @param b
	 *            int
	 * @return int
	 */
	public static int min(int a, int b) {
		if (a < b)
			return a;
		else
			return b;
	}

	/**
	 * 将long型流水号转为字符型，流水号长度为4位，不足4位的左补0 param long seqno 长整型流水号 return String
	 * strSeqno 字符型流水号
	 */
	public static String convSeqNo2Str(long seqNo) {
		String strSeqNo = "";
		int curSeqNoLength = 0;
		int seqNoLength = 4;
		try {
			strSeqNo = String.valueOf(seqNo);
			curSeqNoLength = strSeqNo.length();

			// 不足4位流水号要右补空格
			for (int i = seqNoLength - curSeqNoLength; i > 0; i--) {
				strSeqNo = '0' + strSeqNo;
			}
		} catch (Exception ex) {
			strSeqNo = "";
		}
		return strSeqNo;
	}

	/**
	 * 写DAT文件
	 * 
	 * @param strLine
	 *            信息
	 */
	public synchronized static void writeDatFile(File datFile, String strLine, String encodeType) throws Exception {

		FileWriter fw = null;
		try {
			fw = new FileWriter(datFile);
			fw.write(new String(strLine.getBytes(encodeType)));
			fw.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				fw.close();
			} catch (Exception e) {
			}
		}
	}

	public static String formatNumber(Double num, String format) {
		String str = "0";
		if (num == null || "".equals(num))
			return str;
		str = Common.formatNumber(num.doubleValue(), format);
		if (str != null && !"".equals(str))
			str = Common.replace(str, ",", "");
		else
			str = "0";
		return str;
	}

	public static double str2double(String str) {
		try {
			if (str == null || "".equals(str))
				return 0;
			else
				return Double.valueOf(str).doubleValue();
		} catch (Exception e) {
			return 0;
		}
	}

	public static Double str2Double(String str) {
		try {
			if (str == null || "".equals(str))
				return null;
			else
				return Double.valueOf(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static Long str2Long(String str) {
		try {
			if (str == null || "".equals(str))
				return null;
			else
				return Long.valueOf(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static long str2long(String str) {
		try {
			if (str == null || "".equals(str))
				return 0;
			else
				return Long.valueOf(str).longValue();
		} catch (Exception e) {
			return 0;
		}
	}

	public static String getLimitLengthString(String str, int len) {
		try {
			int counterOfDoubleByte = 0;
			byte[] b = str.getBytes("gb2312");
			if (b.length <= len)
				return str;
			for (int i = 0; i < len; i++) {
				if (b[i] < 0)
					counterOfDoubleByte++;
			}
			if (counterOfDoubleByte % 2 == 0)
				return new String(b, 0, len, "gb2312");
			else
				return new String(b, 0, len - 1, "gb2312");
		} catch (Exception ex) {
			return "";
		}
	}

	public static String getLimitLengthStringByOralce(String str, int len) {
		try {
			int num = 0;
			for (int i = 0; i < str.length(); i++) {
				String s = str.substring(i, i + 1);
				if (s.getBytes().length == 2) {
					num += 3;
				} else {
					num++;
				}
				if (num > len) {
					return str.substring(0, i);
				}
			}
			return str;
		} catch (Exception ex) {
			return "";
		}
	}

	public static String replaceMessageValue(String strSource) {
		if (isEmpty(strSource)) {
			return "";
		}
		String str = strSource;
		str = replace(str, "?", "??");
		str = replace(str, ":", "?:");
		str = replace(str, "'", "?'");
		return str;
	}

	public static String getTrimStr(String str) {
		try {
			if (str == null || "".equals(str) || "null".equals(str))
				return "";
			return str.trim();
		} catch (Exception e) {
			return str;
		}
	}

	public static String objectToString(Object obj) {
		try {
			if (obj == null)
				return "";
			return obj.toString();
		} catch (Exception e) {
			return "";
		}
	}

	/*
	 * 测试用
	 */
//	public static void main(String[] args) throws Exception {
//
//		try {
//			// double a = Common.floor(0.3339, 3);
//			String str = "fd的房的&（(）待爾发送^^间333地方 地方";
//			int len = 17;
//			System.err.println(Common.getLimitLengthStringByOralce(str, len) + "::");
//		} catch (Exception ex) {
//			//
//		}
//	}

	/**
	 * 获取字符串占的字节数(一个全角字符占三个, 极少数汉字占两个或四个,且是在utf8下，gbk下一般占2个)
	 * 
	 * @param str
	 * @return
	 */
	public static int countStringLength(String str) {
		int length = 0;
		try {
			if (str == null) {
				return length;
			}
			length = str.getBytes("utf8").length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return length;
	}

	/**
	 * 统一验证方法( 包括非空校验、字符格式校验、长度校验 )
	 * 
	 * @param infoType
	 *            数据类型
	 * @param validateInfo
	 *            待验证数据
	 * @param validateFormat
	 *            使用的验证格式
	 * @param isRequired
	 *            是否必填；true：必填
	 * @param maxLength
	 *            字符串最大长度
	 * @param errorTarget
	 *            错误提示的对象；例如：箱号
	 * @return
	 */
	public static String validateTool(String infoType, String validateInfo, String validateFormat, boolean isRequired,
			double maxLength, String errorTarget) {
		try {
			Pattern p = null;
			Matcher m = null;
			boolean b = false;
			StringBuffer error = new StringBuffer();
			String info = validateInfo;
			Double d = null;
			Long l = null;

			// 非空校验(如果需要的话)
			if (isRequired) {
				if (StringUtils.isEmpty(info)) {
					error.append(errorTarget + "不能为空\n");
					return error.toString();
				}
			}

			if (info != null && !StringUtils.isEmpty(info)) {
				if (maxLength > 0) {
					// 数据格式校验
					if (!StringUtils.isEmpty(validateFormat)) {
						p = Pattern.compile(validateFormat);
						m = p.matcher(info);
						b = m.matches();
						if (!b) {
							error.append(errorTarget + "格式不正确\n");
							return error.toString();
						}
					}
					// 长度校验(数字长度是指数字的大小)
					if ("String".equals(infoType)) {
						if (info.getBytes("utf8").length > maxLength)
							error.append(errorTarget + "长度超过" + (long) maxLength + "\n");
					} else if ("Double".equals(infoType)) {
						d = Double.valueOf(info);
						if (d > maxLength)
							error.append(errorTarget + "长度超过" + formatNumber(maxLength, "") + "\n");
					} else if ("Long".equals(infoType)) {
						l = Long.valueOf(info);
						if (l > maxLength)
							error.append(errorTarget + "长度超过" + formatNumber(maxLength, "") + "\n");
					}
				}
			}
			return error.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * clob转为string
	 * 
	 * @param clobField
	 * @return
	 */
	public static String clob2String(Clob clobField) {
		String clobText = "";
		Reader reader = null;
		if (clobField == null) {
			return "";
		}

		try {
			int len = (int) clobField.length();
			if (len == 0) {
				return "";
			}
			char[] buff = new char[len];
			reader = clobField.getCharacterStream();
			int rdchars = reader.read(buff);
			if (rdchars != len) {
				throw new RuntimeException("Read clob field content error. Total length is " + len
						+ ", but read text length is " + rdchars);
			}
			clobText = String.valueOf(buff);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
				}
		}
		return clobText;
	}

	/**
	 * 获取当前登录用户的IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 比较日期之差 , 不计算时间只计算 日期;
	 * 
	 * @param d1
	 *            日期1
	 * @param d2
	 *            日期2
	 * @return 返回数字 为 : d2 - d1 例如: d1:20140102 d2:20140101 return: -1
	 */
	public static int getDateDiff(Date d1, Date d2) {
		try {
			d1 = SDF_PATTERN_SHORT1.parse(SDF_PATTERN_SHORT1.format(d1));
			d2 = SDF_PATTERN_SHORT1.parse(SDF_PATTERN_SHORT1.format(d2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateTime dt1 = new DateTime(d1.getTime());
		DateTime dt2 = new DateTime(d2.getTime());
		Days d = Days.daysBetween(dt1, dt2);
		return d.getDays();
	}

	/**
	 * 获取相邻的月份
	 * 
	 * @param dt
	 *            当前月的日期
	 * @param num
	 *            月份加减 -1上个月, + 下个月
	 * @return
	 */
	public static Date getAdjacentMonth(Date dt, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + num);
		Date finDateLast = calendar.getTime();
		return finDateLast;
	}

	// Parameter Like参数+引号
	public static String ConvertLikeParamer(String likeParameter) {

		return "%" + likeParameter + "%";
	}

	// Ajax 返回方法
	public static Map AjaxMessage(String message, Boolean result) {
		Map mapresult = new HashMap();

		mapresult.put("result", result);
		mapresult.put("returnMessage", message);
		return mapresult;
	}

	public static Double object2Double(Object obj){
		if(obj==null || "".equals(obj)) return null;
		return new BigDecimal(String.valueOf(obj)).doubleValue();
	}
	
	public static Integer object2Integer(Object obj){
		if(obj==null || "".equals(obj)) return null;
		try {
			return Integer.valueOf(String.valueOf(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Long object2Long(Object obj){
		if(obj==null || "".equals(obj)) return null;
		try {
			return Long.valueOf(String.valueOf(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BigDecimal object2BigDecimal(Object obj){
		if(obj==null || "".equals(obj)) return null;
		return new BigDecimal(String.valueOf(obj));
	}
	
	public static BigDecimal string2BigDecinal(String value){
		if(isEmpty(value)){
			return null;
		}
		try {
			return new BigDecimal(DecimalFormat.getInstance().parse(value).toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Long[] string2LongList(String param){
		if(isEmpty(param)) return null;
		String[] paramList = param.split(",");
		if(paramList==null || paramList.length==0) return null;
		Long[] result = new Long[paramList.length];
		for (int i = 0; i < paramList.length; i++) {
			result[i] = Long.valueOf(paramList[i]);
		}
		return result;
	}
	
	public static Boolean validateByReg(Object value, String reg){
		if(isEmpty(value)){
			return Boolean.FALSE;
		}
		return Pattern.compile(reg).matcher(value.toString()).matches();
	}
	
	public static Boolean existsGroupConcat(String parent, String child){
		if(isEmpty(parent) || isEmpty(child)){
			return Boolean.FALSE;
		}
		int index = parent.indexOf(",");
		if(index!=-1){
			if(parent.startsWith(child + ",") || parent.endsWith("," + child)){
				return Boolean.TRUE;
			}else if(parent.indexOf("," + child + ",")!=-1){
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}else if(parent.equals(child)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	 public static void main(String args[]){
//    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
//    	Calendar cal = Calendar.getInstance();
//        int day = cal.get(Calendar.DATE);
//        int month = cal.get(Calendar.MONTH) + 1;
//         System.out.println(month);
//         
//         GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
//         Date date=new Date();
// 		gc.setTime(date);
// 		gc.add(Calendar.MONTH, -1);
// 		System.out.println(sdf.format(gc.getTime()));
// 		String idcard="420626199309013017";//310109xxxxxxxx0018
// 		System.out.println(idcard.replace(idcard.substring(6,14), "xxxxxxxx"));
// 		String idcard15="130503670401001";
// 		System.out.println(idcard15.replace(idcard15.substring(6,12), "xxxxxx"));
// 		String mobile="13811431906";
// 		System.out.println(mobile.replace(mobile.substring(3,8), "xxxx"));
 		
    /*	String path=System.getProperty("user.dir");
    	String p=System.getProperty("user.dir")+"\\uploadFile\\hello2.txt";
    	System.out.println("path="+p);
 		try {
			FileUtil.newFile(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
 		
 		 
 		Map<String,String> map = new HashMap<String,String>();
 		System.out.println(map.get("hh"));
 		System.out.println((String)map.get("hh"));
 		
 		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
 		try {
			System.out.println(sdf.format(sdf.parse("2016-01-26")));
		} catch (ParseException e) {
		 
			e.printStackTrace();
		}
 		
		
		
    }
	 /**
	  * 获得项目根目录下指定目录的路径
	  * @param request
	  * @param folder//文件夹名称
	  * @return
	  */
	 public static String  getPath(HttpServletRequest request,String folder){
		 String realPath=request.getSession().getServletContext().getRealPath(folder)+"\\";//文件上传目录
		 return realPath;
	 }
	 
	 public static Date getConvertDateByString(String date){
		 	Date dates=null;
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	 		try {
	 			dates=  sdf.parse("2016-01-26");//会转成日期特有的格式，可以用format转回来
	 			//System.out.println(sdf.format(sdf.parse("2016-01-26")));//格式化后的
			} catch (ParseException e) {
			 
				e.printStackTrace();
			}
	 		return dates;
	 }
	
}