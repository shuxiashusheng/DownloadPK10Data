import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/*
 * 日期处理类
 */
public class DateHandler {
	public static void main(String[] args){
		nextDayString("20150503");
		//当前时间
		Calendar cl = setCalendar(2014,01,01);
		System.out.println("当前时间:"+cl.getTime().toString());
		System.out.println(dateToString( cl.getTime()));
		printCalendar(cl);
		//前一天
		cl = setCalendar(2014,01,01);
		getBeforeDay(cl);
		System.out.print("前一天:");
		printCalendar(cl);
		//后一天
		cl = setCalendar(2014,01,01);
		getAfterDay(cl);
		System.out.print("后一天:");
		printCalendar(cl);
	}
	
	/**
	 * 设置时间
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public static Calendar setCalendar(int year,int month,int date){
		Calendar cl = Calendar.getInstance();
		cl.set(year, month-1, date);
		return cl;
	}
	
	/**
	 * 获取当前时间的前一天时间
	 * @param cl
	 * @return
	 */
	private static Calendar getBeforeDay(Calendar cl){
		//使用roll方法进行向前回滚
		//cl.roll(Calendar.DATE, -1);
		//使用set方法直接进行设置
		int day = cl.get(Calendar.DATE);
		cl.set(Calendar.DATE, day-1);
		return cl;
	}
	
	/**
	 * 获取当前时间的后一天时间
	 * @param cl
	 * @return
	 */
	private static Calendar getAfterDay(Calendar cl){
		//使用roll方法进行回滚到后一天的时间
		//cl.roll(Calendar.DATE, 1);
		//使用set方法直接设置时间值
		int day = cl.get(Calendar.DATE);
		cl.set(Calendar.DATE, day+1);
		return cl;
	}
	
	/**
	 * 打印时间
	 * @param cl
	 */
	public static void printCalendar(Calendar cl){
		int year = cl.get(Calendar.YEAR);
		int month = cl.get(Calendar.MONTH)+1;
		int day = cl.get(Calendar.DATE);
		System.out.println(year+"-"+month+"-"+day);
	}
	
	/**
	 * 将日期转换为合适的格式yyyyMMdd
	 * @param time
	 */
	public static String dateToString(Date time){ 
	    SimpleDateFormat formatter; 
	    formatter = new SimpleDateFormat ("yyyyMMdd"); 
	    String ctime = formatter.format(time); 
	    return ctime; 
	}
	
	/**
	 * 将日期转换为合适的格式format
	 * @param time
	 */
	public static String dateToStringWithFormat(Date time,String format){ 
	    SimpleDateFormat formatter; 
	    formatter = new SimpleDateFormat (format); 
	    String ctime = formatter.format(time); 
	    return ctime; 
	}
	/**
	* 字符串转换成日期
	* @param str
	* @return date
	*/
	public static Date StrToDate(String str) {
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	   Date date = null;
	   try {
	    date = format.parse(str);
	   } catch (ParseException e) {
	    e.printStackTrace();
	   }
	   return date;
	}
	
	/**
	* 根据原来字符串格式转换成日期 
	* @param str
	* @return date
	*/
	public static Date StrToDateWithFormat(String str,String orignFormat) {
	  
	   SimpleDateFormat format = new SimpleDateFormat(orignFormat);
	   Date date = null;
	   try {
	    date = format.parse(str);
	   } catch (ParseException e) {
	    e.printStackTrace();
	   }
	   return date;
	}
	/**
	 * 将日期转换从一种转换为另一种格式
	 * @param time
	 */
	public static String dateFormatToAnother(String dateFomatOne,String dateFormatAnother){ 
		Date date = DateHandler.StrToDate(dateFomatOne);
	   String dateString = DateHandler.dateToStringWithFormat(date, dateFormatAnother) ;
	    return dateString; 
	}
	/**
	 * 将日期转换从一种转换为另一种格式
	 * @param time
	 */
	public static String dateFormatByOneToAnother(String dateStr,String orignFormat, String dateFormatAnother){ 
		Date date = DateHandler.StrToDateWithFormat(dateStr, orignFormat);
	   String dateString = DateHandler.dateToStringWithFormat(date, dateFormatAnother) ;
	    return dateString; 
	}
	//  获取后一天的时间
	public static String nextDayString(String dateString) {
		Date date = StrToDate(dateString);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar = getAfterDay(calendar);
		System.out.println(dateToString( calendar.getTime()));
		return dateToString( calendar.getTime());
	}

}
