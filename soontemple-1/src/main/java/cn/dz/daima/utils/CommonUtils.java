package cn.dz.daima.utils;

import com.offtake.common.util.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonUtils {
	private static String string = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";   

	public final static Date formatCurrentDateAddOneDay(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = dateFormat.parse(dateFormat.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	/**
	 * 获取特定日期减去一天的日期
	 * @author Tino
	 * @createDate 2018-08-11
	 * @param date 特定日期
	 * @return 减去一天后的日期
	 */
	public final static Date formatCurrentDateSubOneDay(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = dateFormat.parse(dateFormat.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * 判断值为null或者空,返回值为null
	 * */
	public static String isNumber(Object obj) {
		if (obj != null && obj != "") {
			if (!StringUtils.isBlank(obj.toString())) {
				return obj.toString();
			} else {
				return null;
			}
		}
		return obj == null || obj == "0" ? null : obj.toString();
	}
	/**
	 * 判断值为null或者空,返回值为null
	 * @param obj
	 * @return null
	 */
	public static String isNull(Object obj) {
		return obj == null || StringUtils.isBlank(obj.toString()) ? null : obj.toString();
	}
	
	/**
	 * 判断值为null或者空,返回值为null
	 * @param obj
	 * @return ""
	 */
	public static String isNull1(Object obj) {
		return obj == null || StringUtils.isBlank(obj.toString()) ? "" : obj.toString();
	}
	
	/**
	 * 
	 * 判断值为null或者空,返回值为 默认值moren
	 * */
	public static String isNumber1(Object obj,String moren) {
		if (obj != null && obj != "") {
			if (!StringUtils.isBlank(obj.toString())) {
				return obj.toString();
			} else {
				return moren;
			}
		}
		return obj == null || obj == "" ? moren : obj.toString();
	}
	/**
	 * 
	 * 判断值是正数，则加上“+”,如果传入参数为空 返回空字符串
	 * */
	public static String addPositiveSign(Object obj) {
		if (obj != null && obj != "") {
			if (!StringUtils.isBlank(obj.toString())) {
				String resultString = "";
				if (Integer.parseInt(obj.toString()) > 0) {
					resultString = "+"+obj.toString();
				} else {
					resultString = obj.toString();
				}
				return resultString;
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
	/**
	 * 
	 * 判断值为null或者空,返回值为 默认值moren
	 * */
	public static String getErrorInfo(Exception e) {
		StringBuffer stringBuffer = new StringBuffer(e.toString() + "\n");  
        StackTraceElement[] messages = e.getStackTrace();  
        int length = messages.length;  
        for (int i = 0; i < length; i++) {  
            stringBuffer.append("\t"+messages[i].toString()+"\n");  
        }  
		return stringBuffer.toString();
	}
	
	/**
	 * 获得某天所在月份剩余天数
	 * @param date 日期
	 * @return 剩余天数（包含当天）
	 */
	public static int getDayCountAfterOneDay(Date date){
		//DateUtil.getDateList(excuteDate)
		List<Date> thisMonthDate = DateUtil.getAllTheDateOftheMonth(DateUtil.getCurrentDate());
		Date endTime = thisMonthDate.get(thisMonthDate.size()-1);
		return DateUtil.getDifferDays(date, endTime) + 1;
	}
	/**
	 * 获得某天所在最后一天
	 * @param date 日期
	 * @return 某月最后一天
	 */
	public static Date getLastDayByOneDay(Date date){
		//DateUtil.getDateList(excuteDate)
		List<Date> thisMonthDate = DateUtil.getAllTheDateOftheMonth(DateUtil.getCurrentDate());
		Date endTime = thisMonthDate.get(thisMonthDate.size()-1);
		return endTime;
	}
	/**
	 * 获得 visit_date
	 * @param date 日期
	 * @return visit_date
	 */
	public static Date getVisit_Date(){
		Calendar now = Calendar.getInstance();
        if (now.get(Calendar.HOUR_OF_DAY) < 2)
            now.add(Calendar.DAY_OF_MONTH, -1);
        Date date = new java.sql.Date(now.getTimeInMillis());
        return date;
	}
	
	/**
	 * 获得两日期间间隔天数
	 * @param date1 开始日期
	 * 		  date2 结束日期
	 * @return 剩余天数（包含当天）
	 */
	public static int getDayCountForTwoDays(Date date1,Date date2){
		//DateUtil.getDateList(excuteDate)
		List<Date> thisMonthDate = DateUtil.getAllTheDateOftheMonth(DateUtil.getCurrentDate());
		Date endTime = thisMonthDate.get(thisMonthDate.size()-1);
		return DateUtil.getDifferDays(date1, date2) + 1;
	}
	
	public static int objectToInteger(Object num){
		if (num==null) {
			return 0;
		}
		if (num instanceof Number) {
			return Integer.valueOf(num.toString());
		}else {
			return 0;
		}
	}
	
	public static int getRandom(int count){
		return (int)Math.round(Math.random()*count);
	}
	
	/**
	 * 获取随机字符
	 * @param length 字符长度
	 * @return
	 */
	private static String getRandomString(int length){
	    StringBuffer sb = new StringBuffer();
	    int len = string.length();
	    for (int i = 0; i < length; i++) {
	        sb.append(string.charAt(getRandom(len-1)));
	    }
	    return sb.toString();
	}
	
	/**
	 * 不为空则在两遍添加单引号
	 * @param str 
	 * @return str
	 */
	public static String addSingleQuotationMark(String str){
		if (!StringUtils.isBlank(str)) {
			str = "'" + str.replaceAll("'", "") + "'";
		}
		return str;
	}
	
	/**
	 * MD5加密
	 * @author Tino
	 * @createDate 2018-12-26
	 * @param sourceStr
	 * @return
	 */
	public static String MD5Hash(String sourceStr){
		String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            //result = buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
	/**
	 * 字符串转ASCII
	 * @author Tino
	 * @createDate 2019-01-02
	 * @param value 字符串
	 * @return ASCII码
	 */
	public static String stringToAscii(String value){
		StringBuffer sbu = new StringBuffer();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(i != chars.length - 1){
				sbu.append((int)chars[i]).append(",");
			} else {
				sbu.append((int)chars[i]);
			}
		}
		return sbu.toString();
	}
	/**
	 * ASCII转字符串
	 * @author Tino
	 * @createDate 2019-01-02
	 * @param value ASCII
	 * @return 字符串
	 */
	public static String asciiToString(String value){
		if(value == null || "".equals(value))
			return "";
		else {
			StringBuffer sbu = new StringBuffer();
			String[] chars = value.split(",");
			for (int i = 0; i < chars.length; i++) {
				sbu.append((char) Integer.parseInt(chars[i]));
			}
			return sbu.toString();
		}
	}
	/**
	 * 字符串转Unicode
	 * @author Tino
	 * @createDate 2019-01-02
	 * @param value 字符串
	 * @return Unicode
	 */
	public static String stringToUnicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }
	/**
	 * Unicode转字符串
	 * @author Tino
	 * @createDate 2019-01-02
	 * @param value Unicode
	 * @return 字符串
	 */
	public static String unicodeToString(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }
	/**
	 * 判断值不为空
	 * @author Tino
	 * @createDate 2019-01-10
	 * @param obj
	 * @return ""
	 */
	public static boolean isNotEmpty(Object obj) {
		return !StringUtils.isBlank(isNull(obj));
	}
	
	/**
	 * 日期转换字符换
	 * @author Tino
	 * @since 2019-01-23
	 * @param date
	 * @return 字符串 yyyy-MM-dd HH:mm:ss
	 */
	public static String dateToStringForYMSHMS(Date date) {
		SimpleDateFormat sdf_ymdhs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf_ymdhs.format(date);
	}
	/**
	 * 字符换转换日期
	 * @author Tino
	 * @since 2019-01-23
	 * @param date
	 * @return 日期 yyyy-MM-dd HH:mm:ss
	 */
	public static Date stringToDateForYMSHMS(String date) {
		SimpleDateFormat sdf_ymdhs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf_ymdhs.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	
	
	public static void main(String[] args) {
		
	}
}
