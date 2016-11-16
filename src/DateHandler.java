import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/*
 * ���ڴ�����
 */
public class DateHandler {
	public static void main(String[] args){
		nextDayString("20150503");
		//��ǰʱ��
		Calendar cl = setCalendar(2014,01,01);
		System.out.println("��ǰʱ��:"+cl.getTime().toString());
		System.out.println(dateToString( cl.getTime()));
		printCalendar(cl);
		//ǰһ��
		cl = setCalendar(2014,01,01);
		getBeforeDay(cl);
		System.out.print("ǰһ��:");
		printCalendar(cl);
		//��һ��
		cl = setCalendar(2014,01,01);
		getAfterDay(cl);
		System.out.print("��һ��:");
		printCalendar(cl);
	}
	
	/**
	 * ����ʱ��
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
	 * ��ȡ��ǰʱ���ǰһ��ʱ��
	 * @param cl
	 * @return
	 */
	private static Calendar getBeforeDay(Calendar cl){
		//ʹ��roll����������ǰ�ع�
		//cl.roll(Calendar.DATE, -1);
		//ʹ��set����ֱ�ӽ�������
		int day = cl.get(Calendar.DATE);
		cl.set(Calendar.DATE, day-1);
		return cl;
	}
	
	/**
	 * ��ȡ��ǰʱ��ĺ�һ��ʱ��
	 * @param cl
	 * @return
	 */
	private static Calendar getAfterDay(Calendar cl){
		//ʹ��roll�������лع�����һ���ʱ��
		//cl.roll(Calendar.DATE, 1);
		//ʹ��set����ֱ������ʱ��ֵ
		int day = cl.get(Calendar.DATE);
		cl.set(Calendar.DATE, day+1);
		return cl;
	}
	
	/**
	 * ��ӡʱ��
	 * @param cl
	 */
	public static void printCalendar(Calendar cl){
		int year = cl.get(Calendar.YEAR);
		int month = cl.get(Calendar.MONTH)+1;
		int day = cl.get(Calendar.DATE);
		System.out.println(year+"-"+month+"-"+day);
	}
	
	/**
	 * ������ת��Ϊ���ʵĸ�ʽyyyyMMdd
	 * @param time
	 */
	public static String dateToString(Date time){ 
	    SimpleDateFormat formatter; 
	    formatter = new SimpleDateFormat ("yyyyMMdd"); 
	    String ctime = formatter.format(time); 
	    return ctime; 
	}
	
	/**
	 * ������ת��Ϊ���ʵĸ�ʽformat
	 * @param time
	 */
	public static String dateToStringWithFormat(Date time,String format){ 
	    SimpleDateFormat formatter; 
	    formatter = new SimpleDateFormat (format); 
	    String ctime = formatter.format(time); 
	    return ctime; 
	}
	/**
	* �ַ���ת��������
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
	* ����ԭ���ַ�����ʽת�������� 
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
	 * ������ת����һ��ת��Ϊ��һ�ָ�ʽ
	 * @param time
	 */
	public static String dateFormatToAnother(String dateFomatOne,String dateFormatAnother){ 
		Date date = DateHandler.StrToDate(dateFomatOne);
	   String dateString = DateHandler.dateToStringWithFormat(date, dateFormatAnother) ;
	    return dateString; 
	}
	/**
	 * ������ת����һ��ת��Ϊ��һ�ָ�ʽ
	 * @param time
	 */
	public static String dateFormatByOneToAnother(String dateStr,String orignFormat, String dateFormatAnother){ 
		Date date = DateHandler.StrToDateWithFormat(dateStr, orignFormat);
	   String dateString = DateHandler.dateToStringWithFormat(date, dateFormatAnother) ;
	    return dateString; 
	}
	//  ��ȡ��һ���ʱ��
	public static String nextDayString(String dateString) {
		Date date = StrToDate(dateString);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar = getAfterDay(calendar);
		System.out.println(dateToString( calendar.getTime()));
		return dateToString( calendar.getTime());
	}

}
