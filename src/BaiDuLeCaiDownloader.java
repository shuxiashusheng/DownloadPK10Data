import java.io.IOException;
import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class BaiDuLeCaiDownloader {

	public org.jsoup.nodes.Document document = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		http://baidu.lecai.com/lottery/draw/list/557?d=2016-10-01
//		baiDuleCai("http://baidu.lecai.com/lottery/draw/list/557?d=", "2016-10-01");	
		baiDuleCai_pk10("20150304");
	}

	public static ArrayList<CaiPiaoBaseModel> baiDuleCai_pk10(String dateString) {
		String baseUrl = "http://baidu.lecai.com/lottery/draw/list/557?d=";
		return baiDuleCai(baseUrl, dateString);
		
	}
	public static  ArrayList<CaiPiaoBaseModel> baiDuleCai(String urlString,String dateString) {
		
		ArrayList<CaiPiaoBaseModel> caiPiaoList = new ArrayList<CaiPiaoBaseModel>();
		String absoluteUrlString = urlString+dateString;
		System.out.println(absoluteUrlString);
		 org.jsoup.nodes.Document document = null;
		try {
			document = Jsoup.connect(absoluteUrlString).timeout(10000).get();
			Elements trs = document.select("#draw_list tbody tr");
			for (org.jsoup.nodes.Element element : trs) {
				Elements tds = element.getElementsByTag("td");
				String time = tds.get(0).text();
				String qiShu = tds.get(1).text();
				
				// 获取号码数
				Element numberElement = tds.get(2);
				Elements numberElements = numberElement.getElementsByClass("ball_1");
				ArrayList<String> numberList = new ArrayList<String>();
				String numberString = " ";
				for (Element element2 : numberElements) {
				String number = element2.text();
				
				// 将01格式改为1这样的数据格式
				if (number.substring(0, 1).equals("0")) {
					number = number.substring(1);
				}
				numberList.add(number);	
				numberString +=number;
				}	
				System.out.println(time+" "+qiShu+" "+numberString);
				CaiPiaoBaseModel model = new CaiPiaoBaseModel();
				model.setDate(DateHandler.dateFormatByOneToAnother(time, "yyyy-mm-dd", "yyyymmdd"));
				model.setIssue(qiShu);
				model.setNumbers(numberList);
				caiPiaoList.add(model);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		for (int i = 0; i < caiPiaoList.size(); i++) {
			
			System.out.println(caiPiaoList.get(i).getNumbers().toString());
		}
		return caiPiaoList;
	} 
}
