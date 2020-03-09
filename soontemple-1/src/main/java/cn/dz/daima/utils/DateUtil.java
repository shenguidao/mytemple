package cn.dz.daima.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

	/**
	 * 
	 * get current date(Timestamp) time for sql update/insert
	 * 
	 * @return
	 */
	public static Timestamp getCurrentDateTime() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 *
	 * get current date(date) time for sql update/insert
	 *
	 * @return
	 */
	public static java.sql.Date getCurrentDate() {
		return new java.sql.Date(new Date().getTime());
	}

	/**
	 *
	 * get current date(date) time for sql update/insert
	 *
	 * @return
	 */
	public static Calendar getCurrentCalendar() {
		return Calendar.getInstance();
	}

	/**
	 *
	 * get date(Timestamp) string
	 *
	 * @return
	 */
	public static String formateDate(Timestamp date, String pattern) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	public static String formateDate(Object obj, String pattern) {
		if (obj == null)
			return "";

		if (obj instanceof String) {
			return String.format(pattern, obj);
		}

		if (obj instanceof java.sql.Date) {
			return formateDate((java.sql.Date) obj, pattern);
		}

		if (obj instanceof Calendar) {
			return com.offtake.common.util.DateUtil.formateDate((Calendar) obj, pattern);
		}

		if (obj instanceof Timestamp) {
			return com.offtake.common.util.DateUtil.formateDate((Timestamp) obj, pattern);
		}

		if (obj instanceof Date) {
			return com.offtake.common.util.DateUtil.formateDate((Date) obj, pattern);
		}

		return "";
	}
	public static Timestamp ConvertObjToTimestamp(Object obj) {
		if (obj == null)
			return null;
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return formateDate(pattern,formateDate(obj,pattern));
	}
	/**
	 *
	 * get date(Date) string
	 *
	 * @return
	 */
	public static String formateDate(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * get sql.date from object
	 */
	public static java.sql.Date formateDate(Object odate) {
		if (odate instanceof Timestamp) {
			Timestamp to = (Timestamp) odate;
			return new java.sql.Date(to.getTime());
		}

		if (odate instanceof java.sql.Date) {
			return (java.sql.Date) odate;
		}

		if (odate instanceof Date) {
			Date to = (Date) odate;
			return new java.sql.Date(to.getTime());
		}
		if (odate instanceof Calendar) {
			Calendar t = (Calendar) odate;
			Date d = t.getTime();
			return new java.sql.Date(d.getTime());
		}
		return null;
	}

	/**
	 *
	 * get date(Calendar) string
	 *
	 * @return
	 */
	public static String formateDate(Calendar date, String pattern) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date.getTime());
	}

	/**
	 *
	 * get date(java.sql.Date) string
	 *
	 * @return
	 */
	public static String formateDate(java.sql.Date date, String pattern) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 *
	 * get date(Timestamp)
	 *
	 * @return
	 */
	public static Timestamp formateDate(String formate, String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}

		DateFormat dateFormat = new SimpleDateFormat(formate, Locale.ENGLISH);
		dateFormat.setLenient(false);
		Date timeDate = null;
		try {
			timeDate = dateFormat.parse(value.toString());
			Timestamp dateTime = new Timestamp(timeDate.getTime());
			return dateTime;
		} catch (ParseException e) {
		}
		return null;

	}

	/**
	 *
	 * get date(Timestamp)
	 *
	 * @return
	 */
	public static String formateDateStr(String pattern, String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}

		DateFormat dateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
		try {
			Date date = dateFormat.parse(value.toString());
			return formateDate(date, pattern);

		} catch (ParseException e) {
		}

		return null;
	}

	/**
	 *
	 * get date(Sql Date)
	 *
	 * @return
	 */
	public static java.sql.Date formateDate(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",
				Locale.ENGLISH);
		dateFormat.setLenient(false);
		java.sql.Date timeDate = null;
		try {
			Date date = dateFormat.parse(value.toString());
			timeDate = new java.sql.Date(date.getTime());
			return timeDate;
		} catch (ParseException e) {
		}
		return null;

	}

	public static Calendar getCalendar(Date excuteDate) {
		Calendar date = Calendar.getInstance();
		date.setTime(excuteDate);

		return date;
	}

	public static List<Calendar> getDateList(Date excuteDate) {
		List<Calendar> dateList = new ArrayList<Calendar>();

		Calendar exeCal = Calendar.getInstance();
		exeCal.setTime(excuteDate);

		int dayOfWeek = exeCal.get(Calendar.DAY_OF_WEEK);
		Calendar startCal = Calendar.getInstance();

		Date startDate = DateUtils.addDays(exeCal.getTime(), -dayOfWeek + 1);
		startCal.setTime(startDate);
		startCal.add(Calendar.WEEK_OF_YEAR, -2);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(startDate);
		endCal.add(Calendar.WEEK_OF_YEAR, 3);

		while (!DateUtils.isSameDay(startCal, endCal)) {
			Calendar indexCal = Calendar.getInstance();
			indexCal.setTime(startCal.getTime());
			dateList.add(indexCal);
			startCal.add(Calendar.DAY_OF_MONTH, 1);
		}
		return dateList;
	}

	public static List<Date> getAllTheDateOftheMonth(Date date) {
		List<Date> list = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);

		int month = cal.get(Calendar.MONTH);
		while (cal.get(Calendar.MONTH) == month) {
			Date tempdate = new Date(cal.getTime().getTime());
			list.add(tempdate);
			cal.add(Calendar.DATE, 1);
		}
		return list;
	}

	public static List<Calendar> getCurrentWeelList(Date excuteDate) {
		List<Calendar> dateList = new ArrayList<Calendar>();

		Calendar exeCal = Calendar.getInstance();
		exeCal.setTime(excuteDate);

		int dayOfWeek = exeCal.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek==1)//周日的 特殊处理
			return getCurrentWeelList(addDay(excuteDate, -1));
		Calendar startCal = Calendar.getInstance();

		Date startDate = DateUtils.addDays(exeCal.getTime(), -dayOfWeek + 2);
		startCal.setTime(startDate);

		for (int i = 0; i < 7; i++) {
			Calendar date = Calendar.getInstance();
			date.setTime(startCal.getTime());
			dateList.add(date);
			startCal.add(Calendar.DAY_OF_MONTH, 1);
		}
		return dateList;
	}
	 public static int getDifferDays(Date begin, Date end) {
	        return (int) ((end.getTime() - begin.getTime()) / (24 * 60 * 60 * 1000));
	  }
	 public static int getDifferHours(Date begin, Date end) {
	        return (int) ((end.getTime() - begin.getTime()) / ( 60 * 60 * 1000));
	  }
	 public static int getDifferMinutes(Date begin, Date end) {
		 	if(begin==null || end==null)
		 		return 0;
	        return (int) ((end.getTime() - begin.getTime()) / ( 60 * 1000));
	  }
	 public   static   java.sql.Date   addMonth(Date   date,int   amount){
         GregorianCalendar   calendar=new   GregorianCalendar();
         calendar.setTime(date);
         calendar.add(Calendar.MONTH,amount);
         return   new   java.sql.Date(calendar.getTime().getTime());
     }
	 public   static   java.sql.Date   addDay(Date   date,int   amount){
         GregorianCalendar   calendar=new   GregorianCalendar();
         calendar.setTime(date);
         calendar.add(Calendar.DAY_OF_MONTH,amount);
         return   new   java.sql.Date(calendar.getTime().getTime());
     }
	 public   static   java.sql.Date   addHour(Date   date,int   amount){
         GregorianCalendar   calendar=new   GregorianCalendar();
         calendar.setTime(date);
         calendar.add(Calendar.HOUR_OF_DAY,amount);
         return   new   java.sql.Date(calendar.getTime().getTime());
     }
	 public   static   java.sql.Date   addMintue(Date   date,int   amount){
         GregorianCalendar   calendar=new   GregorianCalendar(); 
         calendar.setTime(date); 
         calendar.add(Calendar.MINUTE,amount); 
         return   new   java.sql.Date(calendar.getTime().getTime()); 
     }
	
	 //时间加上N天
	 public static String getdatePlus(Date date,int N){
		 DateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd");  
		 Calendar c = Calendar.getInstance();  
	        c.setTime(date);   //设置起始日期  
	        c.add(Calendar.DATE,N); //日期加i天                
		 return df.format(c.getTime());
	 }
	 
	 //String转date
	 public static Date getdate(String dates) throws ParseException{
	 SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
	  Date date = sdf.parse(dates);
	  return date;  
	 }
	 
	 //date转string
	 public static String getStringdate(Date date){
		 DateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd");  
		 Calendar c = Calendar.getInstance();  
	     c.setTime(date); 
		 return df.format(c.getTime());
	 }
}











