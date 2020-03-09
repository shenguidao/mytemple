package cn.dz.daima.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;


public class CommonBaseUtils {

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
	 * 获取访问用户的客户端IP（适用于公网与局域网）.
	 */
	public static String getIpAddr(HttpServletRequest request)
	        throws Exception {
	    if (request == null) {
	        throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
	    }
	    String ipString = request.getHeader("x-forwarded-for");
	    if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
	        ipString = request.getHeader("Proxy-Client-IP");
	    }
	    if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
	        ipString = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
	        ipString = request.getRemoteAddr();
	    }
	 
	    // 多个路由时，取第一个非unknown的ip
	    final String[] arr = ipString.split(",");
	    for (final String str : arr) {
	        if (!"unknown".equalsIgnoreCase(str)) {
	            ipString = str;
	            break;
	        }
	    }
	 
	    return ipString;
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
	 * 获得 visit_date
	 * @param date 日期
	 * @return visit_date
	 */
	public static String getToday(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar now = Calendar.getInstance();
        if (now.get(Calendar.HOUR_OF_DAY) < 2)
            now.add(Calendar.DAY_OF_MONTH, -1);
        Date date = new java.sql.Date(now.getTimeInMillis());
        return dateFormat.format(date);
	}
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
	
	public static void main(String[] args) {
		Date todayDate = DateUtil.getCurrentDate();
        Calendar cale = Calendar.getInstance();
        cale.setTime(todayDate);
        
        cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 1);
        String thisMonthFirstDay = DateUtil.formateDate(cale.getTime(), "yyyy-MM-01");
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 4);
        String thisMonthFourthDay = DateUtil.formateDate(cale.getTime(), "yyyy-MM-04");
        
        int thisYear = cale.get(Calendar.YEAR);
        int thisMonth = cale.get(Calendar.MONTH) + 1;
        
        cale.setTime(todayDate);
        cale.add(Calendar.MONTH, -1);
        //本月月份
        int previousMonth = cale.get(Calendar.MONTH) + 1;
        
        //盒装近效期
        List<Date> boxDateList = DateUtil.getAllTheDateOftheMonth(DateUtil.addMonth(todayDate, 11));
        String boxDate = DateUtil.formateDate(boxDateList.get(boxDateList.size() - 1), "yyyy年M月d日");
        //罐装近效期
        List<Date> jarDateList = DateUtil.getAllTheDateOftheMonth(DateUtil.addMonth(todayDate, 15));
        String jarDate = DateUtil.formateDate(jarDateList.get(jarDateList.size() - 1), "yyyy年M月d日");
        String aString = "-1";
        System.out.println(Integer.parseInt(aString));
		System.out.println("thisMonthFirstDay"+thisMonthFirstDay);
		System.out.println("thisMonthFourthDay"+thisMonthFourthDay);
		System.out.println("thisYear"+thisYear);
		System.out.println("thisMonth"+thisMonth);
		System.out.println("previousMonth"+previousMonth);
		System.out.println("boxDate"+boxDate);
		System.out.println("jarDate"+jarDate);
	}

}
